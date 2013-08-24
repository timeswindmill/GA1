package gene;


import gene.chunk.Chunk;

import java.io.Serializable;

public interface Dna<T extends Chunk> extends Serializable, Comparable<Dna<T>> {

    public T[] getChunks();

    public double getHash();

    public void combineChunks(T[] parent1, T[] parent2);


}
