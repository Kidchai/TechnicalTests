import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class CellTest extends TestCase {

    @Test
    public void testGetNeighboursForX0Y0() {
        ArrayList<Cell> actual;
        String mapLine = "STWSWTPPTPTTPWPP";
        Map map = new Map(mapLine, 4, 4);
        actual = map.get(0, 0).getNeighbours();

        ArrayList<Cell> expected = new ArrayList<>();
        expected.add(map.get(1, 0));
        expected.add(map.get(0, 1));

        assertEquals(expected, actual);
    }

    @Test
    public void testGetNeighboursForX1Y1() {
        ArrayList<Cell> actual;
        String mapLine = "STWSWTPPTPTTPWPP";
        Map map = new Map(mapLine, 4, 4);
        actual = map.get(1, 1).getNeighbours();

        ArrayList<Cell> expected = new ArrayList<>();
        expected.add(map.get(0, 1));
        expected.add(map.get(1, 0));
        expected.add(map.get(2, 1));
        expected.add(map.get(1, 2));

        assertEquals(expected, actual);
    }

    @Test
    public void testGetNeighboursForX0Y3() {
        ArrayList<Cell> actual;
        String mapLine = "STWSWTPPTPTTPWPP";
        Map map = new Map(mapLine, 4, 4);
        actual = map.get(0, 3).getNeighbours();

        ArrayList<Cell> expected = new ArrayList<>();
        expected.add(map.get(0, 2));
        expected.add(map.get(1, 3));

        assertEquals(expected, actual);
    }

    @Test
    public void testGetNeighboursForX3Y2() {
        ArrayList<Cell> actual;
        String mapLine = "STWSWTPPTPTTPWPP";
        Map map = new Map(mapLine, 4, 4);
        actual = map.get(3, 2).getNeighbours();

        ArrayList<Cell> expected = new ArrayList<>();
        expected.add(map.get(2, 2));
        expected.add(map.get(3, 1));
        expected.add(map.get(3, 3));

        assertEquals(expected, actual);
    }
}