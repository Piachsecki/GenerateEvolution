package agh.ics.oop.Classes;

import agh.ics.oop.EnumClasses.MoveDirection;
import agh.ics.oop.Interfaces.IWorldMap;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animalsOnField =new ArrayList<>();
    protected List<Grass> grassOnField =new ArrayList<>();

    /**

     Determines if an animal can move to the specified position on the map.
     An animal cannot move to a position that is already occupied by another animal.
     @param position The position to check.
     @return True if the position is free, false otherwise.
     */

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Animal animal : animalsOnField) {
            if (animal.isAt(position)){
                return false;
            }
        }
        return true;
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
            animalsOnField.add(animal);
            return true;
        }
        return false;
    }
    /**

     Determines if a specified position on the map is occupied by an animal.
     @param position The position to check.
     @return True if the position is occupied, false otherwise.
     */

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animalsOnField) {
            if (animal.isAt(position)){
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
        for (Animal animal : animalsOnField) {
            if (animal.isAt(position)){
                return animal;
            }
        }
        for (Grass grass : grassOnField) {
            if (this.isOccupied(grass.getPosition())){
                return grass;
            }
        }
        return null;
    }

}
