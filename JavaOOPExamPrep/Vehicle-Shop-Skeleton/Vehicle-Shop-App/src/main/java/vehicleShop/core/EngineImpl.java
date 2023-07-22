package vehicleShop.core;

import vehicleShop.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
      this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("Exit")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddWorker:
                //•	AddWorker {workerType} {workerName}
                result = addWorker(data);
                break;
            case AddVehicle:
                //•	AddVehicle {vehicleName} {strengthRequired}
                result = addVehicle(data);
                break;
            case AddToolToWorker:
                //•	AddToolToWorker {workerName} {power}
                result = addToolToWorker(data);
                break;
            case MakingVehicle:
                //•	MakingVehicle {vehicleName}
                result = makingVehicle(data);
                break;
            case Statistics:
                //•	Statistics
                result = statistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }

    private String addWorker(String[] data) {
      return this.controller.addWorker(data[0],data[1] );
    }

    private String addVehicle(String[] data) {

        return this.controller.addVehicle(data[0],Integer.parseInt(data[1]));
    }

    private String addToolToWorker(String[] data) {
        return controller.addToolToWorker(data[0],Integer.parseInt(data[1]));
    }

    private String statistics() {
   return controller.statistics();
    }

    private String makingVehicle(String[] data) {
        return controller.makingVehicle(data[0]);
    }
}
