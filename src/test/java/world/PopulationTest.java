package world;

import creature.Critter;
import creature.SimpleCritter;
import fitness.Fitness;
import fitness.FitnessEvaluator;
import fitness.SumEvaluator;
import gene.EvaluatorOrdinal;
import gene.EvaluatorTen;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

public class PopulationTest {

    @Test
    public void testCreateRandomPopulation() throws Exception {
        // create a population of size 10
        Population testPop = new PopulationSimple();
        testPop.createRandomPopulation(10);
        // test that critters are set up
        for (Critter critter : testPop.getCopyOfCritters()) {
            Assert.assertEquals(0.0, critter.getFitness().getFitness());
        }


    }

    @Test
    public void testEvaluateFitness() throws Exception {
        FitnessEvaluator evaluatorTen = new EvaluatorTen();
        Population testPop = new PopulationSimple();
        testPop.createRandomPopulation(10);
        testPop.evaluatePopulationFitness(evaluatorTen);
        double meanFitness = testPop.getMeanFitness();
        Assert.assertEquals(10.0, meanFitness);


    }

    @Test
    public void testSumEvaluateFitness() throws Exception {
        FitnessEvaluator evaluatorSum = new SumEvaluator();
        Population testPop = new PopulationSimple();
        testPop.createRandomPopulation(10);
        testPop.evaluatePopulationFitness(evaluatorSum);
        double meanFitness = testPop.getMeanFitness();
        Assert.assertTrue(meanFitness > 0);


    }


    @Test
    public void testGetMeanFitness() throws Exception {

        Population testPop2 = new PopulationSimple();
        testPop2.createRandomPopulation(10);

        FitnessEvaluator evaluatorTen = new EvaluatorTen();
        testPop2.evaluatePopulationFitness(evaluatorTen);
        double avFit2 = testPop2.getMeanFitness();
        Assert.assertEquals(10.0, avFit2);


    }

    @Test
    public void testGetRandomCritter() throws Exception {


        // now check for randomness
        Population testLargePop = new PopulationSimple();
        testLargePop.createRandomPopulation(10);

        Critter critter1 = testLargePop.getRandomCritter();
        Critter critter2 = testLargePop.getRandomCritter();
        Critter critter3 = testLargePop.getRandomCritter();
        Critter critter4 = testLargePop.getRandomCritter();
        Critter critter5 = testLargePop.getRandomCritter();

        if ((critter1 == critter2) && (critter1 == critter3) && (critter1 == critter4)) {
            Assert.assertFalse((critter1 == critter5));
        }


    }

    @Test
    public void testGetBestCritters() throws Exception {
        Population testPop = new PopulationSimple();
        testPop.createRandomPopulation(100);
        FitnessEvaluator evaluatorOrdinal = new EvaluatorOrdinal();
        testPop.evaluatePopulationFitness(evaluatorOrdinal);

        List<SimpleCritter> best;
        best = testPop.getSortedCritters();
        Fitness minFitness = best.get(0).getFitness();
        Fitness maxFitness = best.get(99).getFitness();
        Assert.assertTrue(maxFitness.compareTo(minFitness) >= 0);


        Fitness previousFitness = minFitness;
        // test set of best creatures
        for (int ii = 1; ii < 9; ii++) {
            Fitness thisFitness = best.get(ii).getFitness();
            Assert.assertTrue(thisFitness.compareTo(previousFitness) >= 0);
            previousFitness = thisFitness;
        }
        // now test all creatures
        for (Critter critter : testPop.getCopyOfCritters()) {
            Fitness thisFitness = critter.getFitness();
            Assert.assertTrue(thisFitness.compareTo(maxFitness) <= 0);
        }

    }

}
