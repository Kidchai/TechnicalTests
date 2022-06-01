import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println(getResult());
    }

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

        //заполнение массива цифрами
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                switch (map.charAt(index)) {
                    case 'S':
                        array[i][j] = 5;
                        break;
                    case 'W':
                        array[i][j] = 2;
                        break;
                    case 'T':
                        array[i][j] = 3;
                        break;
                    case 'P':
                        array[i][j] = 1;
                        break;
                }
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