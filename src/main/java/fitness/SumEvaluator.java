package fitness;

import control.RunConfig;
import creature.SimpleCritter;
import gene.SimpleDna;
import gene.chunk.Chunk;
import gene.chunk.ChunkLong;

public class SumEvaluator implements FitnessEvaluator<SimpleCritter> {
    @Override
    public void evaluateFitness(SimpleCritter[] critters) {
        for (SimpleCritter critter : critters) {
            evaluateFitness(critter);
        }
    }

    @Override
    public void evaluateFitness(SimpleCritter critter) {
        Fitness newFitness = evaluateFitness(critter.getDna());
        critter.getFitness().updateFitness(newFitness);

    }


    private Fitness evaluateFitness(SimpleDna simpleDna) {
        Chunk[] dnaChunks = simpleDna.getChunks();

        int sum = 0;

        for (Chunk thisChunk : dnaChunks) {
            sum += thisChunk.getChunkSum();
        }
        return Fitness.createFitness(sum);
    }


    @Override
    public Fitness getMinPossibleFitness(gene.Dna simpleDna) {
        return Fitness.createFitness(0.0);
    }

    @Override
    public Fitness getMaxPossibleFitness(gene.Dna simpleDna) {
        Chunk[] chunks = simpleDna.getChunks();
        int chunkLength = chunks.length;
        // only implemented ChunkLong so far
        if (chunks[0] instanceof ChunkLong) {
            int maxBit = RunConfig.INSTANCE.getMaxDnaBit();
            double maxVal = Math.pow(maxBit, chunkLength);
            return Fitness.createFitness(maxVal);

        }
        return Fitness.createFitness(999999999);


    }


}
