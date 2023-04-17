package agh.ics.oop.Classes;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter
@Setter
public class GrassField extends AbstractWorldMap {
    private int numberOfGrassFields;

    public GrassField(int numberOfGrassFields) {
        this.numberOfGrassFields = numberOfGrassFields;
        for (int i = 0; i < numberOfGrassFields; i++) {
            createGrass();
        }
        System.out.println(grassOnField.size());
    }



    private void createGrass() {
        Random random = new Random();
        int x = random.nextInt((int) Math.sqrt(numberOfGrassFields * 10) + 2);
        int y = random.nextInt((int) Math.sqrt(numberOfGrassFields * 10) + 2);
        Vector2d grassPosition = new Vector2d(x, y);
        if (!isOccupied(grassPosition)) {
            Grass grass = new Grass(grassPosition);
            grassOnField.put(grassPosition, grass);
        }


    }




    @Override
    public Vector2d findUpperRightBound() {
        Animal firstKey = (Animal) animalsOnField.values().toArray()[0];
        Vector2d upperRight = firstKey.getPosition();

        for (Vector2d animalsPosition : animalsOnField.keySet()) {
            upperRight = animalsPosition.upperRight(upperRight);
        }

        for (Vector2d grassPosition : grassOnField.keySet()) {
            upperRight = grassPosition.upperRight(upperRight);
        }
        return upperRight;
    }

    @Override
    public Vector2d findLowerLeftBound() {
        Animal firstKey = (Animal) animalsOnField.values().toArray()[0];
        Vector2d lowerLeft = firstKey.getPosition();

        for (Vector2d animalsPosition : animalsOnField.keySet()) {
            lowerLeft = animalsPosition.lowerLeft(lowerLeft);
        }

        for (Vector2d grassPosition : grassOnField.keySet()) {
            lowerLeft = grassPosition.lowerLeft(lowerLeft);
        }
        return lowerLeft;
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animalsOnField.put(animal.getPosition(), animal);
            return true;
        }
        throw new IllegalArgumentException("cannot add an animal on this map- positions are already taken");
    }


    @Override
    public void moveOnMap(Vector2d position) {
        for (Vector2d grassPosition : grassOnField.keySet()) {
            if(grassPosition.equals(position)){
                grassOnField.remove(position);
                createGrass();
            }
        }

    }


}
