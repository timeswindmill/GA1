package world;

import control.RunConfig;
import fitness.FitnessEvaluator;
import fitness.MachineAddTest;
import fitness.MachineEvaluator;
import fitness.MachineTest;
import machine.Machine;

public class MachineWorld extends GeneralWorld {

    private static MachineTest currentTest = new MachineAddTest();

    public MachineWorld(Population population, FitnessEvaluator evaluator) {
        super(population, evaluator);
    }


    public static MachineWorld buildMachineWorld() {
        Population worldPopulation = new PopulationMachine();
        worldPopulation.createRandomPopulation(RunConfig.INSTANCE.getStartingSize());
        Machine machine = new Machine();
        FitnessEvaluator evaluator = new MachineEvaluator(machine, currentTest);
        MachineWorld newWorld = new MachineWorld(worldPopulation, evaluator);
        return newWorld;

    }


}
