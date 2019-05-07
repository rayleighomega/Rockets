package com.view;

import com.controller.RocketThread;
import com.controller.UserController;

import java.util.List;

public class Render
{
    private List<String> rocketsCodes;
    private List<String> rocketsEngines;
    private List<String> rocketsVelocity;

    Runnable rocketThread = new RocketThread();

    public Render()
    {
        /*User controller, wait the input key from the user*/
        Runnable userController = new UserController();
        new Thread(userController).start();

        this.createRockets();
    }

    public void createRockets()
    {
        /*Rocket controller, wait for user actions*/
        Runnable rocketThread= new RocketThread();
        new Thread(rocketThread).start();
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

    public void setRocketsCodes(List<String> rocketsCodes)
    {
        this.rocketsCodes = rocketsCodes;
    }

    public void setRocketsEngines(List<String> rocketsEngines)
    {
        this.rocketsEngines = rocketsEngines;
    }

    public void setRocketsVelocity(List<String> rocketsVelocity)
    {
        this.rocketsVelocity = rocketsVelocity;
    }

}
