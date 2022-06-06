import Exceptions.FileNotFoundGameException;
import Exceptions.IllegalArgumentGameException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void testGetResult() throws IllegalArgumentGameException, FileNotFoundGameException, IOException {
        int expected = 10;
        int actual = Solution.getResult("tests/TestFile");
        assertEquals(expected, actual);
    }
}