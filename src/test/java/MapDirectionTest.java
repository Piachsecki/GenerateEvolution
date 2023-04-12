import agh.ics.oop.EnumClasses.MapDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

@Test
     void mapDirectionTest(){
    MapDirection south = MapDirection.SOUTH;
    MapDirection north = MapDirection.NORTH;
    MapDirection east = MapDirection.EAST;
    MapDirection west = MapDirection.WEST;


    assertEquals(MapDirection.WEST, south.next());
    assertEquals(MapDirection.SOUTH, east.next());
    assertEquals(MapDirection.EAST, north.next());
    assertEquals(MapDirection.NORTH, west.next());



    assertEquals(MapDirection.EAST, south.previous());
    assertEquals(MapDirection.NORTH, east.previous());
    assertEquals(MapDirection.WEST, north.previous());
    assertEquals(MapDirection.SOUTH, west.previous());


    assertEquals("SOUTH", south.toString());
    assertEquals("EAST", east.toString());
    assertEquals("NORTH", north.toString());
    assertEquals("WEST", west.toString());
}
}
