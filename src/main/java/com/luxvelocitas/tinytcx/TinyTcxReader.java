package com.luxvelocitas.tinytcx;

import com.luxvelocitas.tinytcx.trainingcenterdatabasev2.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * [TODO: Comments]
 */
public class TinyTcxReader extends AbstractTinyTcx {
    /**
     * [TODO: Comments]
     *
     * @throws JAXBException
     */
    public TinyTcxReader() throws JAXBException {
        super();
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
    public TrackpointT getTrackPoint(int activity, int lap, int track, int trackPoint) {
        try {
            return this.database
                .getActivities().getActivity().get(activity)
                .getLap().get(lap)
                .getTrack().get(track)
                .getTrackpoint().get(trackPoint);
        }
        catch (Exception ex) {
            throw new IndexOutOfBoundsException(
                "Could not get TrackPoint: " +
                "Activity: " + activity +
                ", Lap: " + lap +
                ", Track: " + track +
                ", TrackPoint: " + trackPoint);
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
            return this.database
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
            return this.database
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
            return this.database
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
    public int getNumTrackPointsInTrack(int activity, int lap, int track) {
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
        return this.database
            .getActivities().getActivity().size();
    }

    /**
     * [TODO: Comments]
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public TinyTcxReader load(InputStream inputStream) throws IOException {
        try {
            Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();

            JAXBElement<TrainingCenterDatabaseT> root =
                unmarshaller.unmarshal(
                        new StreamSource(inputStream),
                        TrainingCenterDatabaseT.class
                );
            this.database = root.getValue();

            return this;
        }
        catch (JAXBException ex) {
            throw new IOException(ex);
        }
    }
}
