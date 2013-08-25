package gene.chunk;


import control.RunConfig;
import utility.MathsFunctions;

import java.io.Serializable;

public class ChunkSimple implements Chunk, Serializable {

    private int bits;
    private static int MAX_BIT = RunConfig.INSTANCE.getMaxDnaBit();
    private static int BIT_LENGTH = 1;

    public ChunkSimple() {

    }

    public ChunkSimple(int newBits) {
        bits = newBits;
    }

    @Override
    public double getHash() {
        long value = bits;
        return value;
    }

    @Override
    public int[] getBits() {
        int[] bits = new int[1];
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

    public static ChunkSimple createRandom() {
        int bits = MathsFunctions.getRandomInt(MAX_BIT);
        ChunkSimple newChunk = new ChunkSimple(bits);
        return newChunk;
    }


}
