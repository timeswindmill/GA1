package gene.chunk;


import control.RunConfig;
import utility.MathsFunctions;

import java.io.Serializable;

public class ChunkLong implements Chunk, Serializable {

    private long bits;
    private static int MAX_BIT = RunConfig.INSTANCE.getMaxDnaBit();
    private static int BIT_LENGTH = 1;

    public ChunkLong() {

    }

    public ChunkLong(long newBits) {
        bits = newBits;
    }

    @Override
    public double getHash() {
        long value = bits;
        return value;
    }

    @Override
    public long[] getBits() {
        long[] bits = new long[1];
        bits[0] = this.bits;
        return bits;
    }

    @Override
    public double getChunkSum() {
        return bits;
    }

//    @Override
//    public void randomizeBits() {
//        bits = MathsFunctions.getRandomInt(MAX_BIT);
//
//    }

    public String toString() {
        return String.valueOf(bits);
    }

    public static ChunkLong createRandom() {
        long bits = MathsFunctions.getRandomInt(MAX_BIT);
        ChunkLong newChunk = new ChunkLong(bits);
        return newChunk;
    }


}
