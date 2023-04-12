package agh.ics.oop.Classes;

import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private final int numberOfGrassFields;

    public GrassField(int numberOfGrassFields) {
        this.numberOfGrassFields = numberOfGrassFields;
        for (int i = 0; i < numberOfGrassFields - 1; i++) {
            createGrass();
        }
    }

    private void createGrass() {
        Random random = new Random();
        int x = random.nextInt(0, (int) Math.sqrt(numberOfGrassFields*10));
        int y = random.nextInt(0, (int) Math.sqrt(numberOfGrassFields*10));
        Vector2d grassPosition = new Vector2d(x, y);
        Grass grass = new Grass(grassPosition);
        if(!isOccupied(grassPosition)){
            grassOnField.add(grass);
        }


    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object object = objectAt(position);
        return !(object instanceof Animal);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return super.objectAt(position);
    }
}
