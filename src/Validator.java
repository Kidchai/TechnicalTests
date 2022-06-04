import Exceptions.IllegalArgumentGameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void checkInput(String mapLine) throws IllegalArgumentGameException {
        if (mapLine.length() != 16) {
            System.err.println("Sorry, the length of the first line should be 16 symbols. Please, try again.");
            throw new IllegalArgumentGameException();
        }

        Pattern pattern = Pattern.compile(".*[^SWTP].*");
        Matcher matcher = pattern.matcher(mapLine);
        if (matcher.matches()) {
            System.err.println("Sorry, the first line contains symbols other than 'S', 'W,' 'T,' 'P.' Please, try again.");
            throw new IllegalArgumentGameException();
        }
    }
}
