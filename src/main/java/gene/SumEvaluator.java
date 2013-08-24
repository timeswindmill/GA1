package gene;

import creature.Critter;

public class SumEvaluator implements FitnessEvaluator {
    @Override
    public void evaluateFitness(Critter[] critterString) {

    }

    @Override
    public void evaluateFitness(Critter critter) {

    }


//    @Override
//    public int evaluateFitness(long[] dnaString) {
//        int sum=0;
//        for(long thisLong : dnaString){
//            long absVal = Math.abs(thisLong);
//            if(absVal <100){
//              //  System.out.println("less than 10000");
//                sum +=absVal;
//            }
//        }
//
//       return sum;
//
//
//    }
}
