import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Solution {
    public static int getResult() {
        String mapLine = "";
        String race = "";

        //чтение из файла
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\orion\\OneDrive\\Рабочий стол\\input.txt"))) {
            mapLine = reader.readLine();
            race = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Validator.checkInput(mapLine);

        //словарь для стоимости разных типов клеток
        Map map = new Map(mapLine, 4, 4);
        HashMap<Character, Integer> costs = new HashMap<>();
        switch (race) {
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
                System.out.println("Sorry, the race of the creature is incorrect. Please, try again.");
                throw new IllegalArgumentException();
        }

        map.calculateCosts(map.get(0,0), costs);

        return map.get(3, 3).getCost();
    }
}
