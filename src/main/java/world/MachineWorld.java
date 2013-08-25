package world;

import control.RunConfig;
import fitness.FitnessEvaluator;
import fitness.MachineAddTest;
import fitness.MachineEvaluator;
import fitness.MachineTest;

public class MachineWorld extends GeneralWorld {

    private static MachineTest currentTest = new MachineAddTest();

    public MachineWorld(Population population, FitnessEvaluator evaluator) {
        super(population, evaluator);
    }


    public static MachineWorld buildMachineWorld() {
        Population worldPopulation = new PopulationMachine();
        worldPopulation.createRandomPopulation(RunConfig.INSTANCE.getStartingSize());
        FitnessEvaluator evaluator = new MachineEvaluator(currentTest);
        MachineWorld newWorld = new MachineWorld(worldPopulation, evaluator);
        return newWorld;

    }


}
