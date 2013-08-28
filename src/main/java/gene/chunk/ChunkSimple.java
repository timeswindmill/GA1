package gene.chunk;


import control.RunConfig;
import utility.MathsFunctions;

import java.io.Serializable;

public class ChunkSimple implements Chunk, Serializable {

    private int simpleBits;
    private static int MAX_BIT = RunConfig.INSTANCE.getMaxDnaBit();
    private static int BIT_LENGTH = 1;

    public ChunkSimple() {

    }

    public ChunkSimple(int newBits) {
        simpleBits = newBits;
    }

    @Override
    public double getHash() {
        long value = simpleBits;
        return value;
    }

    @Override
    public int[] getBits() {
        int[] bits = new int[1];
        bits[0] = this.simpleBits;
        return bits;
    }

    @Override
    public double getChunkSum() {
        return simpleBits;
    }

//    @Override
//    public void randomizeBits() {
//        bits = MathsFunctions.getRandomInt(MAX_BIT);
//
//    }

    public String toString() {
        return String.valueOf(simpleBits);
    }

    public static ChunkSimple createRandom() {
        int bits = MathsFunctions.getRandomInt(MAX_BIT);
        ChunkSimple newChunk = new ChunkSimple(bits);
        return newChunk;
    }


}
