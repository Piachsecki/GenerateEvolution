package agh.ics.oop.Classes;

import java.util.ArrayList;
import java.util.List;
/**

 The RectangularMap class implements the IWorldMap interface and represents a rectangular map on which animals can move.
 It contains information about the size of the map and the animals currently on the map.
 */

public class RectangularMap extends AbstractWorldMap {
    List<Animal> animals = new ArrayList<>();
    private final int width;
    private final int height;
    /**

     Initializes a new instance of the RectangularMap class with the specified width and height.
     @param width The width of the map.
     @param height The height of the map.
     */
    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0,0), new Vector2d(width, height));

    }

}
