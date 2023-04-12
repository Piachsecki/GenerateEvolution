package agh.ics.oop.Classes;

import lombok.*;
/**
 A class representing a two-dimensional integer vector.
 */
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode


public class Vector2d {
    private final int x;
    private final int y;

    /**

     Returns a string representation of this vector in the format "(x,y)".
     @return a string representation of this vector.
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /**

     Checks if this vector precedes the other vector in each dimension.
     @param other the other vector to compare to.
     @return true if this vector precedes the other vector, false otherwise.
     */
    public boolean precedes(Vector2d other) {
        return x <= other.x && y <= other.y;
    }

    /**

     Checks if this vector follows the other vector in each dimension.
     @param other the other vector to compare to.
     @return true if this vector follows the other vector, false otherwise.
     */
    public boolean follows(Vector2d other) {
        return x >= other.x && y >= other.y;
    }

    /**

     Adds the given vector to this vector and returns the result as a new vector.
     @param other the vector to add to this vector.
     @return the result of adding the two vectors together.
     */
    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }
    /**

     Subtracts the given vector from this vector and returns the result as a new vector.
     @param other the vector to subtract from this vector.
     @return the result of subtracting the two vectors.
     */

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);

    }

    /**

     Returns the vector that represents the upper-right corner of the rectangle formed by this vector and the other vector.
     @param other the other vector to form the rectangle with.
     @return the vector representing the upper-right corner of the rectangle.
     */

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(x, other.x), Math.max(y, other.y));

    }
    /**

     Returns the vector that represents the lower-left corner of the rectangle formed by this vector and the other vector.
     @param other the other vector to form the rectangle with.
     @return the vector representing the lower-left corner of the rectangle.
     */
    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(x, other.x), Math.min(y, other.y));

    }

    /**
     Returns the opposite of this vector, i.e., a vector with the same magnitude but opposite direction.
     @return the opposite vector of this vector.
     */
    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

}
