package fitness;

import control.RunConfig;
import machine.Machine;

import java.util.Arrays;

public class MachineAddTest implements MachineTest {

    public static final int NUM_TESTS = 4;

    private Machine machine;

    public long[] getRegisters(int testNum) {
        long[] newRegisters = new long[RunConfig.INSTANCE.getNumRegisters()];
        Arrays.fill(newRegisters, 1);
        switch (testNum) {

            case 0:
                newRegisters[0] = 0;
                newRegisters[1] = 1;
                newRegisters[2] = 2;
                break;

            case 1:
                newRegisters[0] = 0;
                newRegisters[1] = 5;
                newRegisters[2] = 102;
                break;

            case 2:
                newRegisters[0] = 0;
                newRegisters[1] = -12;
                newRegisters[2] = 22;
                break;

            case 3:
                newRegisters[0] = 0;
                newRegisters[1] = 0;
                newRegisters[2] = 19;
                break;
        }

        return newRegisters;

    }

    public double calculateFitness(Machine machine, int testNum) {
        double correctAnswer = 0;
        double fitness = 0;
        switch (testNum) {

            case 0:
                correctAnswer = 3;
                break;
            case 1:
                correctAnswer = 107;
                break;
            case 2:
                correctAnswer = 10;
                break;
            case 3:
                correctAnswer = 19;
                break;
        }

        if (machine.getRegisters().getValue(0) == correctAnswer) {
            fitness++;
        }
        return fitness;
    }


}
