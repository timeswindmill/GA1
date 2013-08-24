package control;

import java.util.Properties;

public enum RunConfig {

    INSTANCE;

    private int defaultDnaLength = 10;
    private int startingSize = 1000;
    private int tournamentPercent = 20;
    private int mutatePercent = 5;
    private int maxDnaBit = 99;
    private int minInstructions = 1;


    private RunConfig() {
    }

    //TODO add in props file
    public void readConfigFile(Properties config) {

        String sLength = config.getProperty("DNA_LENGTH");
        if (sLength != null) {
            defaultDnaLength = Integer.parseInt(sLength);
        }

        String sSize = config.getProperty("STARTING_SIZE");
        if (sSize != null) {
            startingSize = Integer.parseInt(sSize);
        }

        String sTournament = config.getProperty("TOURNAMENT_PERCENT");
        if (sTournament != null) {
            tournamentPercent = Integer.parseInt(sTournament);
        }

        String sMutate = config.getProperty("MUTATE_PERCENT");
        if (sMutate != null) {
            mutatePercent = Integer.parseInt(sMutate);
        }

        String sMax = config.getProperty("MAX_BIT");
        if (sMax != null) {
            maxDnaBit = Integer.parseInt(sMax);
        }

        String sMin = config.getProperty("MIN_INSTRUCTIONS");
        if (sMin != null) {
            minInstructions = Integer.parseInt(sMin);
        }


    }


    public int getDefaultDnaLength() {
        return defaultDnaLength;
    }

    public int getStartingSize() {
        return startingSize;
    }

    public int getTournamentPercent() {
        return tournamentPercent;
    }

    public int getMutatePercent() {
        return mutatePercent;
    }

    public int getMaxDnaBit() {
        return maxDnaBit;
    }

    public int getMinInstructions() {
        return minInstructions;
    }


}
