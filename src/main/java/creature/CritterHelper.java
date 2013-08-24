package creature;

import gene.MachineDna;
import gene.MachineDnaHelper;
import gene.SimpleDna;
import gene.SimpleDnaHelper;

public class CritterHelper {

    private static SimpleDnaHelper simpleDnaHelper = SimpleDnaHelper.INSTANCE;
    private static MachineDnaHelper machineDnaHelper = MachineDnaHelper.INSTANCE;


    public static SimpleCritter createRandomSimpleCritter(int ID) {
        // use chunkLong chunks
        SimpleDna newSimpleDna = simpleDnaHelper.createRandomDna();
        return createNewSimpleCritter(newSimpleDna, ID);
    }

    public static MachineCritter createNewRandomMachineCritter(int ID) {
        // use chunkLong chunks
        MachineDna newMachineDna = machineDnaHelper.createRandomDna();
        return createNewMachineCritter(newMachineDna, ID);
    }


    public static SimpleCritter createNewSimpleCritter(SimpleDna simpleDna, int ID) {
        SimpleCritter critter = new SimpleCritter(ID, simpleDna);
        return critter;
    }

    public static MachineCritter createNewMachineCritter(MachineDna machineDna, int ID) {
        MachineCritter critter = new MachineCritter(ID, machineDna);
        return critter;
    }


}
