package world;


import control.RunConfig;
import creature.Critter;
import creature.SimpleCritter;
import fitness.FitnessEvaluator;

import java.util.List;

public class WorldRunner {


    public static void runOneGeneration(Population worldPopulation, FitnessEvaluator evaluator, int generationNumber) {


        worldPopulation.evaluatePopulationFitness(evaluator);
        try {
            runTournament(worldPopulation);
        } catch (Exception e) {
            System.out.println("Tournament Failure " + e);
        }


    }


    public static void runTournament(Population worldPopulation) {
        // sort critters according to fitness
        List<SimpleCritter> sortedCritters = worldPopulation.getSortedCritters();
        int tournamentSize = worldPopulation.getPopulationSize() / RunConfig.INSTANCE.getTournamentPercent();
        for (int ii = 0; ii < tournamentSize; ii++) {

            Critter thisBestCritter = sortedCritters.get(sortedCritters.size() - ii - 1);
            Critter randomCritter = worldPopulation.getRandomCritter();
            Critter newOffspring = sortedCritters.get(ii);

            if ((randomCritter == null) || (newOffspring == null)) {
                System.out.println("Unable to select Critters for tournament");

            } else {

                newOffspring.reset(thisBestCritter.getDna(), randomCritter.getDna());

            }

        }


    }


}





