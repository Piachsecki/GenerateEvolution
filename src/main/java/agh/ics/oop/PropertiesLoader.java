package agh.ics.oop;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Getter
@Setter

public class PropertiesLoader {
    private int mapWidth;
    private int mapHeight;
    private int numOfSpawnedAnimals;
    private int numOfSpawnedGrass;

    static public PropertiesLoader loadPropFromFile() throws FileNotFoundException,IllegalArgumentException {
        Gson gson = new Gson();
        Path path = Paths.get("src/main/java/agh/ics/oop/config.json");
        PropertiesLoader properties =  (PropertiesLoader)gson.fromJson(new FileReader("src/main/java/agh/ics/oop/config.json"), PropertiesLoader.class);
        properties.validate();
        return properties;
    }

    private void validate() {
        if(this.mapWidth <= 0){ throw new IllegalArgumentException("Invalid map width");}
        if(this.mapHeight <= 0){ throw new IllegalArgumentException("Invalid map height");}
        if(this.numOfSpawnedAnimals < 0){ throw new IllegalArgumentException("Invalid numOfSpawnedAnimals");}
        if(this.numOfSpawnedGrass < 0){ throw new IllegalArgumentException("Invalid numOfSpawnedGrassFields");}
    }
}
