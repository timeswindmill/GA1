package fitness;

import creature.MachineCritter;
import gene.Dna;
import machine.Machine;

public class MachineEvaluator implements FitnessEvaluator<MachineCritter> {
    private Machine machine;


    //TODO
    @Override
    public void evaluateFitness(MachineCritter[] critters) {

        for (MachineCritter critter : critters) {
            evaluateFitness(critter);
        }

    }

    @Override
    public void evaluateFitness(MachineCritter critter) {


    }

    @Override
    public Fitness getMaxPossibleFitness(Dna simpleDna) {
        // this is impossible to judge
        return Fitness.createFitness(999999999999999999999.0);
    }

    @Override
    public Fitness getMinPossibleFitness(Dna simpleDna) {
        return Fitness.createFitness(0);
    }


//    private Program createProgramFromDna(){
//
//    }


}
