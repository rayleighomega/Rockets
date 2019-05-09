package com.view;

import com.controller.RocketController;
import com.controller.UserController;
import com.model.Rocket;

import java.util.ArrayList;
import java.util.List;

public class View
{
    private List<String> rocketsCodes = new ArrayList<>();
    private List<Integer> rocketsEngines = new ArrayList<>();
    private List<Float> rocketsVelocity = new ArrayList<>();

    private UserController userController;  //Should be declared as a field to share between threads
    private RocketController rocketController;  //Should be declared as a field to share between threads

    private List<Rocket> rockets = new ArrayList<>();   //Should be declared as a field to share between threads
    private List<Object> rocketsData = new ArrayList<>();

    public View()
    {
        System.out.println("View constructor began");

        rocketController = new RocketController();

/*        *//*User controller, wait the input key from the user in a new thread*//*
        new Thread(new Runnable() {
            @Override
            public void run()
            {
                userController = new UserController();
            }
        }).start();

        *//*Rocket controller, wait the actions in a new thread*//*
        new Thread(new Runnable() {
            @Override
            public void run()
            {
                rocketController = new RocketController();
            }
        }).start();*/

        /*Initialization of the current status of the Rockets inside the view*/
        this.initRocketList();
        System.out.println("View constructor OK");
    }


    public void draw()
    {
        clearConsole();

        System.out.println("--------------------------------");
        System.out.println("Estado Cohetes");
        System.out.println("--------------------------------");
        System.out.println(" ");

        System.out.println("Cohete 1: " + this.rocketsCodes.get(0) + "  " +
                this.rocketsEngines.get(0) + " " + this.rocketsVelocity.get(0));

        System.out.println("Cohete 2: " + this.rocketsCodes.get(1) + "  " +
                this.rocketsEngines.get(1) + " " + this.rocketsVelocity.get(1));
    }

    public final static void clearConsole()
    {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }


    private void initRocketList()
    {
        try
        {
            /*Get the rockets data from the controller*/
            rocketsCodes = rocketController.getRocketsCodes();
            rocketsEngines = rocketController.getRocketsEngines();
            rocketsVelocity = rocketController.getRocketsVelocity();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }
}
