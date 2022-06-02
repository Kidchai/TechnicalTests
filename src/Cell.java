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
}
