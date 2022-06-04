import Exceptions.FileNotFoundGameException;
import Exceptions.IllegalArgumentGameException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

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

    public HashMap<Character, Integer> getRaceCosts() throws IllegalArgumentGameException {
        HashMap<Character, Integer> costs = new HashMap<>();
        switch (getRace()) {
            case "Human":
                costs.put('S', 5);
                costs.put('W', 2);
                costs.put('T', 3);
                costs.put('P', 1);
                break;
            case "Swamper":
                costs.put('S', 2);
                costs.put('W', 2);
                costs.put('T', 5);
                costs.put('P', 2);
                break;
            case "Woodman":
                costs.put('S', 3);
                costs.put('W', 3);
                costs.put('T', 2);
                costs.put('P', 2);
                break;
            default:
                System.err.println("Sorry, the race of the creature is incorrect. Please, try again.");
                throw new IllegalArgumentGameException();
        }
        return costs;
    }
}
