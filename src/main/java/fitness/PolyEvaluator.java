package fitness;

import creature.SimpleCritter;
import gene.Dna;
import gene.SimpleDna;
import gene.chunk.Chunk;

public class PolyEvaluator implements FitnessEvaluator<SimpleCritter> {
    @Override
    public void evaluateFitness(SimpleCritter[] critters) {

        for (SimpleCritter critter : critters) {
            evaluateFitness(critter);
        }
    }


    @Override
    public void evaluateFitness(SimpleCritter critter) {
        SimpleDna dna = critter.getDna();
        Chunk[] string = dna.getChunks();
        double answer = calcCF(string);
        double fit = Math.abs(Math.PI - answer);
        double adjFitness = (fit == 0) ? 99999999999999999.0 : 1 / fit;

        Fitness newFitness = Fitness.createFitness(adjFitness);
        critter.getFitness().updateFitness(newFitness);

    }


    private double calcCF(Chunk[] inputs) {

        double total = 1;

        for (Chunk item : inputs) {

            double sum = item.getChunkSum();

            if (sum != 0) {
                total += sum + (1.0 / total);
            }
        }
        return total;
    }


    @Override
    public Fitness getMaxPossibleFitness(Dna simpleDna) {
        return Fitness.createFitness(99999999999999.0);
    }

    @Override
    public Fitness getMinPossibleFitness(Dna simpleDna) {
        return Fitness.createFitness(0);
    }
}
