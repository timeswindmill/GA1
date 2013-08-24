package gene;

import creature.Critter;

public interface FitnessEvaluator {


    public void evaluateFitness(Critter[] critters);

    public void evaluateFitness(Critter critter);


}
