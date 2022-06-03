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

        //словарь для стоимости разных типов клеток
        Map map = new Map(mapLine, 4, 4);
        HashMap<Character, Integer> costs = new HashMap<>();
        costs.put('S', 5);
        costs.put('W', 2);
        costs.put('T', 3);
        costs.put('P', 1);

        map.calculateCosts(map.get(0,0), costs);

        return map.get(3, 3).getCost();
    }
}
