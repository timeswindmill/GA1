package world;

import creature.CritterHelper;
import creature.SimpleCritter;
import fitness.Fitness;
import fitness.FitnessEvaluator;
import net.jcip.annotations.NotThreadSafe;
import utility.MathsFunctions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@NotThreadSafe
public class Population {

    private SimpleCritter[] allCritters;

    private Population(int startSize) {

        allCritters = new SimpleCritter[startSize];

    }


    public static Population createRandomPopulation(int startSize) {
        Population population = new Population(startSize);
        for (int ii = 0; ii < startSize; ii++) {
            SimpleCritter newCritter = CritterHelper.createNewRandomCritter(ii);
            population.allCritters[ii] = newCritter;

        }
        return population;

    }

    public int getPopulationSize() {
        return allCritters.length;
    }

    // only use this testing
    public SimpleCritter[] getCopyOfCritters() {
        //shallow copy
        SimpleCritter[] copyArray = Arrays.copyOf(allCritters, allCritters.length);
        return copyArray;
    }


    public void evaluatePopulationFitness(FitnessEvaluator evaluator) {
        evaluator.evaluateFitness(allCritters);

    }


    public SimpleCritter getRandomCritter() {
        int selected = MathsFunctions.getRandomInt(allCritters.length);
        return allCritters[selected];
    }

    public List<SimpleCritter> getSortedCritters() {

        List<SimpleCritter> CritterArray = Arrays.asList(allCritters);
        Collections.sort(CritterArray);
        return CritterArray;

    }


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

}
