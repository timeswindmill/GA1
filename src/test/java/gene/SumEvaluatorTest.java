package gene;

import creature.CritterHelper;
import creature.SimpleCritter;
import fitness.FitnessEvaluator;
import fitness.SumEvaluator;
import junit.framework.Assert;
import org.junit.Test;

public class SumEvaluatorTest {
    @Test
    public void testEvaluateFitness() throws Exception {

        int[] startString1 = {1, 3, 5, 7, 9};

        SimpleDna newSimpleDna1 = SimpleDnaHelper.INSTANCE.createDnaFromString(startString1);
        SimpleCritter critter = CritterHelper.createNewSimpleCritter(newSimpleDna1, 1);
        FitnessEvaluator sumEvaluator = new SumEvaluator();
        sumEvaluator.evaluateFitness(critter);
        double fitness = critter.getFitness().getFitness();
        Assert.assertEquals(25.0, fitness);

    }

}
