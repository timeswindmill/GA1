package fitness;

import creature.MachineCritter;
import gene.Dna;
import instruction.Program;
import machine.Machine;

public class MachineEvaluator implements FitnessEvaluator<MachineCritter> {

    //TODO set up default prog
    private static Machine machine = new Machine(null, new long[1]);

    private MachineTest machineTest;


    public MachineEvaluator(MachineTest test) {
        machineTest = test;
    }

    @Override
    public void evaluateFitness(MachineCritter[] critters) {

        for (MachineCritter critter : critters) {
            evaluateFitness(critter);
        }

    }

    @Override
    public void evaluateFitness(MachineCritter critter) {
        Program thisProgram = critter.getDna().createProgram();
        double totalFitness = 0;
        machine.setProgram(thisProgram);
        // initialise registers
        for (int ii = 0; ii < MachineAddTest.NUM_TESTS; ii++) {
            long[] registers = machineTest.getRegisters(ii);
            machine.loadRegisters(registers);
            machine.runProgram();

            if (machine.isLoopDetected()) {
                totalFitness--;
            } else {
                double thisFitness = machineTest.calculateFitness(machine, ii);
                totalFitness += thisFitness;
            }

        }
        critter.getFitness().updateFitness(Fitness.createFitness(totalFitness));

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

//     private Machine setUpMachine(Program program, long [] registers){
//        Machine machine = new Machine(program, registers);
//        return machine;
//
//    }

}
