import java.util.ArrayList;

public class Cell {
    private int x;
    private int y;
    private Map map;
    private char cellType;

    public Cell(int x, int y, Map map, char cellType) {
        this.x = x;
        this.y = y;
        this.map = map;
        this.cellType = cellType;
    }

    public int getX() {return x;}

    public int getY() {return y;}

    public Map getMap() {return map;}

    public char getCellType() {return cellType;}

    public ArrayList<Cell> getNeighbours() {
        ArrayList<Cell> list = new ArrayList<>();
        if (this.getX() != 0) {
            list.add(this.map.get(x - 1, y));
        }

        if (this.getY() != 0) {
            list.add(this.map.get(x, y - 1));
        }

        if (this.getX() != map.width - 1) {
            list.add(this.map.get(x + 1, y));
        }

        if (this.getY() != map.height - 1) {
            list.add(this.map.get(x, y + 1));
        }
        return list;
    }
}
