package gene;

import control.RunConfig;
import gene.chunk.ChunkSimple;
import utility.LiteLog;

import java.io.*;

public enum SimpleDnaHelper implements DnaHelper<SimpleDna> {

    INSTANCE;

    @Override
    public SimpleDna createRandomDna(int dnaLength) {
        ChunkSimple[] newString = new ChunkSimple[dnaLength];
        for (int ii = 0; ii < newString.length; ii++) {
            ChunkSimple thisChunk = ChunkSimple.createRandom();
            newString[ii] = thisChunk;
        }
        SimpleDna newDna = new SimpleDna(newString);
        return newDna;

    }

    @Override
    public SimpleDna createRandomDna() {
        return createRandomDna(RunConfig.INSTANCE.getDefaultDnaLength());
    }

    @Override
    public SimpleDna createDnaFromString(int[] startString) {
        ChunkSimple[] newString = new ChunkSimple[startString.length];
        for (int ii = 0; ii < newString.length; ii++) {
            ChunkSimple thisChunk = new ChunkSimple(startString[ii]);
            newString[ii] = thisChunk;
        }
        SimpleDna newDna = new SimpleDna(newString);
        return newDna;

    }

    @Override
    public SimpleDna createDnaFromCombined(SimpleDna dna1, SimpleDna dna2) {
        SimpleDna newDna = new SimpleDna(dna1.getChunks());
        newDna.combineChunks(dna1.getChunks(), dna2.getChunks());
        return newDna;

    }

    @Override
    public SimpleDna[] readFromFile(String fileName) {
        FileInputStream fis = null;
        SimpleDna[] newDnaArray = null;
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {

        }
        ObjectInputStream iis = null;
        try {
            iis = new ObjectInputStream(fis);
            newDnaArray = (SimpleDna[]) iis.readObject();

        } catch (IOException e) {
            LiteLog.Log("Error : " + e);
        } catch (ClassNotFoundException e) {
            LiteLog.Log("Error : " + e);
        }

        return newDnaArray;

    }

    @Override
    public void writeToFile(SimpleDna[] dna, String fileName) {

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dna);

        } catch (IOException e) {
            LiteLog.Log("Error : " + e);
        }


    }


    //    public static SimpleDna createRandomSimpleDna(int dnaLength) {
//        ChunkSimple[] newString = new ChunkSimple[dnaLength];
//        for (int ii = 0; ii < newString.length; ii++) {
//            ChunkSimple thisChunk = new ChunkSimple();
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
//        ChunkSimple[] newString = new ChunkSimple[startString.length];
//        for (int ii = 0; ii < newString.length; ii++) {
//            ChunkSimple thisChunk = new ChunkSimple(startString[ii]);
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

}
