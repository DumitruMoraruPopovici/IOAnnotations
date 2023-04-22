package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * DESCRIPTION - Ski Biathlon Standings
 * write a software that takes as an input a CSV file where every entry represents the results of a biathlon athlete
 * based on the entries identify the first 3 places (Winner, Runner-up and Third Place)
 * the rules are simple, each athlete has a time-results for the entire skiing session, and 3 shooting range results
 * each shooting range has 5 shot results
 * for every missed shot the athlete obtains a 10 second penalty which affects the final time-result
 * final standings are based on the time-results that have been updated with the shooting range results
 * <p>
 *     athlete, shootingRange
 *     timeResult, finalTimeResult, penalty , shooting;

 * CSV example
 * <p>
 * 11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo
 * <p>
 * 1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo
 * <p>
 * 27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx
 * <p>
 * COLUMNS
 * <p>
 * AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange.SecondShooting,ThirdShooting
 * <p>
 * every shooting range consists of 5 characters, where x means hit, o mean miss
 * for every o there should be 10 seconds added to the final time
 * <p>
 * RESULTS
 * <p>
 * Winner - Piotr Smitzer 30:10 (30:10 + 0)
 * <p>
 * Runner-up - Jimmy Smiles 30:15 (29:15 + 60)
 * <p>
 * Third Place - Umar Jorgson 30:57 (30:27 + 30)
 * <p>
 * TASK
 * <p>
 * write tests for the CSV parsing and the standing calculation
 * <p>
 * in the your tests you must not use real files
 * <p>
 * make sure the CSVs are read from memory to keep the tests fast
 * <p>
 * use Comparator / Comparable for sorting
 * <p>
 * use at least 1 Enum (in any situation) and at least 2 Annotations (they don't need to be custom)
 */
public class App {
    public static void main(String[] args) throws Exception {
       BiathlonAthlete myBiathlon = new BiathlonAthlete();
        /**
         * REading the file
         */
       Scanner csvReader = new Scanner(new File("file.csv"));
       csvReader.useDelimiter(",");
       while (csvReader.hasNext()) {
           System.out.println(csvReader.next());

       }
       csvReader.close();


        Athlete athlete2 = new Athlete(1,"Dtu", "UK","30:08", "xoxox","xxx","xox");
        Athlete athlete3 = new Athlete(4,"Dtuyt", "UK","29:08", "xxxxx","xxx","xox");
        Athlete athlete1 = new Athlete(12,"Dutu", "UK","30:12", "xxxox","xxx","xox");
        int penalties = athlete1.calculatePenalties();
        System.out.println(penalties);
        String totalTime = athlete1.calculateFinalTimeResult();
        System.out.println(totalTime);
       myBiathlon.addAthlete(athlete1);
       myBiathlon.addAthlete(athlete2);
       myBiathlon.addAthlete(athlete3);
       myBiathlon.displayAthletesByTotalTime();


    }
}