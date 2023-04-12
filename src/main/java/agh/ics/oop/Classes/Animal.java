package agh.ics.oop.Classes;

import agh.ics.oop.Interfaces.IWorldMap;
import agh.ics.oop.EnumClasses.MapDirection;
import agh.ics.oop.EnumClasses.MoveDirection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 The Animal class represents an object that can move around on a map.
 It contains information about the map it is on, its position on the map, and the direction it is facing.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Animal {
    private IWorldMap map;
    private Vector2d position;
    private MapDirection mapDirection;

    {
        mapDirection = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }
    /**

     Initializes a new instance of the Animal class with a specified map.
     The animal is placed on the map at position (2, 2) facing north by default.
     @param map The map the animal will be placed on.
     */
    public Animal(IWorldMap map) {
        this.map = map;
    }

    /**

     Initializes a new instance of the Animal class with a specified map and initial position.
     The animal is facing north by default.
     @param map The map the animal will be placed on.
     @param initialPosition The initial position of the animal on the map.
     */
    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.map = map;

    }

    /**

     Returns a string representation of the Animal object.
     @return A string representation of the Animal object.
     */
    @Override
    public String toString() {
        return switch (this.mapDirection) {
            case EAST -> "E";
            case WEST -> "W";
            case NORTH -> "N";
            case SOUTH -> "S";
        };
    }

    /**

     Determines if the animal is at a specified position on the map.
     @param position The position to check.
     @return True if the animal is at the specified position, false otherwise.
     */
    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    /**

     Moves the animal in the specified direction.
     If the direction is forward or backward, the animal will move one square in the direction it is facing.
     If the direction is left or right, the animal will turn in the specified direction.
     @param direction The direction to move or turn the animal.
     */
    public void move(MoveDirection direction) {


        switch (direction) {
            case LEFT -> this.mapDirection = this.mapDirection.previous();
            case RIGHT -> this.mapDirection = this.mapDirection.next();
            case FORWARD -> {
                Vector2d temp = position.add(mapDirection.toUnitVector());
                if (this.map.canMoveTo(temp)) {
                    this.position = temp;

                }
            }
            case BACKWARD -> {
                Vector2d temp = position.subtract(mapDirection.toUnitVector());
                if (this.map.canMoveTo(temp)) {
                    this.position = temp;
                }
            }


        }

    }




}
