package world;

import creature.CritterHelper;
import creature.SimpleCritter;
import fitness.Fitness;
import fitness.FitnessEvaluator;
import utility.MathsFunctions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PopulationSimple implements Population<SimpleCritter> {


    private SimpleCritter[] allCritters;

    @Override
    public int getPopulationSize() {
        return allCritters.length;
    }

    @Override
    public void evaluatePopulationFitness(FitnessEvaluator evaluator) {
        evaluator.evaluateFitness(allCritters);
    }

    @Override
    public SimpleCritter getRandomCritter() {
        int selected = MathsFunctions.getRandomInt(allCritters.length);
        return allCritters[selected];

    }

    @Override
    public List<SimpleCritter> getSortedCritters() {
        List<SimpleCritter> CritterArray = Arrays.asList(allCritters);
        Collections.sort(CritterArray);
        return CritterArray;

    }

    @Override
    public double getMeanFitness() {
        if (allCritters.length == 0) {
            return 0;
        }
        Fitness[] allFitnesses = new Fitness[allCritters.length];
        for (int ii = 0; ii < allCritters.length; ii++) {
            allFitnesses[ii] = allCritters[ii].getFitness();
        }
        double meanFitness = Fitness.getMeanFitness(allFitnesses);
        return meanFitness;

    }

    @Override
    public void createRandomPopulation(int startSize) {
        allCritters = new SimpleCritter[startSize];
        for (int ii = 0; ii < startSize; ii++) {
            SimpleCritter newCritter = CritterHelper.createRandomSimpleCritter(ii);
            allCritters[ii] = newCritter;

        }
    }

    @Override
    public SimpleCritter[] getCopyOfCritters() {
        return allCritters;
    }

}
