package world;

import java.util.List;

public interface World<T> {

    public void runWorld(int generations);

    public List<T> getSortedCritters();


}
