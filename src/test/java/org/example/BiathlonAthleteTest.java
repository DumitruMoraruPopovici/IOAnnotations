package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BiathlonAthleteTest {

    @Test
    void givenAnAthleteAddAthlete() throws Exception {
        BiathlonAthlete myBiathlon = new BiathlonAthlete();
        Athlete athlete = new Athlete(1,"Dtu", "UK","30:08", "xoxox","xxx","xox");

        myBiathlon.addAthlete(athlete);

        assertEquals(1,myBiathlon.athleteList.size());


    }

    @Test
    void givenAnAthleteCheckIfIsNotNull () {
        BiathlonAthlete myBiathlon = new BiathlonAthlete();

        Athlete athlete = new Athlete(2, "dsf", "dsd", "23:23", "xx","sds", "ds");

        assertNotNull(athlete,"Object is not null");

    }

    @Test
    void givenAnNullAthleteCheckAddAthlete () throws Exception {
        BiathlonAthlete myBiathlon = new BiathlonAthlete();
        Athlete athlete = null;

        myBiathlon.addAthlete(athlete);

        assertEquals(0, myBiathlon.athleteList.size());

    }

    @Test

    void givenTwoAthletesCheckSize () throws Exception {
        BiathlonAthlete myBiathlon = new BiathlonAthlete();
        Athlete athlete = new Athlete(2, "dsf", "dsd", "23:23", "xx","sds", "ds");
        Athlete athlete1 = new Athlete(3, "d32f", "dsasd", "23:23", "ox","sds", "ds");

        myBiathlon.addAthlete(athlete);
        myBiathlon.addAthlete(athlete1);

        assertEquals(2, myBiathlon.athleteList.size());
    }

    @Test

    void givenTwoAthletesCheckSortingByComparator () throws Exception {
        BiathlonAthlete myBiathlon = new BiathlonAthlete();
        List<Athlete> athleteList = new ArrayList<>();
        Athlete athlete = new Athlete(2, "dsf", "dsd", "23:23", "xx","sds", "ds");
        Athlete athlete1 = new Athlete(3, "d32f", "dsasd", "23:23", "ox","sds", "ds");

        athleteList.add(athlete);
        athleteList.add(athlete1);
        myBiathlon.addAthlete(athlete);
        myBiathlon.addAthlete(athlete1);

        List<Athlete> athletesForCheck = athleteList;
        athletesForCheck.sort(new FinalTimeComparator());


        assertEquals(athletesForCheck, myBiathlon.displayAthletesByTotalTime());

    }
}