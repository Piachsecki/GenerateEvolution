package agh.ics.oop;

import agh.ics.oop.Classes.*;
import agh.ics.oop.EnumClasses.MoveDirection;
import agh.ics.oop.Interfaces.IWorldMap;
import agh.ics.oop.gui.App;
import javafx.application.Application;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Optional;

public class World {
    public static void main(String[] args) {
//        System.out.println("START!");
//
//        String[] arr = {"f", "f", "f", "r", "r", "f", "f",  "f", "f"};
//        MoveDirection[] directions = OptionParser.parse(arr);
//        IWorldMap map = new GrassField(10);
//
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
//        SimulationEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        System.out.println(map);
//        System.out.println("END!");

        Application.launch(App.class, args);



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