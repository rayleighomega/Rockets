package com.view;

import com.controller.RocketController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View
{
    private List<String> rocketsCodes = new ArrayList<>();
    private List<Integer> rocketsEngines = new ArrayList<>();
    private List<Double> rocketsVelocity = new ArrayList<>();
    private List<Integer> rocketsPower = new ArrayList<>();

    private RocketController rocketController;  //Should be declared as a field to share between threads

    Scanner scanner = new Scanner(System.in);

    public View()
    {
        System.out.println("View constructor began");

        rocketController = new RocketController();

        /*Initialization of the current status of the Rockets inside the view*/
        this.initRocketList();
        System.out.println("View constructor OK");
    }

    private void initRocketList()
    {
         /*Get the rockets data from the controller*/
        rocketsCodes = rocketController.getRocketsCodes();
        rocketsEngines = rocketController.getRocketsEngines();
        rocketsVelocity = rocketController.getRocketsVelocity();
        rocketsPower = rocketController.getRocketPower();
    }


    public void main()
    {
        //clearConsole();

        while(true)
        {
            System.out.println("--------------------------------");
            System.out.println("Estado Cohetes");
            System.out.println("--------------------------------");
            System.out.println(" ");

            System.out.println("Cohete 1 ||| Code: " + this.rocketsCodes.get(0) + "| Engines: " +
                    this.rocketsEngines.get(0).toString() + "| Current Power: " + this.rocketsPower.get(0) + "| Velocity: "
                    + this.rocketsVelocity.get(0).toString());

            System.out.println("Cohete 2 ||| Code: " + this.rocketsCodes.get(1) + "| Engines: " +
                    this.rocketsEngines.get(1).toString() + "| Current Power: " + this.rocketsPower.get(1) + "| Velocity: "
                    + this.rocketsVelocity.get(1).toString());

            System.out.println(" ");
            System.out.println("--------------------------------");
            System.out.println("Esperando acción del usuario: ");
            System.out.println("--------------------------------");
            System.out.println(" ");
            System.out.print("Introduce el número de cohete: ");
            String input = scanner.nextLine();
            Integer rocketNumber = Integer.parseInt(input);

            System.out.println("--------------------------------");
            System.out.println("Menú de acciones: ");
            System.out.println("--------------------------------");
            System.out.println("1. Acelerar");
            System.out.println("2. Frenar");
            System.out.print("Acción: ");
            String actionString = scanner.nextLine();

            String action = "";
            switch (actionString)
            {
                case "1" : action = "SpeedUp"; break;
                case "2" : action = "SpeedDown"; break;

            }

            rocketController.updateRocket(rocketNumber, action);
            rocketsVelocity = rocketController.getRocketsVelocity();
            rocketsPower = rocketController.getRocketPower();

        }


    }

    public final static void clearConsole()
    {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }

}
