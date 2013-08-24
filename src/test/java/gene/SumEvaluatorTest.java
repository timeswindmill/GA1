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

        long[] startString1 = {1L, 3L, 5L, 7L, 9L};

        SimpleDna newSimpleDna1 = DnaHelper.createSimpleDnaFromLongString(startString1);
        SimpleCritter critter = CritterHelper.createNewSimpleCritter(newSimpleDna1, 1);
        FitnessEvaluator sumEvaluator = new SumEvaluator();
        sumEvaluator.evaluateFitness(critter);
        double fitness = critter.getFitness().getFitness();
        Assert.assertEquals(25.0, fitness);

    }

}
