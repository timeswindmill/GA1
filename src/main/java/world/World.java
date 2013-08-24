package world;

import creature.SimpleCritter;

import java.util.List;

public interface World {

    public void runWorld(int generations);

    public List<SimpleCritter> getSortedCritters();


}
