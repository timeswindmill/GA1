package creature;


import fitness.Fitness;
import gene.SimpleDna;
import gene.chunk.ChunkLong;

public class SimpleCritter implements Critter<SimpleDna> {

    private SimpleDna myDna;
    private Fitness fitness;
    private int ID = -1;

    public SimpleCritter(int ID, SimpleDna simpleDna) {
        this.ID = ID;
        this.myDna = simpleDna;
        fitness = Fitness.createFitness(0);
    }


    @Override
    public SimpleDna getDna() {
        return myDna;
    }

    @Override
    public int getID() {
        return ID;
    }

    public Fitness getFitness() {
        return fitness;
    }

    @Override
    public void reset(SimpleDna parent1, SimpleDna parent2) {
        ChunkLong[] p1 = parent1.getChunks();
        ChunkLong[] p2 = parent2.getChunks();
        myDna.combineChunks(p1, p2);
        fitness.resetFitness();
    }


    public int compareTo(Critter o) {
        if (o == null) {
            return 1;
        }
        return this.fitness.compareTo(o.getFitness());

    }
}
