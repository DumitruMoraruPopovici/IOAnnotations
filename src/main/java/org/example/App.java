package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    public static void main(String[] args) throws IOException {
       BiathlonAthlete myBiathlon = new BiathlonAthlete();
/**
 * reading and maping from file in to athlete objects
 */
       Path path = Path.of("file.csv");
        List<Athlete> athletesList =  Files.lines(path).map(App::getAthlete)

                .collect(Collectors.toList());
        System.out.println(athletesList);
        myBiathlon.addAthlete(athletesList.get(0));
        myBiathlon.addAthlete(athletesList.get(1));
        myBiathlon.addAthlete(athletesList.get(2));

        int penalties = myBiathlon.athleteList.get(0).calculatePenalties();
        System.out.println(penalties);
        String totalTime = myBiathlon.athleteList.get(0).calculateFinalTimeResult();
        System.out.println(totalTime);

       myBiathlon.displayAthletesByTotalTime();


    }

    private static Athlete getAthlete(String line) {
        String[] values = line.split(",");
        return new Athlete(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4], values[5], values[6]);

    }
}