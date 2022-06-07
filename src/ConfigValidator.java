import Exceptions.IllegalArgumentGameException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigValidator {
    public static void checkMapLine(String mapLine) throws IllegalArgumentGameException {
        if (mapLine.length() != 16) {
            System.err.println("Sorry, the length of the first line should be 16 symbols. Please, try again.");
            throw new IllegalArgumentGameException();
        }

        Pattern pattern = Pattern.compile(".*[^SWTP].*");
        Matcher matcher = pattern.matcher(mapLine);
        if (matcher.matches()) {
            System.err.println("Sorry, the first line contains symbols other than 'S', 'W,' 'T,' 'P.' " +
                                "Please, try again.");
            throw new IllegalArgumentGameException();
        }
    }

    public static void checkRace(String race) throws IllegalArgumentGameException {
        if (!race.equals("Human") && !race.equals("Swamper") && !race.equals("Woodman")) {
            System.err.println("Sorry, the race of the creature is incorrect. Please, try again.");
            throw new IllegalArgumentGameException();
        }
    }
}
