import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Solution {
    public static int getResult() {
        String map = "";
        int[][] array = new int[4][4];
        //чтение из файла
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\orion\\OneDrive\\Рабочий стол\\input.txt"))) {
            map = reader.readLine();
            //String race = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //создание словарей для рас
        int index = 0;
        HashMap<Character, Integer> human = new HashMap<>();
        human.put('S', 5);
        human.put('W', 2);
        human.put('T', 3);
        human.put('P', 1);

        //заполнение массива цифрами
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = human.get(map.charAt(index));
                index++;
            }
        }

        //движение по массиву
        int sum = 0;
        for (int i = 0; i < array.length; i++) { //движение вниз
            sum += array[i][0];
        }
        for (int i = 0; i < array[0].length; i++) { //движение налево
            sum += array[3][i];
        }

        return sum - array[0][0] - array[3][0];
    }
}
