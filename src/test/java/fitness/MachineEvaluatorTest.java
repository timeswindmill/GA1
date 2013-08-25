package fitness;

import control.RunConfig;
import creature.CritterHelper;
import creature.MachineCritter;
import gene.MachineDna;
import gene.MachineDnaHelper;
import gene.chunk.ChunkMachine;
import instruction.OpCodes;
import instruction.Program;
import junit.framework.Assert;
import machine.MachineConstants;
import org.junit.Test;

import java.util.Arrays;

public class MachineEvaluatorTest {
    @Test
    public void testEvaluateFitness() throws Exception {

        {// Test against Add Test Incorrect
            int[] newCodes = {OpCodes.ADD.ordinal(), 2, 3, 0, OpCodes.HALT.ordinal(), 0, 0, 0};
            MachineDna dna = MachineDnaHelper.INSTANCE.createDnaFromString(newCodes);
            MachineCritter machineCritter = CritterHelper.createNewMachineCritter(dna, 0);
            Assert.assertNotNull(machineCritter);

            MachineTest machineTest = new MachineAddTest();
            MachineEvaluator evaluator = new MachineEvaluator(machineTest);
            Assert.assertNotNull(evaluator);

            evaluator.evaluateFitness(machineCritter);

            double fitness = machineCritter.getFitness().getFitness();
            Assert.assertEquals(0.0, fitness);
        }

        {// Test against Add Test Correct program
            int[] newCodes = {OpCodes.ADD.ordinal(), 1, 2, 0, OpCodes.MOV.ordinal(), 0, 1, 0, OpCodes.HALT.ordinal(), 1, 2, 0};
            MachineDna dna = MachineDnaHelper.INSTANCE.createDnaFromString(newCodes);
            MachineCritter machineCritter = CritterHelper.createNewMachineCritter(dna, 0);
            Assert.assertNotNull(machineCritter);

            MachineTest machineTest = new MachineAddTest();
            MachineEvaluator evaluator = new MachineEvaluator(machineTest);
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

            MachineTest machineTest = new MachineAddTest();
            MachineEvaluator evaluator = new MachineEvaluator(machineTest);
            Assert.assertNotNull(evaluator);

            evaluator.evaluateFitness(machineCritter);

            double fitness = machineCritter.getFitness().getFitness();
            Assert.assertEquals(MachineAddTest.NUM_TESTS, (int) fitness);
        }


    }


    private Program createProgram(int[] newCodes) {
        ChunkMachine[] chunks = {createChunk(newCodes)};
        MachineDna mDna = new MachineDna(chunks);
        Assert.assertNotNull(mDna);

        Program newProg = mDna.createProgram();
        return newProg;
    }


    private ChunkMachine createChunk(int fillValue) {
        int[] bits = new int[MachineConstants.INSTRUCTION_LENGTH * RunConfig.INSTANCE.getMinInstructions()];
        Arrays.fill(bits, fillValue);
        ChunkMachine cm = new ChunkMachine(bits);
        return cm;
    }

    private ChunkMachine createChunk(int[] bits) {
        ChunkMachine cm = new ChunkMachine(bits);
        return cm;
    }


}
