package com.luxvelocitas.tinytcx;

import com.luxvelocitas.tinytcx.trainingcenterdatabasev2.*;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.time.ZonedDateTime;


@SuppressWarnings("unused")
public class TinyTcx {
    public static final String TCX_PACKAGE = "com.luxvelocitas.tinytcx.trainingcenterdatabasev2";
    public static final String TCX_NAMESPACE_URI = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2";
    public static final String TCX_SCHEMA_LOCATION =
            "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2 http://www.garmin.com/xmlschemas/TrainingCenterDatabasev2.xsd";

    protected TrainingCenterDatabaseT mDatabase;
    protected JAXBContext mJaxbContext;
    protected int mCurActivity;
    protected int mCurLap;
    protected int mCurTrack;

    /**
     * [TODO: Comments]
     *
     * @throws JAXBException
     */
    public TinyTcx() throws JAXBException {
        mJaxbContext = JAXBContext.newInstance(TCX_PACKAGE);

        mCurActivity = 0;
        mCurLap = 0;
        mCurTrack = 0;
    }

    /**
     * [TODO: Comments]
     *
     * @return
     */
    public TrainingCenterDatabaseT getDatabase() {
        return mDatabase;
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @param lap
     * @param track
     * @param trackPoint
     * @return
     */
    public TrackpointT getTrackpoint(int activity, int lap, int track, int trackPoint) {
        try {
            return mDatabase
                    .getActivities().getActivity().get(activity)
                    .getLap().get(lap)
                    .getTrack().get(track)
                    .getTrackpoint().get(trackPoint);
        }
        catch (Exception ex) {
            throw new IndexOutOfBoundsException(
                    "Could not get Trackpoint: " +
                            "Activity: " + activity +
                            ", Lap: " + lap +
                            ", Track: " + track +
                            ", Trackpoint: " + trackPoint);
        }
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @param lap
     * @param track
     * @return
     */
    public TrackT getTrack(int activity, int lap, int track) {
        try {
            return mDatabase
                    .getActivities().getActivity().get(activity)
                    .getLap().get(lap)
                    .getTrack().get(track);
        }
        catch (Exception ex) {
            throw new IndexOutOfBoundsException(
                    "Could not get Track: " +
                            "Activity: " + activity +
                            ", Lap: " + lap +
                            ", Track: " + track);
        }
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @param lap
     * @return
     */
    public ActivityLapT getLap(int activity, int lap) {
        try {
            return mDatabase
                    .getActivities().getActivity().get(activity)
                    .getLap().get(lap);
        }
        catch (Exception ex) {
            throw new IndexOutOfBoundsException(
                    "Could not get Lap: " +
                            "Activity: " + activity +
                            ", Lap: " + lap);
        }
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @return
     */
    public ActivityT getActivity(int activity) {
        try {
            return mDatabase
                    .getActivities().getActivity().get(activity);
        }
        catch (Exception ex) {
            throw new IndexOutOfBoundsException(
                    "Could not get Activity: " +
                            "Activity: " + activity);
        }
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @param lap
     * @param track
     * @return
     */
    public int getNumTrackpointsInTrack(int activity, int lap, int track) {
        return getTrack(activity, lap, track).getTrackpoint().size();
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @param lap
     * @return
     */
    public int getNumtracksInLap(int activity, int lap) {
        return getLap(activity, lap).getTrack().size();
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @return
     */
    public int getNumLapsInActivity(int activity) {
        return getActivity(activity).getLap().size();
    }

    /**
     * [TODO: Comments]
     *
     * @return
     */
    public int getNumActivities() {
        return mDatabase
                .getActivities().getActivity().size();
    }

    /**
     * [TODO: Comments]
     *
     * @param trackPoint
     * @return
     */
    public TinyTcx appendTrackpoint(TrackpointT trackPoint) {
        TrackT curTrack = getTrack(mCurActivity, mCurLap, mCurTrack);
        curTrack.getTrackpoint().add(trackPoint);

        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param track
     * @return
     */
    public TinyTcx appendTrack(TrackT track) {
        ActivityLapT curTLap = getLap(mCurActivity, mCurLap);
        curTLap.getTrack().add(track);

        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param lap
     * @return
     */
    public TinyTcx appendLap(ActivityLapT lap) {
        ActivityT curActivity = getActivity(mCurActivity);
        curActivity.getLap().add(lap);

        return this;
    }

    /**
     * [TODO: Comments]
     *
     * @param activity
     * @return
     */
    public TinyTcx appendActivity(ActivityT activity) {
        mDatabase
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
    public TinyTcx setAuthor(AbstractSourceT author) {
        mDatabase.setAuthor(author);
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
    public TinyTcx setDistanceMeters(int activity, int lap, double value) {
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
    public TinyTcx setMaximumSpeed(int activity, int lap, double value) {
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
    public TinyTcx setTotalTimeSeconds(int activity, int lap, double value) {
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
    public TinyTcx setCalories(int activity, int lap, int value) {
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
    public TinyTcx setAverageHeartRateBpm(int activity, int lap, short value) {
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
    public TinyTcx setMaximumHeartRateBpm(int activity, int lap, short value) {
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
    public TinyTcx setIntensity(int activity, int lap, String value) {
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
    public TinyTcx setCadence(int activity, int lap, short value) {
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
    public TinyTcx setNotes(int activity, int lap, String value) {
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
    public TinyTcx init() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("template.tcx").getFile());

        load(new FileInputStream(file));

        // Make sure all times are set to "now"
        this.getActivity(0).setId(ZonedDateTime.now());
        this.getLap(0, 0).setStartTime(ZonedDateTime.now());

        return this;
    }
    /**
     * [TODO: Comments]
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public TinyTcx load(InputStream inputStream) throws IOException {
        try {
            Unmarshaller unmarshaller = mJaxbContext.createUnmarshaller();

            JAXBElement<TrainingCenterDatabaseT> root =
                    unmarshaller.unmarshal(
                            new StreamSource(inputStream),
                            TrainingCenterDatabaseT.class
                    );
            mDatabase = root.getValue();

            // Move all pointers to the end
            mCurActivity = this.getNumActivities() - 1;
            mCurLap = this.getNumLapsInActivity(mCurActivity) - 1;
            mCurTrack = this.getNumtracksInLap(mCurActivity, mCurLap) - 1;

            return this;
        }
        catch (JAXBException ex) {
            throw new IOException(ex);
        }
    }

    /**
     * [TODO: Comments]
     *
     * @param outputStream
     * @throws IOException
     */
    public void save(OutputStream outputStream) throws IOException {
        try {
            Marshaller marshaller = mJaxbContext.createMarshaller();
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
                    mDatabase);

            marshaller.marshal(root, outputStream);
        }
        catch (JAXBException ex) {
            throw new IOException(ex);
        }
    }
}
