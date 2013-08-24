package fitness;

import creature.Critter;
import gene.Dna;


public interface FitnessEvaluator<T extends Critter> {

    public void evaluateFitness(T[] critters);

    public void evaluateFitness(T critter);

    //
    //   public Fitness evaluateResults(SimpleDna simpleDna);
    public Fitness getMaxPossibleFitness(Dna simpleDna);

    public Fitness getMinPossibleFitness(Dna simpleDna);
//    public Fitness getAcceptableFitness(Dna simpleDna);
}
