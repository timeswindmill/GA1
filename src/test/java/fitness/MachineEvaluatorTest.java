package fitness;

import creature.CritterHelper;
import creature.MachineCritter;
import gene.MachineDna;
import gene.MachineDnaHelper;
import instruction.OpCodes;
import junit.framework.Assert;
import machine.Machine;
import org.junit.Test;

public class MachineEvaluatorTest {
    @Test
    public void testEvaluateFitness() throws Exception {

        {// Test against Add Test Incorrect
            int[] newCodes = {OpCodes.ADD.ordinal(), 2, 3, 0, OpCodes.HALT.ordinal(), 0, 0, 0};
            MachineDna dna = MachineDnaHelper.INSTANCE.createDnaFromString(newCodes);
            MachineCritter machineCritter = CritterHelper.createNewMachineCritter(dna, 0);
            System.out.println("Fitness start is " + machineCritter.getFitness().getFitness());
            Assert.assertNotNull(machineCritter);

            MachineTest machineTest = new MachineAddTest();
            Machine machine = new Machine();
            MachineEvaluator evaluator = new MachineEvaluator(machine, machineTest);
            Assert.assertNotNull(evaluator);

            evaluator.evaluateFitness(machineCritter);

            double fitness = machineCritter.getFitness().getFitness();
            System.out.println("Fitness is " + fitness);
            Assert.assertEquals(0.0, fitness);
        }

        {// Test against Add Test Correct program
            int[] newCodes = {OpCodes.ADD.ordinal(), 1, 2, 0, OpCodes.MOV.ordinal(), 0, 1, 0, OpCodes.HALT.ordinal(), 1, 2, 0};
            MachineDna dna = MachineDnaHelper.INSTANCE.createDnaFromString(newCodes);
            MachineCritter machineCritter = CritterHelper.createNewMachineCritter(dna, 0);
            Assert.assertNotNull(machineCritter);
            Machine machine = new Machine();
            MachineTest machineTest = new MachineAddTest();
            MachineEvaluator evaluator = new MachineEvaluator(machine, machineTest);
            Assert.assertNotNull(evaluator);

            evaluator.evaluateFitness(machineCritter);

            double fitness = machineCritter.getFitness().getFitness();
            Assert.assertEquals(MachineAddTest.NUM_TESTS, (int) fitness);
        }
        {// Test against Add Test  - Partial Correct program
            int[] newCodes = {OpCodes.LOAD.ordinal(), 0, 3, 0, OpCodes.HALT.ordinal(), 0, 0, 0};
            MachineDna dna = MachineDnaHelper.INSTANCE.createDnaFromString(newCodes);
            MachineCritter machineCritter = CritterHelper.createNewMachineCritter(dna, 0);
            Assert.assertNotNull(machineCritter);
            Machine machine = new Machine();
            MachineTest machineTest = new MachineAddTest();
            MachineEvaluator evaluator = new MachineEvaluator(machine, machineTest);
            Assert.assertNotNull(evaluator);

            evaluator.evaluateFitness(machineCritter);

            double fitness = machineCritter.getFitness().getFitness();
            Assert.assertEquals(1.0, fitness);
        }
        {// Test against Infinite loop program
            int[] newCodes = {OpCodes.ADD.ordinal(), 3, 2, 0, OpCodes.MOV.ordinal(), 0, 1, 0, OpCodes.JMP.ordinal(), 1, 2, 0};
            MachineDna dna = MachineDnaHelper.INSTANCE.createDnaFromString(newCodes);
            MachineCritter machineCritter = CritterHelper.createNewMachineCritter(dna, 0);
            Assert.assertNotNull(machineCritter);
            Machine machine = new Machine();
            MachineTest machineTest = new MachineAddTest();
            MachineEvaluator evaluator = new MachineEvaluator(machine, machineTest);
            Assert.assertNotNull(evaluator);

            evaluator.evaluateFitness(machineCritter);

            double fitness = machineCritter.getFitness().getFitness();
            Assert.assertEquals(-1 * MachineAddTest.NUM_TESTS, (int) fitness);
        }
        {// Test against Another Correct program
            int[] newCodes = {OpCodes.ADD.ordinal(), 1, 2, 0, OpCodes.MOV.ordinal(), 0, 1, 0, OpCodes.JMP.ordinal(), 1, 2, 7};
            MachineDna dna = MachineDnaHelper.INSTANCE.createDnaFromString(newCodes);
            MachineCritter machineCritter = CritterHelper.createNewMachineCritter(dna, 0);
            Assert.assertNotNull(machineCritter);
            Machine machine = new Machine();
            MachineTest machineTest = new MachineAddTest();
            MachineEvaluator evaluator = new MachineEvaluator(machine, machineTest);
            Assert.assertNotNull(evaluator);

            evaluator.evaluateFitness(machineCritter);

            double fitness = machineCritter.getFitness().getFitness();
            Assert.assertEquals(MachineAddTest.NUM_TESTS, (int) fitness);
        }
        {// Test against Another Correct program
            int[] newCodes = {OpCodes.NOOP.ordinal(), 1, 2, 0, OpCodes.ADD.ordinal(), 1, 2, 0, OpCodes.MOV.ordinal(), 0, 1, 0};
            MachineDna dna = MachineDnaHelper.INSTANCE.createDnaFromString(newCodes);
            MachineCritter machineCritter = CritterHelper.createNewMachineCritter(dna, 0);
            Assert.assertNotNull(machineCritter);
            Machine machine = new Machine();
            MachineTest machineTest = new MachineAddTest();
            MachineEvaluator evaluator = new MachineEvaluator(machine, machineTest);
            Assert.assertNotNull(evaluator);

            evaluator.evaluateFitness(machineCritter);

            double fitness = machineCritter.getFitness().getFitness();
            Assert.assertEquals(MachineAddTest.NUM_TESTS, (int) fitness);
        }

    }

    @Test
    public void testJumps() throws Exception {
        {// Test against Correct program with extra jumps
            int[] newCodes = {
                    OpCodes.JMP.ordinal(), 1, 2, 2,
                    OpCodes.NOOP.ordinal(), 1, 2, 0,
                    OpCodes.NOOP.ordinal(), 1, 2, 0,
                    OpCodes.ADD.ordinal(), 1, 2, 0,
                    OpCodes.MOV.ordinal(), 0, 1, 0,
                    OpCodes.JMP.ordinal(), 1, 2, 7,
                    OpCodes.NOOP.ordinal(), 1, 2, 0,
                    OpCodes.NOOP.ordinal(), 1, 2, 0,
            };

            MachineDna dna = MachineDnaHelper.INSTANCE.createDnaFromString(newCodes);
            MachineCritter machineCritter = CritterHelper.createNewMachineCritter(dna, 0);
            Assert.assertNotNull(machineCritter);
            Machine machine = new Machine();
            MachineTest machineTest = new MachineAddTest();
            MachineEvaluator evaluator = new MachineEvaluator(machine, machineTest);
            Assert.assertNotNull(evaluator);

            evaluator.evaluateFitness(machineCritter);

            double fitness = machineCritter.getFitness().getFitness();
            Assert.assertEquals(MachineAddTest.NUM_TESTS, (int) fitness);
        }
    }


    @Test
    public void testExamples() throws Exception {
        //       0	JMZ 	2	2	2
        //       1	INC 	8	4	0
        //       2	NOOP 	0	0	0
        //       3	ADD 	0	2	0
        //       4	DIV 	7	3	0
        //       5	ADD 	0	1	0
        //       6	ADD 	2	9	0
        //       7	NOOP 	0	0	0
        int[] newCodes = {8, 2, 2, 2, 4, 8, 4, 6, 0, 1, 9, 4, 2, 0, 2, 3, 7, 7, 3, 1, 2, 0, 1, 9, 2, 2, 9, 5, 0, 6, 0, 8};
        MachineDna dna = MachineDnaHelper.INSTANCE.createDnaFromString(newCodes);
        MachineCritter machineCritter = CritterHelper.createNewMachineCritter(dna, 0);
        Assert.assertNotNull(machineCritter);
        Machine machine = new Machine();
        MachineTest machineTest = new MachineAddTest();
        MachineEvaluator evaluator = new MachineEvaluator(machine, machineTest);
        Assert.assertNotNull(evaluator);

        evaluator.evaluateFitness(machineCritter);

        double fitness = machineCritter.getFitness().getFitness();
        Assert.assertEquals(MachineAddTest.NUM_TESTS, (int) fitness);


    }


//
//    private Program createProgram(int[] newCodes) {
//        ChunkMachine[] chunks = {createChunk(newCodes)};
//        MachineDna mDna = new MachineDna(chunks);
//        Assert.assertNotNull(mDna);
//
//        Program newProg = mDna.createProgram();
//        return newProg;
//    }

//
//    private ChunkMachine createChunk(int fillValue) {
//        int[] bits = new int[MachineConstants.INSTRUCTION_LENGTH * RunConfig.INSTANCE.getMinInstructions()];
//        Arrays.fill(bits, fillValue);
//        ChunkMachine cm = new ChunkMachine(bits);
//        return cm;
//    }
//
//    private ChunkMachine createChunk(int[] bits) {
//        ChunkMachine cm = new ChunkMachine(bits);
//        return cm;
//    }


}
