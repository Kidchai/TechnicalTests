import Exceptions.FileNotFoundGameException;
import Exceptions.IllegalArgumentGameException;

import java.io.*;
import java.util.HashMap;

public class Configuration {
    private String mapLine;
    private String race;

    public String getMapLine() {return mapLine;}

    public String getRace() {return race; }

    public Configuration(String filePath) throws FileNotFoundGameException,
                                                 IllegalArgumentGameException,
                                                 IOException {
        try (var reader = new BufferedReader(filePath.length() > 0 ? new FileReader(filePath) : new InputStreamReader(System.in))) {
            setConfig(reader.readLine(), reader.readLine());
        } catch (FileNotFoundException e) {
            System.err.println("Sorry, file not found. Please try again.");
            throw new FileNotFoundGameException();
        }
    }

    public Configuration(String mapLine, String race) throws IllegalArgumentGameException {
        setConfig(mapLine, race);
    }

    public HashMap<Character, Integer> getRaceCosts() {
        HashMap<Character, Integer> costs = new HashMap<>();
        switch (getRace()) {
            case "Human" -> {
                costs.put('S', 5);
                costs.put('W', 2);
                costs.put('T', 3);
                costs.put('P', 1);
            }
            case "Swamper" -> {
                costs.put('S', 2);
                costs.put('W', 2);
                costs.put('T', 5);
                costs.put('P', 2);
            }
            case "Woodman" -> {
                costs.put('S', 3);
                costs.put('W', 3);
                costs.put('T', 2);
                costs.put('P', 2);
            }
        }
        return costs;
    }

    private void setConfig(String mapLine, String race) throws IllegalArgumentGameException {
        ConfigValidator.checkMapLine(mapLine);
        ConfigValidator.checkRace(race);
        this.mapLine = mapLine;
        this.race = race;
    }
}
