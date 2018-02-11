package com.luxvelocitas.tinytcx;

import com.luxvelocitas.tinytcx.trainingcenterdatabasev2.HeartRateInBeatsPerMinuteT;
import com.luxvelocitas.tinytcx.trainingcenterdatabasev2.TrackpointT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.ZonedDateTime;


public class Main {
    public static void main(String[] argv) {
        try {
            TinyTcx tcx = new TinyTcx();
            tcx.init();

            TrackpointT trackpoint1 = new TrackpointT();
            trackpoint1.setTime(ZonedDateTime.now());
            trackpoint1.setHeartRateBpm(new HeartRateInBeatsPerMinuteT());
            trackpoint1.getHeartRateBpm().setValue((short)99);

            tcx.appendTrackpoint(trackpoint1);

            tcx.getDatabase()
                .getAuthor()
                .setName("TinyTcx is the author!");

            tcx.save(new FileOutputStream(new File("foo.tcx")));

            System.out.println("----------------------------------");

            tcx.load(new FileInputStream(new File("foo.tcx")));

            System.out.println(tcx.getDatabase());
            System.out.println(tcx.getDatabase().getClass());
            System.out.println("Activities: " + tcx.getNumActivities());
            System.out.println("Laps: " + tcx.getNumLapsInActivity(0));
            System.out.println("Tracks: " + tcx.getNumtracksInLap(0, 0));
            System.out.println("Track points: " + tcx.getNumTrackpointsInTrack(0, 0, 0));
            System.out.println(
                    tcx.getDatabase()
                            .getActivities().getActivity().get(0)
                            .getLap().get(0)
                            .getTrack().get(0)
                            .getTrackpoint().get(0)
                            .getTime()
            );
            System.out.println(
                tcx.getDatabase()
                    .getActivities().getActivity().get(0)
                    .getLap().get(0)
                    .getTrack().get(0)
                    .getTrackpoint().get(0)
                    .getHeartRateBpm()
                    .getValue()
            );
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
