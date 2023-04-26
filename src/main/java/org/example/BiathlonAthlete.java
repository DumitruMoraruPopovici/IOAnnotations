package org.example;

import java.io.StringBufferInputStream;
import java.util.*;

/**
 * Class where all the athletes compete, are added to a list of athletes,
 * get sorted by finalTime and displayed in the sorted order
 */
public class BiathlonAthlete {

    List<Athlete> athleteList = new ArrayList<>();

    /**
     * method for adding an athlete and we return here a list of athletes
     */
    public void addAthlete (Athlete athlete) throws Exception {
        if(athlete == null) {
            throw new Exception("athlete cannot be null");
        }

        athleteList.add(athlete);
    }

    /**
     * method for sorting the list of athletes and print them in the sorted order
     */
    public List<Athlete> displayAthletesByTotalTime () {
        athleteList.sort(new FinalTimeComparator());
        int position = 1;
        for(Athlete athlete: athleteList) {
            System.out.println((position++)+ ". " + athlete);
        }
        return athleteList;
    }

}
