import static org.junit.jupiter.api.Assertions.*;

import com.luxvelocitas.tinytcx.TinyTcx;
import com.luxvelocitas.tinytcx.trainingcenterdatabasev2.HeartRateInBeatsPerMinuteT;
import com.luxvelocitas.tinytcx.trainingcenterdatabasev2.TrackpointT;
import com.luxvelocitas.tinytcx.trainingcenterdatabasev2.TrainingCenterDatabaseT;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.ZonedDateTime;

class Tests {
    private static final String AUTHOR = "TinyTcx is the author!";
    private static final ZonedDateTime TIME = ZonedDateTime.now();
    private static final String SAMPLE_RESOURCE_FILENAME = "activity_1966020755.tcx";
    private static final String CREATE_TEST_PATH = "src/test/create.tcx";
    private static final String IDENTITY_TEST_PATH = "src/test/identity.tcx";

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    }

    @Test
    void createTcxFile() throws IOException {
        TinyTcx tcx = new TinyTcx().init();

        TrackpointT trackpoint1 = new TrackpointT();
        trackpoint1.setTime(TIME);
        trackpoint1.setHeartRateBpm(new HeartRateInBeatsPerMinuteT());
        trackpoint1.getHeartRateBpm().setValue((short)99);

        tcx.appendTrackpoint(trackpoint1);

        tcx.getDatabase()
                .getAuthor()
                .setName(AUTHOR);

        tcx.save(new FileOutputStream(new File(CREATE_TEST_PATH)));

        tcx.load(new FileInputStream(new File(CREATE_TEST_PATH)));

        assertNotNull(tcx.getDatabase());
        assertEquals(tcx.getDatabase().getClass(), TrainingCenterDatabaseT.class);
        assertEquals(tcx.getNumActivities(), 1);
        assertEquals(tcx.getNumLapsInActivity(0), 1);
        assertEquals(tcx.getNumTracksInLap(0, 0), 1);
        assertEquals(tcx.getNumTrackpointsInTrack(0, 0, 0), 1);
        assertEquals(tcx.getDatabase().getAuthor().getName(), AUTHOR);
        assertEquals(
            tcx.getDatabase()
                    .getActivities().getActivity().get(0)
                    .getLap().get(0)
                    .getTrack().get(0)
                    .getTrackpoint().get(0)
                    .getTime()
                    .toEpochSecond(),
            TIME.toEpochSecond()
        );
        assertEquals(
            tcx.getDatabase()
                    .getActivities().getActivity().get(0)
                    .getLap().get(0)
                    .getTrack().get(0)
                    .getTrackpoint().get(0)
                    .getHeartRateBpm()
                    .getValue(),
            99
        );
    }

    @Test
    void identityTcxFile() throws IOException {
        // Get a File for the template from resources
        InputStream is =
            getClass()
                .getClassLoader()
                .getResourceAsStream(SAMPLE_RESOURCE_FILENAME);

        // Load the sample TCX file
        TinyTcx tcx1 = new TinyTcx().load(is);

        // Save it out
        tcx1.save(new FileOutputStream(new File(IDENTITY_TEST_PATH)));

        // Read it back in
        TinyTcx tcx2 = new TinyTcx().load(new FileInputStream(new File(IDENTITY_TEST_PATH)));

        assertNotNull(tcx1.getDatabase());
        assertEquals(tcx1.getDatabase().getClass(), TrainingCenterDatabaseT.class);
        assertEquals(tcx2.getDatabase().getClass(), TrainingCenterDatabaseT.class);
        assertEquals(tcx1.getNumActivities(), tcx2.getNumActivities());
        assertEquals(tcx1.getNumLapsInActivity(0), tcx2.getNumLapsInActivity(0));
        assertEquals(tcx1.getNumTracksInLap(0, 0), tcx2.getNumTracksInLap(0, 0));
        assertEquals(tcx1.getNumTrackpointsInTrack(0, 0, 0), tcx2.getNumTrackpointsInTrack(0, 0, 0));
        assertEquals(tcx1.getDatabase().getAuthor().getName(), tcx2.getDatabase().getAuthor().getName());
        assertEquals(
                tcx1.getDatabase()
                        .getActivities().getActivity().get(0)
                        .getLap().get(0)
                        .getTrack().get(0)
                        .getTrackpoint().get(0)
                        .getTime()
                        .toEpochSecond(),
                tcx2.getDatabase()
                        .getActivities().getActivity().get(0)
                        .getLap().get(0)
                        .getTrack().get(0)
                        .getTrackpoint().get(0)
                        .getTime()
                        .toEpochSecond()
        );
        assertEquals(
                tcx1.getDatabase()
                        .getActivities().getActivity().get(0)
                        .getLap().get(0)
                        .getTrack().get(0)
                        .getTrackpoint().get(0)
                        .getHeartRateBpm()
                        .getValue(),
                tcx2.getDatabase()
                        .getActivities().getActivity().get(0)
                        .getLap().get(0)
                        .getTrack().get(0)
                        .getTrackpoint().get(0)
                        .getHeartRateBpm()
                        .getValue()
        );
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
        new File(CREATE_TEST_PATH).delete();
        new File(IDENTITY_TEST_PATH).delete();
    }

}
