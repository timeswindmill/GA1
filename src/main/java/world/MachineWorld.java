package world;

import control.RunConfig;
import fitness.FitnessEvaluator;
import fitness.MachineEvaluator;

public class MachineWorld extends GeneralWorld {

    public MachineWorld(Population population, FitnessEvaluator evaluator) {
        super(population, evaluator);
    }


    public static MachineWorld buildMachineWorld() {
        Population worldPopulation = Population.createRandomPopulation(RunConfig.INSTANCE.getStartingSize());
        FitnessEvaluator evaluator = new MachineEvaluator();
        MachineWorld newWorld = new MachineWorld(worldPopulation, evaluator);
        return newWorld;

    }


}
