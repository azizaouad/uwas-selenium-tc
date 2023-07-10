package stepDefinitions;

import java.time.LocalDate;
import java.util.Random;

public class RandomDateGenerator {
    private static Random random = new Random();

    public static String generateRandomDate(int startYear, int endYear) {
        // Generate a random year between startYear and endYear
        int year = random.nextInt(endYear - startYear + 1) + startYear;

        // Generate a random month between 1 and 12
        int month = random.nextInt(12) + 1;

        // Generate a random day between 1 and the maximum number of days in the selected month
        int day = random.nextInt(LocalDate.of(year, month, 1).lengthOfMonth()) + 1;
        LocalDate randomDate =LocalDate.of(year, month, day);
        String randomdateString = randomDate.toString ();

        return randomdateString;
    }
}




















