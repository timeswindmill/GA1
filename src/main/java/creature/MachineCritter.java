package creature;

import fitness.Fitness;
import gene.MachineDna;
import gene.chunk.ChunkMachine;

public class MachineCritter implements Critter<MachineDna> {

    private MachineDna myDna;
    private Fitness fitness;
    private int ID = -1;

    public MachineCritter(int ID, MachineDna machineDna) {
        this.ID = ID;
        this.myDna = machineDna;
        fitness = Fitness.createFitness(0);
    }


    @Override
    public MachineDna getDna() {
        return myDna;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public Fitness getFitness() {
        return fitness;
    }


    @Override
    public void reset(MachineDna parent1, MachineDna parent2) {
        ChunkMachine[] p1 = parent1.getChunks();
        ChunkMachine[] p2 = parent2.getChunks();
        myDna.combineChunks(p1, p2);
        fitness.resetFitness();
    }


    @Override
    public int compareTo(Critter o) {
        if (o == null) {
            return 1;
        }
        return this.fitness.compareTo(o.getFitness());
    }
}
