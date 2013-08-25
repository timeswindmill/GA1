package gene;

import control.RunConfig;
import gene.chunk.ChunkMachine;
import utility.LiteLog;

import java.io.*;

public enum MachineDnaHelper implements DnaHelper<MachineDna> {

    INSTANCE;


    @Override
    public MachineDna createRandomDna(int dnaLength) {
        ChunkMachine[] newString = new ChunkMachine[dnaLength];
        for (int ii = 0; ii < newString.length; ii++) {
            ChunkMachine thisChunk = ChunkMachine.createRandom();
            newString[ii] = thisChunk;
        }
        MachineDna newDna = new MachineDna(newString);
        return newDna;


    }

    @Override
    public MachineDna createRandomDna() {
        return createRandomDna(RunConfig.INSTANCE.getDefaultDnaLength());
    }

    @Override
    public MachineDna createDnaFromString(int[] startString) {

        int[] temp = new int[startString.length];
        for (int ii = 0; ii < startString.length; ii++) {
            temp[ii] = (int) startString[ii];
        }
        ChunkMachine[] newChunks = ChunkMachine.createMultipleChunks(temp);
        MachineDna newDna = new MachineDna(newChunks);
        return newDna;

    }

    @Override
    public MachineDna createDnaFromCombined(MachineDna dna1, MachineDna dna2) {
        MachineDna newDna = new MachineDna(dna1.getChunks());
        newDna.combineChunks(dna1.getChunks(), dna2.getChunks());
        return newDna;

    }

    @Override
    public MachineDna[] readFromFile(String fileName) {

        FileInputStream fis = null;
        MachineDna[] newDnaArray = null;
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {

        }
        ObjectInputStream iis = null;
        try {
            iis = new ObjectInputStream(fis);
            newDnaArray = (MachineDna[]) iis.readObject();

        } catch (IOException e) {
            LiteLog.Log("Error : " + e);
        } catch (ClassNotFoundException e) {
            LiteLog.Log("Error : " + e);
        }

        return newDnaArray;


    }

    @Override
    public void writeToFile(MachineDna[] dna, String fileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dna);

        } catch (IOException e) {
            LiteLog.Log("Error : " + e);
        }


    }

}
