package agh.ics.oop.Classes;

import agh.ics.oop.EnumClasses.MoveDirection;
import agh.ics.oop.Interfaces.IPositionChangeObserver;
import agh.ics.oop.Interfaces.IWorldMap;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d,Animal> animalsOnField = new HashMap<>();
    protected Map<Vector2d, Grass> grassOnField = new HashMap<>();

    /**

     Determines if an animal can move to the specified position on the map.
     An animal cannot move to a position that is already occupied by another animal.
     @param position The position to check.
     @return True if the position is free, false otherwise.
     */

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object obj = objectAt(position);
        return !(obj instanceof Animal);

    }
    /**

     Places an animal on the map.
     If the position where the animal is to be placed is free, the animal is added to the map and true is returned.
     Otherwise, the animal is not added and false is returned.
     @param animal The animal to place on the map.
     @return True if the animal was successfully placed, false otherwise.
     */

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            animalsOnField.put(animal.getPosition(), animal);
            return true;
        }
        throw new IllegalArgumentException(animal + " this animal cannot be added on the map");
    }
    /**

     Determines if a specified position on the map is occupied by an animal.
     @param position The position to check.
     @return True if the position is occupied, false otherwise.
     */

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Vector2d animalsPosition : animalsOnField.keySet()) {
            if(animalsPosition.equals(position)){
                return true;
            }
        }
        for (Vector2d grassPosition : grassOnField.keySet()) {
            if(grassPosition.equals(position)){
                return true;
            }
        }
        return false;
    }
    /**

     Returns the object (animal) at the specified position on the map.
     @param position The position to check.
     @return The object (animal) at the position, or null if there is no animal at the position.
     */
    @Override
    public Object objectAt(Vector2d position) {
        for (Vector2d animalsPosition : animalsOnField.keySet()) {
            if(animalsPosition.equals(position)){
                return animalsOnField.get(position);
            }
        }
        for (Vector2d grassPosition : grassOnField.keySet()) {
            if(grassPosition.equals(position)){
                return grassOnField.get(position);
            }
        }
        return null;
    }

    @Override
    public void moveOnMap(Vector2d position) {
    }


    public abstract Vector2d findLowerLeftBound();

    public abstract Vector2d findUpperRightBound();

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        Vector2d lowerLeft = findLowerLeftBound();
        Vector2d upperRight = findUpperRightBound();
        return mapVisualizer.draw(lowerLeft, upperRight);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        animalsOnField.put(newPosition, animalsOnField.get(oldPosition) );
        animalsOnField.remove(oldPosition);
    }
}
