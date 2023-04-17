package agh.ics.oop.Classes;

import agh.ics.oop.EnumClasses.MoveDirection;
import agh.ics.oop.Interfaces.IEngine;
import agh.ics.oop.Interfaces.IWorldMap;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**

 The SimulationEngine class represents an engine for running a simulation on an IWorldMap object

 using a given set of directions and starting positions for Animal objects.
 */
@Getter
@Setter


public class SimulationEngine implements IEngine {
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final Vector2d[] positions;
    private Map<Vector2d, Animal> animals;
    /**

     Constructs a new SimulationEngine object with the specified parameters.
     @param directions an array of MoveDirection objects representing the directions in which the animals will move
     @param map an IWorldMap object representing the map on which the simulation will be run
     @param positions an array of Vector2d objects representing the starting positions of the animals
     */
    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;
        this.positions = positions;
        this.animals =new HashMap<>();

        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)){
                this.animals.put(position, animal);
            }
        }


    }

    /**

     Runs the simulation on the map with the specified directions and starting positions for the animals.
     */
    @Override
    public void run() {

        int tabLength=animals.size();
        Animal[] tabAnimals= new Animal[tabLength];

        animals.values().toArray(tabAnimals);
        int i=0;
        if(tabLength!=0){
            for (MoveDirection x : directions ) {
                tabAnimals[i%tabLength].move(x);
                i++;
            }
        }
    }
}
