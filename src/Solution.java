import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

        Map map = new Map(mapLine, 4, 4);

        //движение по массиву
        int sum = 0;
        for (int y = 0; y < map.height; y++) { //движение вниз
//            sum += array[i][0];
            sum += 1;
        }
        for (int x = 0; x < map.width; x++) { //движение налево
//            sum += array[3][i];
            sum += 1;
        }

        //return sum - array[0][0] - array[3][0];
        return sum;
    }
}
