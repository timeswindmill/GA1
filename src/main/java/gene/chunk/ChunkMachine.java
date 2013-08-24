package gene.chunk;

import control.RunConfig;
import machine.MachineConstants;
import utility.MathsFunctions;

public class ChunkMachine extends ChunkLong {

    //TODO check these are being used
    public static final int NUM_INSTRUCTIONS = RunConfig.INSTANCE.getMinInstructions();
    public static final int bitLength = MachineConstants.INSTRUCTION_LENGTH * NUM_INSTRUCTIONS;
    public static int MAX_BIT = RunConfig.INSTANCE.getMaxDnaBit();

    private long[] bits = new long[bitLength];

    public ChunkMachine() {

    }

    public ChunkMachine(long[] newBits) {
        int length = newBits.length < bitLength ? newBits.length : bitLength;
        // only allow bitlength bits
        System.arraycopy(newBits, 0, bits, 0, length);
    }


    @Override
    public double getHash() {
        return getChunkSum();
    }

    @Override
    public long[] getBits() {
        return bits;
    }

    @Override
    public double getChunkSum() {
        double sum = 0;
        for (long bit : bits) {
            sum += bit;
        }
        return sum;
    }

//    @Override
//    public void randomizeBits() {
//        for (int ii = 0; ii < bits.length; ii++) {
//            bits[ii] = MathsFunctions.getRandomInt(MAX_BIT);
//        }
//    }

    // helper method
    public static ChunkMachine createRandom() {
        long[] bits = new long[bitLength];
        for (int ii = 0; ii < bits.length; ii++) {
            bits[ii] = MathsFunctions.getRandomInt(MAX_BIT);
        }
        ChunkMachine newChunk = new ChunkMachine(bits);
        return newChunk;
    }

    // helper method
    public static ChunkMachine[] createMultipleChunks(long[] bits) {
        ChunkMachine[] newChunks;
        // for safety pad array if it isnt long enough
        if (bits.length < bitLength) {
            long[] fillArray = new long[bitLength];
            System.arraycopy(bits, 0, fillArray, 0, bits.length);
            bits = fillArray;
        }
        // this will round down
        int numChunks = bits.length / ChunkMachine.bitLength;
        newChunks = new ChunkMachine[numChunks];
        long[] tempBits = new long[bitLength];
        for (int ii = 0; ii < numChunks; ii++) {
            System.arraycopy(bits, ii * bitLength, tempBits, 0, bitLength);
            newChunks[ii] = new ChunkMachine(tempBits);
        }
        return newChunks;
    }


}
