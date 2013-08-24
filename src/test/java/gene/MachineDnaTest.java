package gene;

import control.RunConfig;
import gene.chunk.ChunkMachine;
import junit.framework.Assert;
import machine.MachineConstants;
import org.junit.Test;

import java.util.Arrays;

public class MachineDnaTest {

    @Test
    public void testCreateChunks() throws Exception {
        long fillValue = 17;
        ChunkMachine cm = createChunk(fillValue);
        Assert.assertNotNull(cm);
        long[] bits = cm.getBits();
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

    private ChunkMachine createChunk(long fillValue) {
        long[] bits = new long[MachineConstants.INSTRUCTION_LENGTH * RunConfig.INSTANCE.getMinInstructions()];
        Arrays.fill(bits, fillValue);
        ChunkMachine cm = new ChunkMachine(bits);
        return cm;
    }

    private ChunkMachine createRandomChunk() {
        ChunkMachine cm = ChunkMachine.createRandom();
        return cm;
    }

    //TODO test for dna helper

}
