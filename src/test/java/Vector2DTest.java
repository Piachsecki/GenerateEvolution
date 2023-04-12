import agh.ics.oop.Classes.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2DTest {
    @Test
    void vectorTest(){
        Vector2d v1 = new Vector2d(1, 1);
        Vector2d v2 = new Vector2d(0, -2);
        assertEquals(new Vector2d(1, 3), v1.subtract(v2));
        assertEquals(new Vector2d(1, -1), v1.add(v2));
        assertEquals(new Vector2d(0, -2), v1.lowerLeft(v2));
        assertEquals(new Vector2d(1, 1), v1.upperRight(v2));
        assertFalse(v1.precedes(v2));
        assertTrue(v1.follows(v2));
        assertEquals("(1,1)", v1.toString());
        assertEquals(new Vector2d(-1, -1) ,v1.opposite());

    }
}
