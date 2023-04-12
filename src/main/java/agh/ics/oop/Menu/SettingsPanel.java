package agh.ics.oop.Menu;

import agh.ics.oop.Classes.GrassField;
import agh.ics.oop.Classes.RectangularMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class SettingsPanel extends JPanel implements ActionListener {
    public static final int HEIGHT = 600;
    public static final int WIDTH = 600;
    private JTextField numOfSpawnedAnimals;
    private JTextField numOfSpawnedGrass;
    private JTextField mapWidth;
    private JTextField mapHeight;
    private JLabel numOfSpawnedAnimalsLabel;
    private JLabel numOfSpawnedGrassLabel;
    private JLabel mapWidthLabel;
    private JLabel mapHeightLabel;
    private JButton startButton;

    public SettingsPanel(Integer[] defaultMapProperties) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        startButton = new JButton("Start Simulation");
        startButton.addActionListener(this);


        //LABELS
        mapHeightLabel = new JLabel("Map height:                       ");
        mapWidthLabel = new JLabel("Map width:                        ");
        numOfSpawnedAnimalsLabel = new JLabel("Animals spawning at the start:    ");
        numOfSpawnedGrassLabel= new JLabel("Grass spawning at the start:    ");

        //TEXT FIELDS
        int numberOfColumns = 3;

        mapWidth = new JTextField();
        mapWidth.setColumns(numberOfColumns);
        mapWidth.setText(defaultMapProperties[0].toString());

        mapHeight = new JTextField();
        mapHeight.setColumns(numberOfColumns);
        mapHeight.setText(defaultMapProperties[1].toString());

        numOfSpawnedAnimals = new JTextField();
        numOfSpawnedAnimals.setColumns(numberOfColumns);
        numOfSpawnedAnimals.setText(defaultMapProperties[2].toString());

        numOfSpawnedGrass = new JTextField();
        numOfSpawnedGrass.setColumns(numberOfColumns);
        numOfSpawnedGrass.setText(defaultMapProperties[3].toString());


        //Labels to text fields
        mapHeightLabel.setLabelFor(mapHeight);
        mapWidthLabel.setLabelFor(mapWidthLabel);
        numOfSpawnedAnimalsLabel.setLabelFor(numOfSpawnedAnimals);
        numOfSpawnedGrassLabel.setLabelFor(numOfSpawnedGrass);

        JPanel l1 = new JPanel();
        JPanel l2 = new JPanel();
        JPanel l3 = new JPanel();
        JPanel l4 = new JPanel();

        l1.add(mapHeightLabel);
        l2.add(mapWidthLabel);
        l3.add(numOfSpawnedAnimalsLabel);
        l4.add(numOfSpawnedGrassLabel);

        l1.add(mapHeight);
        l2.add(mapWidth);
        l3.add(numOfSpawnedAnimals);
        l4.add(numOfSpawnedGrass);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);


        add(new JLabel("Map properties"));
        add(l1);
        add(l2);


        add(buttonPanel);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
