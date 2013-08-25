package gene;

import control.RunConfig;
import gene.chunk.ChunkMachine;
import instruction.Instruction;
import instruction.OpCodes;
import instruction.Program;
import junit.framework.Assert;
import machine.MachineConstants;
import org.junit.Test;

import java.util.Arrays;

public class MachineDnaTest {

    @Test
    public void testCreateChunks() throws Exception {
        int fillValue = 17;
        ChunkMachine cm = createChunk(fillValue);
        Assert.assertNotNull(cm);
        int[] bits = cm.getBits();
        Assert.assertEquals(MachineConstants.INSTRUCTION_LENGTH * RunConfig.INSTANCE.getMinInstructions(), bits.length);
        for (long thisLong : bits) {
            Assert.assertEquals(fillValue, thisLong);
        }
    }

    @Test
    public void testGetChunks() throws Exception {
        ChunkMachine[] cm = {createChunk(1), createChunk(2)};
        MachineDna mDna = new MachineDna(cm);
        Assert.assertNotNull(mDna);
        ChunkMachine[] chunks = mDna.getChunks();
        Assert.assertEquals(2, chunks.length);
    }
    //TODO write these tests

    @Test
    public void testGetHash() throws Exception {

    }

    @Test
    public void testCombineChunks() throws Exception {

    }

    @Test
    public void testCompareTo() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {

    }

    @Test
    public void testCreateProgram() {
        {
            ChunkMachine[] cm = {createChunk(1), createChunk(2)};
            MachineDna mDna = new MachineDna(cm);
            Assert.assertNotNull(mDna);

            Program newProg = mDna.createProgram();
            Assert.assertNotNull(newProg);
            // check that min instruction length has been observed
            Assert.assertEquals(RunConfig.INSTANCE.getMinInstructions() * 2, newProg.getProgramLength());


        }
        {
            int[] newCodes = {OpCodes.ADD.ordinal(), 2, 3, 0, OpCodes.NOOP.ordinal(), 0, 0, 0};

            ChunkMachine[] chunks = {createChunk(newCodes)};
            MachineDna mDna = new MachineDna(chunks);
            Assert.assertNotNull(mDna);

            Program newProg = mDna.createProgram();
            Assert.assertNotNull(newProg);
            Assert.assertTrue(newProg.getProgramLength() >= 2);

            Instruction[] instructions = newProg.getInstructions();

            Assert.assertTrue(instructions[0].getOpCode() == OpCodes.ADD);
            Assert.assertTrue(instructions[1].getOpCode() == OpCodes.NOOP);


        }


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


    //TODO test for dna helper

}
