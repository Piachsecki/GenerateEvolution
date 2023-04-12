package agh.ics.oop.EnumClasses;

import agh.ics.oop.Classes.Vector2d;

/**

 An enum representing the four cardinal directions on a map: NORTH, SOUTH, EAST, and WEST.
 */
public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    /**

     Returns a string representation of this map direction.
     @return a string representation of this map direction.
     */

    @Override
    public String toString() {
        return switch (this) {
            case NORTH -> "NORTH";
            case SOUTH -> "SOUTH";
            case EAST -> "EAST";
            case WEST -> "WEST";
        };
    }

    /**

     Returns the next map direction after this one in a clockwise direction.
     @return the next map direction after this one in a clockwise direction.
     */
    public MapDirection next(){
        if(this.equals(MapDirection.EAST)){
            return MapDirection.SOUTH;
        }
        else if(this.equals(MapDirection.SOUTH)){
            return MapDirection.WEST;
        }
        else if(this.equals(MapDirection.WEST)){
            return MapDirection.NORTH;
        }
        return MapDirection.EAST;

    }
    /**

     Returns the previous map direction before this one in a clockwise direction.
     @return the previous map direction before this one in a clockwise direction.
     */

    public MapDirection previous(){
        if(this.equals(MapDirection.EAST)){
            return MapDirection.NORTH;
        }
        else if(this.equals(MapDirection.SOUTH)){
            return MapDirection.EAST;
        }
        else if(this.equals(MapDirection.NORTH)){
            return MapDirection.WEST;
        }
        return MapDirection.SOUTH;

    }

    /**

     Returns the unit vector corresponding to this map direction.
     @return the unit vector corresponding to this map direction.
     */
    public Vector2d toUnitVector(){
        if(this.equals(MapDirection.EAST)){
            return new Vector2d(1, 0);
        }
        else if(this.equals(MapDirection.WEST)){
            return new Vector2d(-1, 0);
        }
        else if(this.equals(MapDirection.NORTH)){
            return new Vector2d(0, 1);
        }
        return new Vector2d(0, -1);
    }
}
