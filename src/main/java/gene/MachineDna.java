package gene;


import control.RunConfig;
import gene.chunk.Chunk;
import gene.chunk.ChunkMachine;
import instruction.Program;
import utility.MathsFunctions;

public class MachineDna implements Dna<ChunkMachine> {

    private ChunkMachine[] chunks;

    public MachineDna(ChunkMachine[] newString) {
        chunks = newString;
    }


    @Override
    public ChunkMachine[] getChunks() {
        return chunks;
    }

    @Override
    public double getHash() {
        double sum = 0;
        for (int ii = 0; ii < chunks.length; ii++) {
            sum = sum + chunks[ii].getHash();
        }
        return sum;
    }

    @Override
    public void combineChunks(ChunkMachine[] parent1, ChunkMachine[] parent2) {
        int minLength = (parent1.length < parent2.length) ? parent1.length : parent2.length;
        for (int ii = 0; ii < minLength; ii++) {

            if (MathsFunctions.getRandomInt(100) < RunConfig.INSTANCE.getMutatePercent()) {
                chunks[ii] = ChunkMachine.createRandom();
            }
            if (MathsFunctions.getTrueFalse()) {
                chunks[ii] = parent1[ii];
            } else {
                chunks[ii] = parent2[ii];
            }

        }

    }

    @Override
    public int compareTo(Dna<ChunkMachine> o) {
        if (o == null) {
            return 1;
        }
        double otherHash = o.getHash();
        double myHash = getHash();
        if (otherHash == myHash) {
            return 0;
        } else {
            return (myHash > otherHash ? 1 : -1);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof SimpleDna)) {
            return false;
        }
        SimpleDna otherDna = (SimpleDna) other;
        double otherHash = otherDna.getHash();
        double myHash = getHash();
        if (otherHash == myHash) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (Chunk chunk : chunks) {
            sb.append(chunk);
            sb.append(",");
        }
        // remove spurious comma
        sb.setLength(sb.length() - 1);

        sb.append("}");
        return sb.toString();
    }

    public Program createProgram() {

        int bitLength = ChunkMachine.bitLength;
        int numBits = chunks.length * bitLength;
        int[] allBits = new int[numBits];
        for (int ii = 0; ii < chunks.length; ii++) {
            ChunkMachine chunk = chunks[ii];
            System.arraycopy(chunk.getBits(), 0, allBits, ii * bitLength, bitLength);
        }
        Program newProg = Program.createProgram(allBits);
        return newProg;

    }

}
