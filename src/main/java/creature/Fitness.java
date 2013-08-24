package creature;

public class Fitness {


    private static final double DEFAULT_FITNESS = 0;
    private double fitness = DEFAULT_FITNESS;


    private Fitness() {
    }

    public static Fitness createFitness(double fitness) {
        Fitness newFitness = new Fitness();
        newFitness.fitness = fitness;
        return newFitness;
    }

    public static Fitness createFitness() {
        Fitness newFitness = new Fitness();
        newFitness.fitness = DEFAULT_FITNESS;
        return newFitness;

    }


    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        // do normalisation here if required
        this.fitness = fitness;
    }

    public void resetFitness() {
        fitness = 0;
    }


    public static double getMeanFitness(Fitness[] allFitnesses) {
        double meanFitness = 0;
        if (allFitnesses.length == 0) {
            return 0;

        }
        for (Fitness fitness : allFitnesses) {
            meanFitness = meanFitness + fitness.fitness;
        }
        meanFitness = meanFitness / allFitnesses.length;
        return meanFitness;
    }


    public int compareTo(Fitness o) {

        if (o == null) {
            return 1;
        }
        if (this.fitness < o.fitness) {
            return -1;
        }
        if (this.fitness > o.fitness) {
            return 1;
        }
        return 0;
    }

}
