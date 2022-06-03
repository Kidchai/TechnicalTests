import java.util.HashMap;

public class Map {
    String mapLine; //прописать геттеры, чтобы получать через методы get, а эти переменные сделать private?
    int height;
    int width;
    Cell[][] array;

    public Map(String mapLine, int height, int width) {
        this.mapLine = mapLine;
        this.height = height;
        this.width = width;
        array = new Cell[height][width];

        //заполнение массива cell'ами
        int index = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                array[y][x] = new Cell(x, y, this, mapLine.charAt(index));
                index++;
            }
        }
    }

    public Cell get(int x, int y) {
        return array[y][x];
    }
}
