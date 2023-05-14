package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AthleteTest {

    @Test
    void givenAShootingRangeCalculatePenalties() {
    Athlete athlete1 = new Athlete(12,"Uri", "UK", "32:12", "xxox", "xxoox", "ooxx");

    int result = athlete1.calculatePenalties();
    assertEquals(50,result);

    }

    @Test

    void givenAnAthleteCalculateTotalSeconds () {
        Athlete athlete1 = new Athlete(12,"Uri", "UK", "32:12", "xxox", "xxoox", "ooxx");
        athlete1.calculatePenalties();
        int result = athlete1.calculateTotalTimeInSeconds();

        assertEquals(1982, result);
    }
    @Test
    void givenAnAthleteCalculateTotalTime () {
        Athlete athlete1 = new Athlete(12,"Uri", "UK", "32:20", "xxox", "xxoox", "ooxx");
        athlete1.calculatePenalties();
        athlete1.calculateTotalTimeInSeconds();


        assertEquals("33:10", athlete1.calculateFinalTimeResult());
    }
}