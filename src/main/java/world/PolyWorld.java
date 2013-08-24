package world;

import control.RunConfig;
import fitness.FitnessEvaluator;
import fitness.SumEvaluator;

public class PolyWorld extends GeneralWorld {

    public PolyWorld(Population population, FitnessEvaluator evaluator) {
        super(population, evaluator);
    }


    public static PolyWorld buildPolyWorld() {
        Population worldPopulation = Population.createRandomPopulation(RunConfig.INSTANCE.getStartingSize());
        FitnessEvaluator evaluator = new SumEvaluator();
        PolyWorld newWorld = new PolyWorld(worldPopulation, evaluator);
        return newWorld;

    }


}
