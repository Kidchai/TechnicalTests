import java.util.ArrayList;
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

    public void calculateCosts(Cell startCell, HashMap<Character, Integer> costs) {
        startCell.setCost(0);
        ArrayList<Cell> list = startCell.getNeighbours();
        ArrayList<Cell> newList = new ArrayList<>();

        for (Cell cell: list) {
            int newCost = (startCell.getCost() + costs.get(cell.getCellType()));
            if (newCost < cell.getCost()) {
                cell.setCost(newCost);
                newList.add(cell);
                System.out.println(cell.getX()+" "+cell.getY()+" "+cell.getCost());
            }
            //для каждой клетки вычислить стоимость попадания в неё (cost)
            //если её cost, меньше чем текущий cost, то cost новой клетки менятся
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
                        System.out.println(neighbourCell.getX()+" "+neighbourCell.getY()+" "+neighbourCell.getCost());
                    }
                }
            }
        }


        //если новый cost (стоимость текущего сell + стоимость перехода на новый cell)
        //меньше, чем текущий cost, то мы меняем стоимость нового cell
        //cost - (нынешняя клетка + соседняя) для НЕсоседей бесконечно большое число
        //cell - объект с типом местности, координатами и cost
    }
}
