package fitness;

import creature.MachineCritter;
import gene.Dna;

public class DataSetEvaluator implements FitnessEvaluator<MachineCritter> {


    private final static int[] DATA_SET_1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final static int[] DATA_SET_2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final static int[] DATA_SET_3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final static int[] DATA_SET_4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


    @Override
    public void evaluateFitness(MachineCritter[] critters) {

    }

    @Override
    public void evaluateFitness(MachineCritter critter) {

    }

    @Override
    public Fitness getMaxPossibleFitness(Dna simpleDna) {
        return null;
    }

    @Override
    public Fitness getMinPossibleFitness(Dna simpleDna) {
        return null;
    }
}
