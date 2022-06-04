import Exceptions.FileNotFoundGameException;
import Exceptions.IllegalArgumentGameException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Configuration {
    private String mapLine;
    private String race;

    public String getMapLine() {return mapLine;}

    public String getRace() {return race;}


    public Configuration() throws FileNotFoundGameException,
                                  IllegalArgumentGameException,
                                  IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\Users\\orion\\OneDrive\\Рабочий стол\\input.txt"))) {
            mapLine = reader.readLine();
            race = reader.readLine();
        } catch (FileNotFoundException e) {
            System.err.println("Sorry, file not found. Please try again.");
            throw new FileNotFoundGameException();
        }
        Validator.checkInput(mapLine);
    }
}
