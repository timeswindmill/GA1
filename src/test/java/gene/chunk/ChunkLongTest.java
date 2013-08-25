package gene.chunk;

import junit.framework.Assert;
import org.junit.Test;

public class ChunkLongTest {
    @Test
    public void testGetHash() throws Exception {
        int newBits = 1;
        Chunk chunk = new ChunkSimple(newBits);
        Assert.assertNotNull(chunk);
        Assert.assertEquals(1.0, chunk.getHash());
    }

    @Test
    public void testGetBits() throws Exception {
        int newBits = 3;
        Chunk chunk = new ChunkSimple(newBits);
        Assert.assertNotNull(chunk);
        Assert.assertEquals(1, chunk.getBits().length);
        Assert.assertEquals(3, chunk.getBits()[0]);


    }

    @Test
    public void testGetChunkSum() throws Exception {
        int newBits = 3;
        Chunk chunk = new ChunkSimple(newBits);
        Assert.assertNotNull(chunk);
        Assert.assertEquals(1, chunk.getBits().length);
        Assert.assertEquals(3.0, chunk.getChunkSum());

    }

}
