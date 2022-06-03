import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void checkInput(String mapLine) {
        if (mapLine.length() != 16) {
            System.out.println("Sorry, the length of the first line should be 16 symbols. Please, try again.");
            throw new IllegalArgumentException();
        }

        Pattern pattern = Pattern.compile(".*[^SWTP].*");
        Matcher matcher = pattern.matcher(mapLine);
        if (matcher.matches()) {
            System.out.println("Sorry, the first line contains symbols other than 'S', 'W,' 'T,' 'P.' Please, try again.");
            throw new IllegalArgumentException();
        }
    }
}
