import Exceptions.FileNotFoundGameException;
import Exceptions.IllegalArgumentGameException;

import java.io.*;
import java.util.HashMap;

public class Configuration {
    private String mapLine;
    private String race;

    public String getMapLine() {return mapLine;}

    public String getRace() {return race;}

    public Configuration(String filePath) throws FileNotFoundGameException,
                                                 IllegalArgumentGameException,
                                                 IOException {
        if (filePath.length() != 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                mapLine = reader.readLine();
                race = reader.readLine();
            } catch (FileNotFoundException e) {
                System.err.println("Sorry, file not found. Please try again.");
                throw new FileNotFoundGameException();
            }
        } else {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                mapLine = reader.readLine();
                race = reader.readLine();
            }
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
