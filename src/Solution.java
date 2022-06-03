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

        //движение по массиву
        int sum = 0;
        int y = 0;
        int x = 0;

        while (y < map.height - 1) { //движение вниз
            y++;
            sum += costs.get(map.get(x, y).getCellType());
            System.out.println(x + " " + y + " " + costs.get(map.get(x, y).getCellType()) + " " + sum);
        }
        while (x < map.width - 1) { //движение налево
            x++;
            sum += costs.get(map.get(x, y).getCellType());
            System.out.println(x + " " + y + " " + costs.get(map.get(x, y).getCellType()) + " " + sum);
        }

        return sum;
    }
}
