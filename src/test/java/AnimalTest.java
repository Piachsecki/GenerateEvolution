import agh.ics.oop.Classes.Animal;
import agh.ics.oop.Classes.RectangularMap;
import agh.ics.oop.Classes.Vector2d;
import agh.ics.oop.EnumClasses.MapDirection;
import agh.ics.oop.EnumClasses.MoveDirection;
import agh.ics.oop.Interfaces.IWorldMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalTest {
    @Test
    void checkMethods(){
        IWorldMap map = new RectangularMap(10, 2);
        Animal animal = new Animal(map);
        //isAt
        assertTrue(animal.isAt(new Vector2d(2, 2)));

        //move
        animal.move( MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), animal.getPosition());

        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, animal.getMapDirection());

        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH, animal.getMapDirection());

        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2, 2), animal.getPosition());

        //toString
        assertEquals("N", animal.toString());

    }
}
