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
        Arrays.fill(newBits, 1);
        Chunk chunk = new ChunkMachine(newBits);
        Assert.assertNotNull(chunk);
        Assert.assertEquals(bitLength, (int) chunk.getHash());

    }

    @Test
    public void testGetBits() throws Exception {
        long[] newBits = new long[4];
        Arrays.fill(newBits, 1);
        Chunk chunk = new ChunkMachine(newBits);
        Assert.assertNotNull(chunk);

    }

    @Test
    public void testGetChunkSum() throws Exception {
        long[] newBits = new long[bitLength];
        Arrays.fill(newBits, 1);
        Chunk chunk = new ChunkMachine(newBits);
        Assert.assertNotNull(chunk);
        Assert.assertEquals(bitLength, (int) chunk.getChunkSum());
    }


    @Test
    public void testBuildFromLongStrings() throws Exception {
        {    // create one chunk
            long[] newBits = new long[bitLength];
            Arrays.fill(newBits, 1);
            Chunk chunk = new ChunkMachine(newBits);
            Assert.assertNotNull(chunk);
            Assert.assertEquals(bitLength, (int) chunk.getChunkSum());
        }

        {    // create one chunk . longer string, extra bits should be ignored
            long[] newBits = new long[bitLength + 17];
            Arrays.fill(newBits, 1);
            Chunk chunk = new ChunkMachine(newBits);
            Assert.assertNotNull(chunk);
            Assert.assertEquals(bitLength, (int) chunk.getChunkSum());
        }
        {    // check array too short
            long[] newBits = new long[bitLength - 1];
            Arrays.fill(newBits, 1);
            Chunk chunk = new ChunkMachine(newBits);
            Assert.assertNotNull(chunk);
            Assert.assertEquals(bitLength - 1, (int) chunk.getChunkSum());
        }


        {    // create multiple chunk , should create 3 chunks
            long[] newBits = new long[bitLength * 3];
            Arrays.fill(newBits, 1);
            Chunk[] chunks = ChunkMachine.createMultipleChunks(newBits);
            Assert.assertNotNull(chunks);
            Assert.assertEquals(3, chunks.length);
            for (Chunk chunk : chunks) {
                Assert.assertEquals(bitLength, (int) chunk.getChunkSum());
            }

        }
        {    // create multiple chunk , should create 3 chunks, should ignore extra bits
            long[] newBits = new long[(bitLength - 1) + bitLength * 3];
            Arrays.fill(newBits, 1);
            Chunk[] chunks = ChunkMachine.createMultipleChunks(newBits);
            Assert.assertNotNull(chunks);
            Assert.assertEquals(3, chunks.length);
            for (Chunk chunk : chunks) {
                Assert.assertEquals(bitLength, (int) chunk.getChunkSum());
            }

        }

        {    // create multiple chunk , bit length too short
            long[] newBits = new long[(bitLength - 1)];
            Arrays.fill(newBits, 1);
            Chunk[] chunks = ChunkMachine.createMultipleChunks(newBits);
            Assert.assertNotNull(chunks);
            Assert.assertEquals(1, chunks.length);
            for (Chunk chunk : chunks) Assert.assertEquals(bitLength - 1, (int) chunk.getChunkSum());

        }


    }


}
