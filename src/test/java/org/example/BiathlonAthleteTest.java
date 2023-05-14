package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiathlonAthleteTest {

    @Test
    void givenAnAthleteAddAthlete() {
        BiathlonAthlete myBiathlon = new BiathlonAthlete();
        Athlete athlete = new Athlete(1,"Dtu", "UK","30:08", "xoxox","xxx","xox");

        myBiathlon.addAthlete(athlete);

        assertEquals(1,myBiathlon.athleteList.size());


    }


}