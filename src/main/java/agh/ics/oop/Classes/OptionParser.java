package agh.ics.oop.Classes;


import agh.ics.oop.EnumClasses.MoveDirection;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
/**

 The OptionParser class provides a static method for parsing command-line arguments

 into an array of MoveDirection objects.
 */
public class OptionParser {
    /**

     Parses an array of strings into an array of MoveDirection objects.

     @param args An array of strings containing the command-line arguments.

     @return An array of MoveDirection objects parsed from the input arguments.
     */
    public static MoveDirection[] parse(String[] args) {
        int sizeOfOriginalArray = 0;
        int i = 0;
        for (String value : args) {
            if ("f".equals(value) ||
                    "b".equals(value) ||
                    "r".equals(value) ||
                    "l".equals(value) ||
                    "forward".equals(value) ||
                    "backward".equals(value) ||
                    "left".equals(value) ||
                    "right".equals(value)
            ) {
                sizeOfOriginalArray++;
            }
        }
        String[] temp = new String[sizeOfOriginalArray];

        for (String arg : args) {
            if ("f".equals(arg) ||
                    "b".equals(arg) ||
                    "r".equals(arg) ||
                    "l".equals(arg) ||
                    "forward".equals(arg) ||
                    "backward".equals(arg) ||
                    "left".equals(arg) ||
                    "right".equals(arg)
            ) {
                temp[i] = arg;
                i++;
            }
        }

        MoveDirection[] directions = new MoveDirection[temp.length];
        int k = 0;
        for (String s : temp) {
            switch (s){
                case "f", "forward" -> directions[k] = MoveDirection.FORWARD;
                case "b", "backward"-> directions[k] = MoveDirection.BACKWARD;
                case "l", "left"    -> directions[k] = MoveDirection.LEFT;
                case "r", "right"   -> directions[k] = MoveDirection.RIGHT;
            }
            k++;
        }

        return directions;

    }
}
