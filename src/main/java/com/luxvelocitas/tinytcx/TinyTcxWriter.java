package com.luxvelocitas.tinytcx;

import com.luxvelocitas.tinytcx.trainingcenterdatabasev2.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.*;
import java.time.ZonedDateTime;


@SuppressWarnings("unused")
public class TinyTcxWriter extends TinyTcxReader {
    protected int curActivity;
    protected int curLap;
    protected int curTrack;

    /**
     * [TODO: Comments]
     *
     * @throws JAXBException
     */
    public TinyTcxWriter() throws JAXBException {
        super();

        this.curActivity = 0;
        this.curLap = 0;
        this.curTrack = 0;
    }

    /**
     * [TODO: Comments]
     *
     * @param trackPoint
     * @return
     */
    public TinyTcxReader appendTrackPoint(TrackpointT trackPoint) {
        TrackT curTrack = getTrack(this.curActivity, this.curLap, this.curTrack);
        curTrack.getTrackpoint().add(trackPoint);

        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param track
     * @return
     */
    public TinyTcxReader appendTrack(TrackT track) {
        ActivityLapT curTLap = getLap(this.curActivity, this.curLap);
        curTLap.getTrack().add(track);

        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param lap
     * @return
     */
    public TinyTcxReader appendLap(ActivityLapT lap) {
        ActivityT curActivity = getActivity(this.curActivity);
        curActivity.getLap().add(lap);

        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @return
     */
    public TinyTcxReader appendActivity(ActivityT activity) {
        this.database
            .getActivities().getActivity()
            .add(activity);

        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param author
     * @return
     */
    public TinyTcxReader setAuthor(AbstractSourceT author) {
        this.database.setAuthor(author);
        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @param lap
     * @param value
     * @return
     */
    public TinyTcxWriter setDistanceMeters(int activity, int lap, double value) {
        ActivityLapT target = getLap(activity, lap);
        target.setDistanceMeters(value);
        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @param lap
     * @param value
     * @return
     */
    public TinyTcxWriter setMaximumSpeed(int activity, int lap, double value) {
        ActivityLapT target = getLap(activity, lap);
        target.setMaximumSpeed(value);
        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @param lap
     * @param value
     * @return
     */
    public TinyTcxWriter setTotalTimeSeconds(int activity, int lap, double value) {
        ActivityLapT target = getLap(activity, lap);
        target.setTotalTimeSeconds(value);
        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @param lap
     * @param value
     * @return
     */
    public TinyTcxWriter setCalories(int activity, int lap, int value) {
        ActivityLapT target = getLap(activity, lap);
        target.setCalories(value);
        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @param lap
     * @param value
     * @return
     */
    public TinyTcxWriter setAverageHeartRateBpm(int activity, int lap, short value) {
        ActivityLapT target = getLap(activity, lap);
        HeartRateInBeatsPerMinuteT hr = new HeartRateInBeatsPerMinuteT();
        hr.setValue(value);
        target.setAverageHeartRateBpm(hr);

        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @param lap
     * @param value
     * @return
     */
    public TinyTcxWriter setMaximumHeartRateBpm(int activity, int lap, short value) {
        ActivityLapT target = getLap(activity, lap);
        HeartRateInBeatsPerMinuteT hr = new HeartRateInBeatsPerMinuteT();
        hr.setValue(value);
        target.setMaximumHeartRateBpm(hr);
        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @param lap
     * @param value
     * @return
     */
    public TinyTcxWriter setIntensity(int activity, int lap, String value) {
        ActivityLapT target = getLap(activity, lap);
        target.setIntensity(IntensityT.fromValue(value));
        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @param lap
     * @param value
     * @return
     */
    public TinyTcxWriter setCadence(int activity, int lap, short value) {
        ActivityLapT target = getLap(activity, lap);
        target.setCadence(value);
        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @param lap
     * @param value
     * @return
     */
    public TinyTcxWriter setNotes(int activity, int lap, String value) {
        ActivityLapT target = getLap(activity, lap);
        target.setNotes(value);
        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @return
     * @throws IOException
     */
    public TinyTcxWriter init() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("template.tcx").getFile());

        load(new FileInputStream(file));

        // Make sure all times are set to "now"
        this.getActivity(0).setId(ZonedDateTime.now());
        this.getLap(0, 0).setStartTime(ZonedDateTime.now());

        return this;
    }

    @Override
    public TinyTcxReader load(InputStream inputStream) throws IOException {
        super.load(inputStream);

        // Move all pointers to the end
        this.curActivity = this.getNumActivities() - 1;
        this.curLap = this.getNumLapsInActivity(this.curActivity) - 1;
        this.curTrack = this.getNumtracksInLap(this.curActivity, this.curLap) - 1;

        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param outputStream
     * @throws IOException
     */
    public void save(OutputStream outputStream) throws IOException {
        try {
            Marshaller marshaller = this.jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, AbstractTinyTcx.TCX_SCHEMA_LOCATION);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            /*[XXX: use package-info instead]
            marshaller.setProperty(
                "com.sun.xml.internal.bind.namespacePrefixMapper",
                new TinyTcxNamespaceMapper());
            */

            JAXBElement<TrainingCenterDatabaseT> root =
                new JAXBElement<TrainingCenterDatabaseT>(
                    new QName(AbstractTinyTcx.TCX_NAMESPACE_URI, "TrainingCenterDatabase"),
                    TrainingCenterDatabaseT.class,
                    this.database);

            marshaller.marshal(root, outputStream);
        }
        catch (JAXBException ex) {
            throw new IOException(ex);
        }
    }
}
