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

        System.out.println("Cohete 1: " + this.rocketsCodes.get(0) + "  " +
                this.rocketsEngines.get(0) + " " + this.rocketsVelocity.get(0));

        System.out.println("Cohete 2: " + this.rocketsCodes.get(1) + "  " +
                this.rocketsEngines.get(1) + " " + this.rocketsVelocity.get(1));
    }

    public final static void clearConsole()
    {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }

}
