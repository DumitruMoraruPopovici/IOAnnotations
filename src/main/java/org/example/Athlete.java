package org.example;

/**
 * Blueprint for athlete objects with properties and behavior
 */
public class Athlete  {

    protected int numberId;
    protected String name;
    protected String countryCode;

    protected String skiTimeResult;
    protected String firstShootingRange;
    protected String secondShootingRange;
    protected String thirdShootingRange;


    protected int penalties = 0;

    protected int skiTimeResultInSeconds = 0;

    protected int totalResultInSeconds;

    protected String finalTimeResult;

    /**
     * the constructor for athlete object
     */
    public Athlete(int number, String name, String countryCode, String skiTimeResult, String firstShootingRange, String secondShootingRange, String thirdShootingRange) {
        this.numberId = number;
        this.name = name;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;

    }

    /**
     * Method to calculate total penalties for athlete and returns the total amount of second he looses
     */
    public int calculatePenalties() {
        String totalShootingRange = firstShootingRange + secondShootingRange + thirdShootingRange;
        for (int i = 0; i < totalShootingRange.length(); i++) {
            if ('o' == totalShootingRange.charAt(i)) {
                penalties += 10;
            }

        }
        return penalties;
    }

    /**
     *Method where we calculate total amount of time plus penalties and transforms the result in seconds
     */
    public int calculateTotalTimeInSeconds() {
        String[] skiTimeArr = skiTimeResult.split(":");
        int minute = Integer.parseInt(skiTimeArr[0]);
        int second = Integer.parseInt(skiTimeArr[1]);
        skiTimeResultInSeconds = minute * 60 + second;
        totalResultInSeconds = skiTimeResultInSeconds + penalties;
        return totalResultInSeconds;
    }

    /**
     * Method where we transform the total seconds back to string and we returned it in to an variable
     */
    public String calculateFinalTimeResult() {
        calculateTotalTimeInSeconds();
        return finalTimeResult = totalResultInSeconds/60 + ":" + totalResultInSeconds%60;

    }

    /**
     * Method for printing the object
     */
    @Override
    public String toString() {
        return "Athlete number=" + numberId +
                ", with name " + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", skiTimeResult='" + skiTimeResult + '\'' +
                ", firstShootingRange='" + firstShootingRange + '\'' +
                ", secondShootingRange='" + secondShootingRange + '\'' +
                ", thirdShootingRange='" + thirdShootingRange;
    }
}
