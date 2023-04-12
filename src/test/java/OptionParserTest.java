import agh.ics.oop.Classes.OptionParser;
import agh.ics.oop.EnumClasses.MoveDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OptionParserTest {

    @Test
    void parse_shouldReturnEmptyArray_whenGivenEmptyArray() {
        String[] args = new String[0];
        MoveDirection[] result = OptionParser.parse(args);
        Assertions.assertArrayEquals(new MoveDirection[0], result);
    }

    @Test
    void parse_shouldParseValidArguments() {
        String[] args = {"f", "b", "left", "right", "forward", "backward", "invalid"};
        MoveDirection[] result = OptionParser.parse(args);
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.LEFT, MoveDirection.RIGHT,
                MoveDirection.FORWARD, MoveDirection.BACKWARD};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void parse_shouldReturnOnlyValidArguments() {
        String[] args = {"f", "invalid", "left", "right", "backward", "invalid"};
        MoveDirection[] result = OptionParser.parse(args);
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.LEFT,
                MoveDirection.RIGHT, MoveDirection.BACKWARD};
        Assertions.assertArrayEquals(expected, result);
    }
}