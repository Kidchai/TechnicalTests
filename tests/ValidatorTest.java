import Exceptions.IllegalArgumentGameException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ValidatorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCheckInputForLength() throws IllegalArgumentGameException {
        thrown.expect(IllegalArgumentGameException.class);
        String mapLine = "STWSWTPPTPTTPWP"; //15 symbols
        Validator.checkInput(mapLine);
    }

    @Test
    public void testCheckInputForOtherSymbols() throws IllegalArgumentGameException {
        thrown.expect(IllegalArgumentGameException.class);
        String mapLine = "STWSKTPPTPTTPWPY";
        Validator.checkInput(mapLine);
    }

    @Test
    public void testCheckInputCorrect() throws IllegalArgumentGameException {
        String mapLine = "STWSWTPPTPTTPWPP";
        Validator.checkInput(mapLine);
    }
}