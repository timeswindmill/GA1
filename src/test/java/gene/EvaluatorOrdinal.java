package gene;

import control.RunConfig;
import creature.SimpleCritter;
import fitness.Fitness;
import fitness.FitnessEvaluator;

public class EvaluatorOrdinal implements FitnessEvaluator<SimpleCritter> {
    @Override
    public void evaluateFitness(SimpleCritter[] critters) {

        for (SimpleCritter critter : critters) {
            evaluateFitness(critter);
        }
    }

    @Override
    public void evaluateFitness(SimpleCritter critter) {
        Fitness newFitness = Fitness.createFitness(critter.getID());
        critter.getFitness().updateFitness(newFitness);
    }

    @Override
    public Fitness getMaxPossibleFitness(Dna simpleDna) {
        return Fitness.createFitness(RunConfig.INSTANCE.getStartingSize());
    }

    @Override
    public Fitness getMinPossibleFitness(Dna simpleDna) {
        return Fitness.createFitness(0.0);
    }
}
