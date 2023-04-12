package agh.ics.oop.Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The Grass class represents an object that can move around on a map.
 */
@Getter
@AllArgsConstructor
public class Grass {
    private Vector2d position;

    @Override
    public String toString() {
        return "*";
    }

}
