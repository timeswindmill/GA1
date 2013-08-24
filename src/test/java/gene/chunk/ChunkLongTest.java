package gene.chunk;

import junit.framework.Assert;
import org.junit.Test;

public class ChunkLongTest {
    @Test
    public void testGetHash() throws Exception {
        Long newBits = new Long(1);
        Chunk chunk = new ChunkLong(newBits);
        Assert.assertNotNull(chunk);
        Assert.assertEquals(1.0, chunk.getHash());


    }

    @Test
    public void testGetBits() throws Exception {
        Long newBits = new Long(3);
        Chunk chunk = new ChunkLong(newBits);
        Assert.assertNotNull(chunk);
        Assert.assertEquals(1, chunk.getBits().length);
        Assert.assertEquals(3, chunk.getBits()[0]);


    }

    @Test
    public void testGetChunkSum() throws Exception {
        Long newBits = new Long(3);
        Chunk chunk = new ChunkLong(newBits);
        Assert.assertNotNull(chunk);
        Assert.assertEquals(1, chunk.getBits().length);
        Assert.assertEquals(3.0, chunk.getChunkSum());

    }

}
