package gene.chunk;

public interface Chunk {

    public double getHash();

    public long[] getBits();

    public double getChunkSum();

    public void randomizeBits();

}
