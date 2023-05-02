package agh.ics.oop.gui;

import agh.ics.oop.Classes.*;
import agh.ics.oop.EnumClasses.MoveDirection;
import agh.ics.oop.Interfaces.IEngine;
import agh.ics.oop.Interfaces.IWorldMap;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Set;

public class App extends Application {
    private AbstractWorldMap map;
    private GridPane grid;
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    private static int height = 50;
    private static int width = 50;
    private SimulationEngine engine;

    @Override
    public void init() throws Exception {
        try {
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = new OptionParser().parse(args);
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        minX = map.findLowerLeftBound().getX();
        minY = map.findLowerLeftBound().getY();
        maxX = map.findUpperRightBound().getX();
        maxY = map.findUpperRightBound().getY();
        System.out.println(map);

        grid = new GridPane();

        Label labelxy = new Label("X/Y");
        grid.add(labelxy, 0, 0);
        GridPane.setHalignment(labelxy, HPos.CENTER);

        grid.getColumnConstraints().add(new ColumnConstraints(width));
        grid.getRowConstraints().add(new RowConstraints(height));

        createColumns();

        createRows();

        addObjectsOnTheMap();


            Scene scene = new Scene(grid, (maxX - minX + 2) * width, (maxY - minY + 2) * height);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

    private void addObjectsOnTheMap() {
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                Vector2d position = new Vector2d(x, y);
                Object object = map.objectAt(position);
                if (object != null) {
                    Label label = new Label(object.toString());
                    grid.add(label, position.getX() - minX + 1, maxY - position.getY() + 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }
    }

    private void createRows() {
        for (int i = 1; i <= maxY - minY + 1; i++) {
            Label label = new Label(Integer.toString(maxY - i + 1));
            grid.getRowConstraints().add(new RowConstraints(height));
            GridPane.setHalignment(label, HPos.CENTER);
            grid.add(label, 0, i);
            grid.setGridLinesVisible(true);
        }
    }

    private void createColumns() {
        for (int i = 1; i <= maxX - minX + 1; i++) {
            Label label = new Label(Integer.toString(minX + i - 1));
            grid.getColumnConstraints().add(new ColumnConstraints(width));
            GridPane.setHalignment(label, HPos.CENTER);
            grid.add(label, i, 0);
            grid.setGridLinesVisible(true);
        }
    }

}



