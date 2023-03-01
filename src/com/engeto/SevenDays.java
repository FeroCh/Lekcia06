package com.engeto;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class SevenDays {
    public static void main(String[] args) {
        LocalDate dateOfWatering = LocalDate.now().minusDays((long) Math.floor(Math.random() * 14));
        LocalDate today = LocalDate.now();
        String isBetween = "";
        if (ChronoUnit.DAYS.between(dateOfWatering, today) < 7) isBetween = "is";
        else isBetween = "is NOT";
        System.out.println("" + dateOfWatering + " " + isBetween + " within last seven days!");
    }
}
