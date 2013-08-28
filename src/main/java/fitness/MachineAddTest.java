package fitness;

import control.RunConfig;
import machine.Machine;

import java.util.Arrays;

public class MachineAddTest implements MachineTest {

    public static final int NUM_TESTS = 8;

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

            case 4:
                newRegisters[0] = 0;
                newRegisters[1] = 10;
                newRegisters[2] = 19;
                break;

            case 5:
                newRegisters[0] = 11;
                newRegisters[1] = 20;
                newRegisters[2] = 3;
                break;

            case 6:
                newRegisters[0] = 18;
                newRegisters[1] = 2;
                newRegisters[2] = 11;
                break;

            case 7:
                newRegisters[0] = 0;
                newRegisters[1] = 0;
                newRegisters[2] = 145;
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
            case 4:
                correctAnswer = 29;
                break;
            case 5:
                correctAnswer = 23;
                break;
            case 6:
                correctAnswer = 13;
                break;
            case 7:
                correctAnswer = 145;
                break;

        }

        if (machine.getRegisters().getValue(0) == correctAnswer) {
            fitness++;
        }
        return fitness;
    }


}
