package com.luxvelocitas.tinytcx;

import com.luxvelocitas.tinytcx.trainingcenterdatabasev2.*;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.time.ZonedDateTime;
import java.util.Objects;


@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class TinyTcx {
    private static final String TCX_PACKAGE = "com.luxvelocitas.tinytcx.trainingcenterdatabasev2";
    private static final String TCX_NAMESPACE_URI = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2";
    private static final String TCX_SCHEMA_LOCATION =
        "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2 http://www.garmin.com/xmlschemas/TrainingCenterDatabasev2.xsd";

    private TrainingCenterDatabaseT mDatabase;
    private JAXBContext mJaxbContext;
    private int mCurActivity;
    private int mCurLap;
    private int mCurTrack;

    public TinyTcx() {
        try {
            mJaxbContext = JAXBContext.newInstance(TCX_PACKAGE);
        }
        catch(JAXBException ex) {
            throw new RuntimeException(ex);
        }

        mCurActivity = 0;
        mCurLap = 0;
        mCurTrack = 0;
    }

    /**
     * Get the underlying TrainingCenterDatabaseT object
     *
     * @return - The root TrainingCenterDatabaseT element
     */
    public TrainingCenterDatabaseT getDatabase() {
        return mDatabase;
    }

    /**
     * Get a specific Trackpoint object
     *
     * @param activity - The index of the Activity to reference
     * @param lap - The index of the ActivityLap within the Activity to reference
     * @param track - The index of the Track within the ActivityLap to reference
     * @param trackPoint - The index of the Trackpoint within the Track to reference
     * @return - The Trackpoint object which matches the given references
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
     * Get a specific Track object
     *
     * @param activity - The index of the Activity to reference
     * @param lap - The index of the ActivityLap within the Activity to reference
     * @param track - The index of the Track within the ActivityLap to reference
     * @return - The Track object which matches the given references
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
     * Get a specific ActivityLap object
     *
     * @param activity - The index of the Activity to reference
     * @param lap - The index of the ActivityLap within the Activity to reference
     * @return - The ActivityLap object which matches the given references
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
     * Get a specific Activity object
     *
     * @param activity - The index of the Activity to reference
     * @return - The Activity object which matches the given references
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
     * Find the number of Trackpoint objects in the given Track
     *
     * @param activity - The index of the Activity to reference
     * @param lap - The index of the ActivityLap within the Activity to reference
     * @param track - The index of the Track within the ActivityLap to reference
     * @return - The number of Trackpoint objects in the Track which matches the given references
     */
    public int getNumTrackpointsInTrack(int activity, int lap, int track) {
        return getTrack(activity, lap, track).getTrackpoint().size();
    }

    /**
     * Find the number of Track objects in the given ActivityLap
     *
     * @param activity - The index of the Activity to reference
     * @param lap - The index of the ActivityLap within the Activity to reference
     * @return - The number of Track objects in the ActivityLap which matches the given references
     */
    public int getNumTracksInLap(int activity, int lap) {
        return getLap(activity, lap).getTrack().size();
    }

    /**
     * Find the number of TrackpointT objects in the given Track
     *
     * @param activity - The index of the Activity to reference
     * @return - The number of ActivityLap objects in the Activity which matches the given references
     */
    public int getNumLapsInActivity(int activity) {
        return getActivity(activity).getLap().size();
    }

    /**
     * Find the number of TrackpointT objects in the given Track
     *
     * @return - The number of Activity objects in the TrainingCenterDatabase
     */
    public int getNumActivities() {
        return mDatabase
            .getActivities().getActivity().size();
    }

    /**
     * Append the given Trackpoint object
     * to the last Track of the last ActivityLap of the last Activity
     * of the TrainingCenterDatabase
     *
     * @param trackPoint - The Trackpoint to append
     * @return - This TinyTcx object to support chaining of method calls
     */
    public TinyTcx appendTrackpoint(TrackpointT trackPoint) {
        TrackT curTrack = getTrack(mCurActivity, mCurLap, mCurTrack);
        curTrack.getTrackpoint().add(trackPoint);

        return this;
    }

    /**
     * Append the given Track object
     * to the last ActivityLap of the last Activity
     * of the TrainingCenterDatabase
     *
     * @param track - The Track to append
     * @return - This TinyTcx object to support chaining of method calls
     */
    public TinyTcx appendTrack(TrackT track) {
        ActivityLapT curTLap = getLap(mCurActivity, mCurLap);
        curTLap.getTrack().add(track);

        return this;
    }

    /**
     * Append the given ActivityLap object
     * to the last Activity
     * of the TrainingCenterDatabase
     *
     * @param lap - The ActivityLap to append
     * @return - This TinyTcx object to support chaining of method calls
     */
    public TinyTcx appendLap(ActivityLapT lap) {
        ActivityT curActivity = getActivity(mCurActivity);
        curActivity.getLap().add(lap);

        return this;
    }

    /**
     * Append the given Activity object
     * of the TrainingCenterDatabase
     *
     * @param activity - The Activity to append
     * @return - This TinyTcx object to support chaining of method calls
     */
    public TinyTcx appendActivity(ActivityT activity) {
        mDatabase
            .getActivities().getActivity()
            .add(activity);

        return this;
    }

    /**
     * Set the author for the TrainingCenterDatabase
     *
     * @param author - The Author object to set
     * @return - This TinyTcx object to support chaining of method calls
     */
    public TinyTcx setAuthor(AbstractSourceT author) {
        mDatabase.setAuthor(author);
        return this;
    }

    /**
     * Set the DistanceMeters for the given specific ActivityLap
     *
     * @param activity - The index of the Activity to reference
     * @param lap - The index of the ActivityLap within the Activity to reference
     * @param value - The value to set
     * @return - This TinyTcx object to support chaining of method calls
     */
    public TinyTcx setDistanceMeters(int activity, int lap, double value) {
        ActivityLapT target = getLap(activity, lap);
        target.setDistanceMeters(value);
        return this;
    }

    /**
     * Set the MaximumSpeed for the given specific ActivityLap
     *
     * @param activity - The index of the Activity to reference
     * @param lap - The index of the ActivityLap within the Activity to reference
     * @param value - The value to set
     * @return - This TinyTcx object to support chaining of method calls
     */
    public TinyTcx setMaximumSpeed(int activity, int lap, double value) {
        ActivityLapT target = getLap(activity, lap);
        target.setMaximumSpeed(value);
        return this;
    }

    /**
     * Set the TotalTimeSeconds for the given specific ActivityLap
     *
     * @param activity - The index of the Activity to reference
     * @param lap - The index of the ActivityLap within the Activity to reference
     * @param value - The value to set
     * @return - This TinyTcx object to support chaining of method calls
     */
    public TinyTcx setTotalTimeSeconds(int activity, int lap, double value) {
        ActivityLapT target = getLap(activity, lap);
        target.setTotalTimeSeconds(value);
        return this;
    }

    /**
     * Set the Calories for the given specific ActivityLap
     *
     * @param activity - The index of the Activity to reference
     * @param lap - The index of the ActivityLap within the Activity to reference
     * @param value - The value to set
     * @return - This TinyTcx object to support chaining of method calls
     */
    public TinyTcx setCalories(int activity, int lap, int value) {
        ActivityLapT target = getLap(activity, lap);
        target.setCalories(value);
        return this;
    }

    /**
     * Set the AverageHeartRateBpm for the given specific ActivityLap
     *
     * @param activity - The index of the Activity to reference
     * @param lap - The index of the ActivityLap within the Activity to reference
     * @param value - The value to set
     * @return - This TinyTcx object to support chaining of method calls
     */
    public TinyTcx setAverageHeartRateBpm(int activity, int lap, short value) {
        ActivityLapT target = getLap(activity, lap);
        HeartRateInBeatsPerMinuteT hr = new HeartRateInBeatsPerMinuteT();
        hr.setValue(value);
        target.setAverageHeartRateBpm(hr);

        return this;
    }

    /**
     * Set the MaximumHeartRateBpm for the given specific ActivityLap
     *
     * @param activity - The index of the Activity to reference
     * @param lap - The index of the ActivityLap within the Activity to reference
     * @param value - The value to set
     * @return - This TinyTcx object to support chaining of method calls
     */
    public TinyTcx setMaximumHeartRateBpm(int activity, int lap, short value) {
        ActivityLapT target = getLap(activity, lap);
        HeartRateInBeatsPerMinuteT hr = new HeartRateInBeatsPerMinuteT();
        hr.setValue(value);
        target.setMaximumHeartRateBpm(hr);
        return this;
    }

    /**
     * Set the Intensity for the given specific ActivityLap
     * Values can be:
     *  - "Active"
     *  - "Resting"
     *
     * @param activity - The index of the Activity to reference
     * @param lap - The index of the ActivityLap within the Activity to reference
     * @param value - The value to set
     * @return - This TinyTcx object to support chaining of method calls
     */
    public TinyTcx setIntensity(int activity, int lap, String value) {
        ActivityLapT target = getLap(activity, lap);
        target.setIntensity(IntensityT.fromValue(value));
        return this;
    }

    /**
     * Set the Cadence for the given specific ActivityLap
     *
     * @param activity - The index of the Activity to reference
     * @param lap - The index of the ActivityLap within the Activity to reference
     * @param value - The value to set
     * @return - This TinyTcx object to support chaining of method calls
     */
    public TinyTcx setCadence(int activity, int lap, short value) {
        ActivityLapT target = getLap(activity, lap);
        target.setCadence(value);
        return this;
    }

    /**
     * Set the Notes for the given specific ActivityLap
     *
     * @param activity - The index of the Activity to reference
     * @param lap - The index of the ActivityLap within the Activity to reference
     * @param value - The value to set
     * @return - This TinyTcx object to support chaining of method calls
     */
    public TinyTcx setNotes(int activity, int lap, String value) {
        ActivityLapT target = getLap(activity, lap);
        target.setNotes(value);
        return this;
    }

    /**
     * Initialize with an empty TrainingCenterDatabase from the database template
     *
     * @return - This TinyTcx object to support chaining of method calls
     * @throws IOException - If there was a problem reading the database template
     */
    public TinyTcx init() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();

        // Get a File for the template from resources
        File file = new File(
            Objects.requireNonNull(
                classLoader.getResource("template.tcx")).getFile());

        // Load the template file as the TrainingCenterDatabase
        load(new FileInputStream(file));

        // Make sure all times are set to "now"
        this.getActivity(0).setId(ZonedDateTime.now());
        this.getLap(0, 0).setStartTime(ZonedDateTime.now());

        return this;
    }
    /**
     * Load the TrainingCenterDatabase from the given input stream
     *
     * @param inputStream - The input stream to read the database from
     * @return - This TinyTcx object to support chaining of method calls
     * @throws IOException - If there was a problem reading the input stream
     */
    public TinyTcx load(InputStream inputStream) throws IOException {
        try {
            Unmarshaller unmarshaller = mJaxbContext.createUnmarshaller();

            // Un-marshall the XML into an Java object
            JAXBElement<TrainingCenterDatabaseT> root =
                unmarshaller.unmarshal(
                        new StreamSource(inputStream),
                        TrainingCenterDatabaseT.class
                );
            mDatabase = root.getValue();

            // Move all pointers to the end
            mCurActivity = this.getNumActivities() - 1;
            mCurLap = this.getNumLapsInActivity(mCurActivity) - 1;
            mCurTrack = this.getNumTracksInLap(mCurActivity, mCurLap) - 1;

            return this;
        }
        catch (JAXBException ex) {
            throw new IOException(ex);
        }
    }

    /**
     * Write the TrainingCenterDatabase to the given output stream
     *
     * @param outputStream - The output stream to write to
     * @return - This TinyTcx object to support chaining of method calls
     * @throws IOException - If there was a problem writing to the output stream
     */
    public TinyTcx save(OutputStream outputStream) throws IOException {
        try {
            Marshaller marshaller = mJaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, TCX_SCHEMA_LOCATION);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            /*[XXX: use package-info instead]
            marshaller.setProperty(
                "com.sun.xml.internal.bind.namespacePrefixMapper",
                new TinyTcxNamespaceMapper());
            */

            // Marshall the TrainingCenterDatabase object into XML
            JAXBElement<TrainingCenterDatabaseT> root =
                new JAXBElement<>(
                        new QName(TCX_NAMESPACE_URI, "TrainingCenterDatabase"),
                        TrainingCenterDatabaseT.class,
                        mDatabase);

            marshaller.marshal(root, outputStream);

            return this;
        }
        catch (JAXBException ex) {
            throw new IOException(ex);
        }
    }
}
