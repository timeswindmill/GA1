package control;

import world.MachineWorld;
import world.PolyWorld;
import world.SumEvaluatorWorld;
import world.World;

public class WorldControl {

    private RunConfig config;
    private WorldTypes worldType;

    public static void main(String args[]) {
        if (args.length < 1) {
            System.out.println("No world type specified");
            System.exit(-1);
        }
        if (args.length < 2) {
            System.out.println("No config file specified");
            System.exit(-1);
        }
        String configFileName = args[1];
        WorldControl main = new WorldControl();
        main.worldType = WorldTypes.valueOf(args[0]);

        // setup config file
        main.config = RunConfig.INSTANCE;

        //TODO read file
        //main.config.readConfigFile(configFileName);

        //start the run
        main.startRun();

    }


    private void startRun() {

        World newWorld;

        switch (worldType) {

            case SUM:
                newWorld = SumEvaluatorWorld.buildSumEvaluatorWorld();
                break;
            case MACHINE:
                newWorld = MachineWorld.buildMachineWorld();
                break;
            case POLY:
                newWorld = PolyWorld.buildPolyWorld();
                break;

        }

    }


}
