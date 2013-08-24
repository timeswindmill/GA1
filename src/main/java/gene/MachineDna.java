package gene;


import control.RunConfig;
import gene.chunk.Chunk;
import gene.chunk.ChunkMachine;
import utility.MathsFunctions;

public class MachineDna implements Dna<ChunkMachine> {

    private ChunkMachine[] dnaString;

    public MachineDna(ChunkMachine[] newString) {
        dnaString = newString;
    }


    @Override
    public ChunkMachine[] getChunks() {
        return dnaString;
    }

    @Override
    public double getHash() {
        double sum = 0;
        for (int ii = 0; ii < dnaString.length; ii++) {
            sum = sum + dnaString[ii].getHash();
        }
        return sum;
    }

    @Override
    public void combineChunks(ChunkMachine[] parent1, ChunkMachine[] parent2) {
        int minLength = (parent1.length < parent2.length) ? parent1.length : parent2.length;
        for (int ii = 0; ii < minLength; ii++) {

            if (MathsFunctions.getRandomInt(100) < RunConfig.INSTANCE.getMutatePercent()) {
                dnaString[ii].randomizeBits();
            }
            if (MathsFunctions.getTrueFalse()) {
                dnaString[ii] = parent1[ii];
            } else {
                dnaString[ii] = parent2[ii];
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

        for (Chunk chunk : dnaString) {
            sb.append(chunk);
            sb.append(",");
        }
        // remove spurious comma
        sb.setLength(sb.length() - 1);

        sb.append("}");
        return sb.toString();
    }


}
