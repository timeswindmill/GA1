package gene.chunk;

import control.RunConfig;
import junit.framework.Assert;
import machine.MachineConstants;
import org.junit.Test;

import java.util.Arrays;

public class ChunkMachineTest {

    private int bitLength = MachineConstants.INSTRUCTION_LENGTH * RunConfig.INSTANCE.getMinInstructions();

    @Test
    public void testGetHash() throws Exception {
        long[] newBits = new long[bitLength];
        Arrays.fill(newBits, new Long(1));
        Chunk chunk = new ChunkMachine(newBits);
        Assert.assertNotNull(chunk);
        Assert.assertEquals(new Double(bitLength).doubleValue(), chunk.getHash());

    }

    @Test
    public void testGetBits() throws Exception {
        long[] newBits = new long[4];
        Arrays.fill(newBits, new Long(1));
        Chunk chunk = new ChunkMachine(newBits);
        Assert.assertNotNull(chunk);
        Assert.assertEquals(newBits, chunk.getBits());

    }

    @Test
    public void testGetChunkSum() throws Exception {
        long[] newBits = new long[bitLength];
        Arrays.fill(newBits, new Long(1));
        Chunk chunk = new ChunkMachine(newBits);
        Assert.assertNotNull(chunk);
        Assert.assertEquals(new Double(bitLength).doubleValue(), chunk.getChunkSum());
    }


}
