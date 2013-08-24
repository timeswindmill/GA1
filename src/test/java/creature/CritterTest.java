package creature;

import fitness.Fitness;
import fitness.FitnessEvaluator;
import gene.*;
import junit.framework.Assert;
import org.junit.Test;

public class CritterTest {


    @Test
    public void testCreateSimpleCritter() throws Exception {

        SimpleDna dna = SimpleDnaHelper.INSTANCE.createRandomDna();
        Critter simple = new SimpleCritter(23, dna);
        Assert.assertNotNull(simple);
        Assert.assertNotNull(simple.getDna());
        Assert.assertEquals(0.0, simple.getFitness().getFitness());
        Assert.assertEquals(23, simple.getID());
    }


    @Test
    public void testResetCritter() throws Exception {
        SimpleDna dna = SimpleDnaHelper.INSTANCE.createRandomDna();
        double originalHash = dna.getHash();
        SimpleCritter simple = new SimpleCritter(23, dna);
        Assert.assertNotNull(simple);
        Assert.assertEquals(0.0, simple.getFitness().getFitness());
        Fitness newFitness = Fitness.createFitness(13);
        simple.getFitness().updateFitness(newFitness);
        Assert.assertEquals(13.0, simple.getFitness().getFitness());


        SimpleDna dnaParent1 = SimpleDnaHelper.INSTANCE.createRandomDna();
        SimpleDna dnaParent2 = SimpleDnaHelper.INSTANCE.createRandomDna();
        simple.reset(dnaParent1, dnaParent2);
        Assert.assertEquals(0.0, simple.getFitness().getFitness());
        Assert.assertNotNull(simple);
        Assert.assertNotNull(simple.getDna());
        Assert.assertTrue(originalHash != simple.getDna().getHash());

    }

    @Test
    public void testCompareCritter() throws Exception {


        SimpleDna dna1 = SimpleDnaHelper.INSTANCE.createRandomDna();
        SimpleCritter simple1 = new SimpleCritter(23, dna1);
        Assert.assertNotNull(simple1);
        Assert.assertEquals(0.0, simple1.getFitness().getFitness());

        SimpleDna dna2 = SimpleDnaHelper.INSTANCE.createRandomDna();
        Critter simple2 = new SimpleCritter(23, dna2);
        Assert.assertNotNull(simple2);
        Assert.assertEquals(0.0, simple2.getFitness().getFitness());

        simple1.getFitness().updateFitness(Fitness.createFitness(13));
        simple2.getFitness().updateFitness(Fitness.createFitness(133));

        Assert.assertTrue(simple1.compareTo(simple2) < 0);

        simple2.getFitness().updateFitness(Fitness.createFitness(11));
        Assert.assertTrue(simple1.compareTo(simple2) > 0);


        simple2.getFitness().updateFitness(Fitness.createFitness(13));
        Assert.assertTrue(simple1.compareTo(simple2) == 0);

        Assert.assertTrue(simple1.compareTo(null) > 0);


    }


    @Test
    public void testEvaluateFitness() throws Exception {

        SimpleCritter c1 = CritterHelper.createRandomSimpleCritter(1);
        SimpleCritter c2 = CritterHelper.createRandomSimpleCritter(2);
        SimpleCritter c3 = CritterHelper.createRandomSimpleCritter(13);


        FitnessEvaluator evaluatorZero = new EvaluatorZero();
        FitnessEvaluator evaluatorTen = new EvaluatorTen();
        FitnessEvaluator evaluatorOrdinal = new EvaluatorOrdinal();

        evaluatorTen.evaluateFitness(c1);
        evaluatorZero.evaluateFitness(c2);
        evaluatorOrdinal.evaluateFitness(c3);

        Assert.assertEquals(10.0, c1.getFitness().getFitness());
        Assert.assertEquals(0.0, c2.getFitness().getFitness());
        Assert.assertEquals(13.0, c3.getFitness().getFitness());

    }


}
