package gene;


public interface DnaHelper<T> {

    public T createRandomDna(int dnaLength);

    public T createRandomDna();

    public T createDnaFromLongString(long[] startString);

    public T createDnaFromCombined(T dna1, T dna2);

    // TODO pass in File object
    public T[] readFromFile(String fileName);

    public void writeToFile(T[] dna, String fileName);

//    public static SimpleDna createRandomSimpleDna(int dnaLength) {
//        ChunkLong[] newString = new ChunkLong[dnaLength];
//        for (int ii = 0; ii < newString.length; ii++) {
//            ChunkLong thisChunk = new ChunkLong();
//            thisChunk.randomizeBits();
//            newString[ii] = thisChunk;
//        }
//        SimpleDna newDna = new SimpleDna(newString);
//        return newDna;
//
//    }
//
//    public static SimpleDna createRandomSimpleDna() {
//        return createRandomSimpleDna(RunConfig.INSTANCE.getDefaultDnaLength());
//    }
//
//    public static SimpleDna createSimpleDnaFromLongString(long[] startString) {
//        ChunkLong[] newString = new ChunkLong[startString.length];
//        for (int ii = 0; ii < newString.length; ii++) {
//            ChunkLong thisChunk = new ChunkLong(startString[ii]);
//            newString[ii] = thisChunk;
//        }
//        SimpleDna newDna = new SimpleDna(newString);
//        return newDna;
//    }
//
//    public static SimpleDna createSimpleDnaFromCombined(SimpleDna dna1, SimpleDna dna2) {
//        SimpleDna newDna = new SimpleDna(dna1.getChunks());
//        newDna.combineChunks(dna1.getChunks(), dna2.getChunks());
//        return newDna;
//    }
//
//
//    // TODO pass in File object
//    public static Dna[] readFromFile(String fileName) {
//
//        FileInputStream fis = null;
//        Dna[] newDnaArray = null;
//        try {
//            fis = new FileInputStream(fileName);
//        } catch (FileNotFoundException e) {
//
//        }
//        ObjectInputStream iis = null;
//        try {
//            iis = new ObjectInputStream(fis);
//            newDnaArray = (Dna[]) iis.readObject();
//
//        } catch (IOException e) {
//            LiteLog.Log("Error : " + e);
//        } catch (ClassNotFoundException e) {
//            LiteLog.Log("Error : " + e);
//        }
//
//        return newDnaArray;
//    }
//
//    public static void writeToFile(Dna[] dna, String fileName) {
//
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(fileName);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(dna);
//
//        } catch (IOException e) {
//            LiteLog.Log("Error : " + e);
//        }
//
//
//    }
//


}
