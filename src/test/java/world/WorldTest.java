package world;

import creature.MachineCritter;
import gene.MachineDna;
import junit.framework.Assert;
import org.junit.Test;
import utility.LiteLog;

import java.util.List;

public class WorldTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void buildSimpleWorld() throws Exception {

        World simpleWorld = SumEvaluatorWorld.buildSumEvaluatorWorld();
        Assert.assertNotNull(simpleWorld);

    }

    @Test
    public void runBigTest() throws Exception {
        int numGenerations = 9999;
        long startTime = System.currentTimeMillis();
        World simpleWorld = SumEvaluatorWorld.buildSumEvaluatorWorld();
        Assert.assertNotNull(simpleWorld);
        simpleWorld.runWorld(numGenerations);


    }

//    @Test
//    public void runPolyTest() throws Exception {
//        int numGenerations = 999;
//        long startTime = System.currentTimeMillis();
//        World simpleWorld = PolyWorld.buildPolyWorld();
//        simpleWorld.runWorld(numGenerations);
//
//        List<SimpleCritter> sorted = simpleWorld.getSortedCritters();
//        LiteLog.Log("Best is " + sorted.get(sorted.size() - 1).getDna());
//        double diff = sorted.get(sorted.size() - 1).getFitness().getFitness();
//        LiteLog.Log("Difference is " + 1 / diff);
//
//        LiteLog.Log("Worst is " + sorted.get(0).getDna());
//
//        double elapsedTime = System.currentTimeMillis() - startTime;
//        double avTime = elapsedTime / (1000 * numGenerations);
//        double gensPerDay = 60 * 60 * 10 / avTime;
//
//        System.out.println("Gens per Day : " + gensPerDay);
//
//    }

    @Test
    public void runMachineTest() throws Exception {

        int numGenerations = 99999;
        long startTime = System.currentTimeMillis();
        World machineWorld = MachineWorld.buildMachineWorld();
        machineWorld.runWorld(numGenerations);

        List<MachineCritter> sorted = machineWorld.getSortedCritters();
        MachineCritter bestCritter = sorted.get(sorted.size() - 1);
        MachineDna bestDna = bestCritter.getDna();
        LiteLog.Log("Best is " + bestDna);
        LiteLog.Log("Fitness is " + bestCritter.getFitness().getFitness());
        LiteLog.Log("Program is \n" + bestDna.createProgram());

        double diff = sorted.get(sorted.size() - 1).getFitness().getFitness();
        LiteLog.Log("Difference is " + 1 / diff);

        //      LiteLog.Log("Worst is " + sorted.get(0).getDna());

        double elapsedTime = System.currentTimeMillis() - startTime;
        double avTime = elapsedTime / (1000 * numGenerations);
        double gensPerDay = 60 * 60 * 10 / avTime;

        System.out.println("Gens per Day : " + gensPerDay);


    }


}
