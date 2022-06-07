import Exceptions.IllegalArgumentGameException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ConfigValidatorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCheckInputForLength() throws IllegalArgumentGameException {
        thrown.expect(IllegalArgumentGameException.class);
        String mapLine = "STWSWTPPTPTTPWP"; //15 symbols
        ConfigValidator.checkMapLine(mapLine);
    }

    @Test
    public void testCheckInputForOtherSymbols() throws IllegalArgumentGameException {
        thrown.expect(IllegalArgumentGameException.class);
        String mapLine = "STWSKTPPTPTTPWPY";
        ConfigValidator.checkMapLine(mapLine);
    }

    @Test
    public void testCheckInputCorrect() throws IllegalArgumentGameException {
        String mapLine = "STWSWTPPTPTTPWPP";
        ConfigValidator.checkMapLine(mapLine);
    }

    @Test
    public void testCheckRaceException() throws IllegalArgumentGameException {
        thrown.expect(IllegalArgumentGameException.class);
        ConfigValidator.checkRace("Humann");
    }
}