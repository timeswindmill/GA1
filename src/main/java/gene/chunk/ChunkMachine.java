package gene.chunk;

import control.RunConfig;
import machine.MachineConstants;
import utility.MathsFunctions;

public class ChunkMachine extends ChunkLong {

    private static final int NUM_INSTRUCTIONS = RunConfig.INSTANCE.getMinInstructions();
    private static final int bitLength = MachineConstants.INSTRUCTION_LENGTH * NUM_INSTRUCTIONS;
    private static int MAX_BIT = RunConfig.INSTANCE.getMaxDnaBit();

    private long[] bits;

    private ChunkMachine() {

    }

    public ChunkMachine(long[] newBits) {
        bits = newBits;
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

    @Override
    public void randomizeBits() {
        for (int ii = 0; ii < bits.length; ii++) {
            bits[ii] = MathsFunctions.getRandomInt(MAX_BIT);
        }
    }

}
