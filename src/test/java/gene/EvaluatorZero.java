package gene;

import creature.SimpleCritter;
import fitness.Fitness;
import fitness.FitnessEvaluator;

public class EvaluatorZero implements FitnessEvaluator<SimpleCritter> {
    @Override
    public void evaluateFitness(SimpleCritter[] critters) {
        for (SimpleCritter critter : critters) {
            evaluateFitness(critter);
        }

    }

    @Override
    public void evaluateFitness(SimpleCritter critter) {
        critter.getFitness().updateFitness(Fitness.createFitness(0));
    }

//    @Override
//    public Fitness evaluateResults(SimpleDna simpleDna) {
//        return null;
//    }

    @Override
    public Fitness getMaxPossibleFitness(Dna simpleDna) {
        return Fitness.createFitness(0.0);
    }

    @Override
    public Fitness getMinPossibleFitness(Dna simpleDna) {
        return Fitness.createFitness(0.0);
    }

//    @Override
//    public Fitness getAcceptableFitness(Dna simpleDna) {
//        return null;
//    }
}
