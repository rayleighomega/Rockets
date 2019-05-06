package com.view;

import java.util.List;

public class MainRender
{
    private List<String> rocketsCodes;
    private List<String> rocketsEngines;
    private List<String> rocketsVelocity;

    public void draw()
    {

        clearConsole();

        System.out.println("--------------------------------");
        System.out.println("Estado Cohetes");
        System.out.println("--------------------------------");
        System.out.println(" ");
        System.out.println("Cohete 1: " + this.getRocketsCodes().get(0) + "  " + this.getRocketsEngines().get(0) + " " + this.getRocketsVelocity().get(0));
        System.out.println("Cohete 1: " + this.getRocketsCodes().get(1) + "  " + this.getRocketsEngines().get(1) + " " + this.getRocketsVelocity().get(1));
    }

    public final static void clearConsole()
    {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }

    public List<String> getRocketsCodes()
    {
        return rocketsCodes;
    }

    public void setRocketsCodes(List<String> rocketsCodes)
    {
        this.rocketsCodes = rocketsCodes;
    }

    public List<String> getRocketsEngines()
    {
        return rocketsEngines;
    }

    public void setRocketsEngines(List<String> rocketsEngines)
    {
        this.rocketsEngines = rocketsEngines;
    }

    public List<String> getRocketsVelocity()
    {
        return rocketsVelocity;
    }

    public void setRocketsVelocity(List<String> rocketsVelocity)
    {
        this.rocketsVelocity = rocketsVelocity;
    }
}
