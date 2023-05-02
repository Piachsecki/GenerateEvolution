import agh.ics.oop.Classes.Animal;
import agh.ics.oop.Classes.RectangularMap;
import agh.ics.oop.Classes.SimulationEngine;
import agh.ics.oop.Classes.Vector2d;
import agh.ics.oop.EnumClasses.MoveDirection;
import agh.ics.oop.Interfaces.IWorldMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SimulationEngineTest {

    private IWorldMap map;
    private MoveDirection[] directions;
    private Vector2d[] positions;

    @BeforeEach
    public void setup() {
        this.map = new RectangularMap(5, 5);
        this.directions = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT};
        this.positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(4, 4)};
    }

    @Test
    public void testRun() {
        SimulationEngine engine = new SimulationEngine(this.directions, this.map, this.positions);
        engine.run();
//        List<Animal> animals = engine.getAnimals();
//        Assertions.assertEquals(2, animals.size());

//        Animal animal1 = animals.get(0);
//        Animal animal2 = animals.get(1);

//        // Check that animals are in the expected final positions
//        Assertions.assertEquals(new Vector2d(1, 3), animal1.getPosition());
//        Assertions.assertEquals(new Vector2d(3, 5), animal2.getPosition());
    }

    @Test
    public void testConstructor() {
        SimulationEngine engine = new SimulationEngine(this.directions, this.map, this.positions);

        // Check that engine was constructed with the expected parameters
        Assertions.assertEquals(this.map, engine.getMap());
        Assertions.assertArrayEquals(this.directions, engine.getDirections());
        Assertions.assertArrayEquals(this.positions, engine.getPositions());
    }

}