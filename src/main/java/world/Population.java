package world;

import creature.Critter;
import fitness.FitnessEvaluator;
import net.jcip.annotations.NotThreadSafe;

import java.util.List;

@NotThreadSafe
public interface Population<T extends Critter> {

    public int getPopulationSize();

    public void evaluatePopulationFitness(FitnessEvaluator evaluator);

    public T getRandomCritter();

    public List<T> getSortedCritters();

    public double getMeanFitness();

    public void createRandomPopulation(int startSize);

    public T[] getCopyOfCritters();

    //   private T[] allCritters;

//    private Population(int startSize) {
//
//        allCritters = new T[startSize];
//
//    }

//
//    public static Population createRandomPopulation(int startSize) {
//        Population population = new Population(startSize);
//        for (int ii = 0; ii < startSize; ii++) {
//            T newCritter = CritterHelper.createNewRandomCritter(ii);
//            population.allCritters[ii] = newCritter;
//
//        }
//        return population;
//
//    }
//

//    public int getPopulationSize() {
//        return allCritters.length;
//    }
//
//    // only use this testing
//    public T[] getCopyOfCritters() {
//        //shallow copy
//        T[] copyArray = Arrays.copyOf(allCritters, allCritters.length);
//        return copyArray;
//    }
//
//
//    public void evaluatePopulationFitness(FitnessEvaluator evaluator) {
//        evaluator.evaluateFitness(allCritters);
//
//    }
//
//
//    public SimpleCritter getRandomCritter() {
//        int selected = MathsFunctions.getRandomInt(allCritters.length);
//        return allCritters[selected];
//    }
//
//    public List<SimpleCritter> getSortedCritters() {
//
//        List<SimpleCritter> CritterArray = Arrays.asList(allCritters);
//        Collections.sort(CritterArray);
//        return CritterArray;
//
//    }
//
//
//    public double getMeanFitness() {
//        if (allCritters.length == 0) {
//            return 0;
//        }
//        Fitness[] allFitnesses = new Fitness[allCritters.length];
//        for (int ii = 0; ii < allCritters.length; ii++) {
//            allFitnesses[ii] = allCritters[ii].getFitness();
//        }
//        double meanFitness = Fitness.getMeanFitness(allFitnesses);
//        return meanFitness;
//    }

}
