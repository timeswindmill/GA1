package world;

import creature.SimpleCritter;
import fitness.FitnessEvaluator;

import java.util.List;

public class GeneralWorld implements World {

    private Population worldPopulation;
    private FitnessEvaluator evaluator;


    public GeneralWorld(Population population, FitnessEvaluator evaluator) {
        worldPopulation = population;
        this.evaluator = evaluator;
    }


    public void runWorld(int generations) {
        for (int ii = 0; ii < generations; ii++) {
            WorldRunner.runOneGeneration(worldPopulation, evaluator, ii);
        }
    }


    public List<SimpleCritter> getSortedCritters() {
        return worldPopulation.getSortedCritters();
    }


    public void saveBestDna() {


    }

}
