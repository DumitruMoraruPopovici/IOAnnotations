package org.example;

import java.util.Comparator;

public class FinalTimeComparator implements Comparator<Athlete> {

    @Override
    public int compare(Athlete o1, Athlete o2) {
        return Integer.compare(o1.totalResultInSeconds, o2.totalResultInSeconds);
    }
}
