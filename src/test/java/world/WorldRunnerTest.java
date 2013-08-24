package world;

import fitness.FitnessEvaluator;
import fitness.SumEvaluator;
import junit.framework.Assert;
import org.junit.Test;


public class WorldRunnerTest {

    @Test
    public void testRunOneGeneration() throws Exception {
        FitnessEvaluator sumEvaluator = new SumEvaluator();
        Population testPop = Population.createRandomPopulation(100);
        WorldRunner.runOneGeneration(testPop, sumEvaluator, 1);
        // ? what to test ?
        Assert.assertTrue(testPop.getMeanFitness() > 0);

    }


}
