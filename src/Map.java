import java.util.HashMap;

public class Map {
    String mapLine;
    int height;
    int width;

    public Map(String mapLine, int height, int width) {
        this.mapLine = mapLine;
        this.height = height;
        this.width = width;
        char[][] array = new char[height][width];
        //создание словарей для рас


//    HashMap<Character, Integer> human = new HashMap<>();
//        human.put('S', 5);
//        human.put('W', 2);
//        human.put('T', 3);
//        human.put('P', 1);

        //заполнение массива буквами
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = mapLine.charAt(index);
                index++;
            }
        }

//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                array[i][j] = human.get(map.charAt(index));
//                index++;
//            }
//        }
    }
}
