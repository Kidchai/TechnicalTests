import Exceptions.IllegalArgumentGameException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ConfigurationTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testGetRaceCostsHuman() throws IllegalArgumentGameException {
        Configuration configuration = new Configuration("STWSWTPPTPTTPWPP", "Human");
        HashMap<Character, Integer> expected = new HashMap<>();
        expected.put('S', 5);
        expected.put('W', 2);
        expected.put('T', 3);
        expected.put('P', 1);

        HashMap<Character, Integer> actual = configuration.getRaceCosts();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetRaceCostsSwamper() throws IllegalArgumentGameException {
        Configuration configuration = new Configuration("STWSWTPPTPTTPWPP", "Swamper");
        HashMap<Character, Integer> expected = new HashMap<>();
        expected.put('S', 2);
        expected.put('W', 2);
        expected.put('T', 5);
        expected.put('P', 2);

        HashMap<Character, Integer> actual = configuration.getRaceCosts();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetRaceCostsWoodman() throws IllegalArgumentGameException {
        Configuration configuration = new Configuration("STWSWTPPTPTTPWPP", "Woodman");
        HashMap<Character, Integer> expected = new HashMap<>();
        expected.put('S', 3);
        expected.put('W', 3);
        expected.put('T', 2);
        expected.put('P', 2);

        HashMap<Character, Integer> actual = configuration.getRaceCosts();

        assertEquals(expected, actual);
    }
}