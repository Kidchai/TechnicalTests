import java.util.HashMap;

public class Map {
    String mapLine;
    int height;
    int width;
    char[][] array;

    public Map(String mapLine, int height, int width) {
        this.mapLine = mapLine;
        this.height = height;
        this.width = width;
        array = new char[height][width];

        //заполнение массива буквами
        int index = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                array[y][x] = mapLine.charAt(index);
                index++;
            }
        }
    }

    public char get(int x, int y) {
        return array[y][x];
    }
}
