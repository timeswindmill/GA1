package world;

import control.RunConfig;
import fitness.FitnessEvaluator;
import fitness.SumEvaluator;

public class SumEvaluatorWorld extends GeneralWorld {


    public SumEvaluatorWorld(Population population, FitnessEvaluator evaluator) {
        super(population, evaluator);
    }

    public static World buildSumEvaluatorWorld() {
        Population worldPopulation = Population.createRandomPopulation(RunConfig.INSTANCE.getStartingSize());
        FitnessEvaluator evaluator = new SumEvaluator();
        SumEvaluatorWorld newWorld = new SumEvaluatorWorld(worldPopulation, evaluator);
        return newWorld;

    }


}
