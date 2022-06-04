import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    private int height;
    private int width;
    private Cell[][] array;

    public int getHeight() {return height;}

    public int getWidth() {return width;}

    public Map(String mapLine, int height, int width) {
        this.height = height;
        this.width = width;
        array = new Cell[height][width];

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

    public void calculateCosts(Cell startCell, HashMap<Character, Integer> costs) {
        startCell.setCost(0);
        ArrayList<Cell> list = startCell.getNeighbours();
        ArrayList<Cell> newList = new ArrayList<>();

        for (Cell cell: list) {
            int newCost = (startCell.getCost() + costs.get(cell.getCellType()));
            if (newCost < cell.getCost()) {
                cell.setCost(newCost);
                newList.add(cell);
            }
        }

        java.util.Map<Cell, ArrayList<Cell>> cellsNeighbours;

        while (!newList.isEmpty()) {
            cellsNeighbours = new HashMap<>();

            for (Cell cell: newList) {
                cellsNeighbours.put(cell, cell.getNeighbours());
            }

            newList.clear();

            for(java.util.Map.Entry<Cell, ArrayList<Cell>> entry: cellsNeighbours.entrySet()) {
                Cell cell = entry.getKey();
                ArrayList<Cell> listOfNeighbours = entry.getValue();
                for (Cell neighbourCell: listOfNeighbours) {
                    int newCost = (cell.getCost() + costs.get(neighbourCell.getCellType()));
                    if (newCost < neighbourCell.getCost()) {
                        neighbourCell.setCost(newCost);
                        newList.add(neighbourCell);
                    }
                }
            }
        }
    }
}
