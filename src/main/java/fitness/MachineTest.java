package fitness;

import machine.Machine;

public interface MachineTest {

    public long[] getRegisters(int testNum);

    public double calculateFitness(Machine machine, int testNum);

}
