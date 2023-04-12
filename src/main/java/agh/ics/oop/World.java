package agh.ics.oop;

import agh.ics.oop.Classes.OptionParser;
import agh.ics.oop.Classes.RectangularMap;
import agh.ics.oop.Classes.SimulationEngine;
import agh.ics.oop.Classes.Vector2d;
import agh.ics.oop.EnumClasses.MoveDirection;
import agh.ics.oop.Interfaces.IWorldMap;
import agh.ics.oop.Menu.SettingsMenu;
import agh.ics.oop.Menu.SettingsPanel;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Optional;

public class World {
    public static void main(String[] args) {
        System.out.println("START!");


        MoveDirection[] directions = OptionParser.parse(args);
        IWorldMap map = new RectangularMap(9, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println(engine.getMap().toString());
        engine.run();
        System.out.println(map.toString());

        System.out.println("END!");
//        try {
//            PropertiesLoader properties = PropertiesLoader.loadPropFromFile();
//            Integer[] defaultMapProperties = {
//                    properties.getMapWidth(),
//                    properties.getMapHeight(),
//                    properties.getNumOfSpawnedAnimals(),
//                    properties.getNumOfSpawnedGrass()
//            };
//            SettingsMenu menu = new SettingsMenu();
//            menu.startSimulation(defaultMapProperties);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


    }


}