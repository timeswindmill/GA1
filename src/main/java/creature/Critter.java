package creature;

import fitness.Fitness;
import gene.Dna;

public interface Critter<T extends Dna> extends Comparable<Critter> {

    public T getDna();

    public int getID();

    public Fitness getFitness();

    public void reset(T parent1, T parent2);


}
