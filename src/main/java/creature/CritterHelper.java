package creature;

import gene.DnaHelper;
import gene.SimpleDna;

public class CritterHelper {

    public static SimpleCritter createNewRandomCritter(int ID) {
        // use chunkLong chunks
        SimpleDna newSimpleDna = DnaHelper.createRandomSimpleDna();
        return createNewSimpleCritter(newSimpleDna, ID);
    }

    public static SimpleCritter createNewSimpleCritter(SimpleDna simpleDna, int ID) {
        SimpleCritter critter = new SimpleCritter(ID, simpleDna);
        return critter;
    }


}
