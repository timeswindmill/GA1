package gene.chunk;

import control.RunConfig;
import machine.MachineConstants;
import utility.MathsFunctions;

import java.io.Serializable;

public class ChunkMachine implements Chunk, Serializable {

    //TODO check these are being used
    public static final int NUM_INSTRUCTIONS = RunConfig.INSTANCE.getMinInstructions();
    public static final int bitLength = MachineConstants.INSTRUCTION_LENGTH * NUM_INSTRUCTIONS;
    public static int MAX_BIT = RunConfig.INSTANCE.getMaxDnaBit();

    private int[] machineBits = new int[bitLength];

    public ChunkMachine() {

    }

    public ChunkMachine(int[] newBits) {
        int length = newBits.length < bitLength ? newBits.length : bitLength;
        // only allow bitlength bits
        System.arraycopy(newBits, 0, machineBits, 0, length);
    }


    @Override
    public double getHash() {
        return getChunkSum();
    }

    @Override
    public int[] getBits() {
        return machineBits;
    }

    @Override
    public double getChunkSum() {
        double sum = 0;
        for (long bit : machineBits) {
            sum += bit;
        }
        return sum;
    }


    // helper method
    public static ChunkMachine createRandom() {
        int[] bits = new int[bitLength];
        for (int ii = 0; ii < bits.length; ii++) {
            bits[ii] = MathsFunctions.getRandomInt(MAX_BIT);
        }
        ChunkMachine newChunk = new ChunkMachine(bits);
        return newChunk;
    }

    // helper method
    public static ChunkMachine[] createMultipleChunks(int[] bits) {
        ChunkMachine[] newChunks;
        // for safety pad array if it isnt long enough
        if (bits.length < bitLength) {
            int[] fillArray = new int[bitLength];
            System.arraycopy(bits, 0, fillArray, 0, bits.length);
            bits = fillArray;
        }
        // this will round down
        int numChunks = bits.length / ChunkMachine.bitLength;
        newChunks = new ChunkMachine[numChunks];
        int[] tempBits = new int[bitLength];
        for (int ii = 0; ii < numChunks; ii++) {
            System.arraycopy(bits, ii * bitLength, tempBits, 0, bitLength);
            newChunks[ii] = new ChunkMachine(tempBits);
        }
        return newChunks;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (long thisBit : machineBits) {
            sb.append(thisBit);
            sb.append(",");
        }
        // remove spurious comma
        sb.setLength(sb.length() - 1);

        sb.append("}");
        return sb.toString();

    }


}
