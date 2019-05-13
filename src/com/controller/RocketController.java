package com.controller;

import com.model.Rocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class RocketController
{
    private List<Rocket> rockets = new ArrayList<>();

    public RocketController()
    {
        //Initial values for two rockets
        Rocket rocket;
        rocket = new Rocket("32WESSDS");
        rocket.newEngine(10);
        rocket.newEngine(20);
        rocket.newEngine(30);
        this.rockets.add(rocket);
        rocket = new Rocket("LDSFJA32");
        rocket.newEngine(10);
        rocket.newEngine(20);
        rocket.newEngine(30);
        rocket.newEngine(40);
        rocket.newEngine(50);
        rocket.newEngine(60);
        this.rockets.add(rocket);

    }

    public void updateRocket(Integer rocketNumber, String action)
    {
        Rocket rocket = rockets.get(rocketNumber-1);
        Double velocity;

        try
        {
            switch (action)
            {
                case "SpeedUp" :
                    velocity = rocket.powerUp();
                    this.rockets.set(rocketNumber-1, rocket);
                    System.out.println(rocket.getEnginesPower());
                    break;
                case "SpeedDown" :
                    velocity = rocket.powerDown();
                    System.out.println(rocket.getEnginesPower());
                    this.rockets.set(rocketNumber-1, rocket);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }

    }

    public List<String> getRocketsCodes()
    {
        List<String> rocketsCodes = new ArrayList<>();

        System.out.println("Get rocket code");
        for (Rocket rocket:rockets)
        {
            rocketsCodes.add(rocket.getCode());
        }

        return rocketsCodes;

    }

    public List<Integer> getRocketsEngines()
    {
        List<Integer> rocketsEngines = new ArrayList<>();

        System.out.println("Get rocket engines");
        for (Rocket rocket:rockets)
        {
            rocketsEngines.add(rocket.getEngines());
        }

        return rocketsEngines;
    }

    public List<Double> getRocketsVelocity()
    {
        List<Double> rocketsVelocity = new ArrayList<>();

        System.out.println("Get rocket velocity");
        for (Rocket rocket:rockets)
        {
            rocketsVelocity.add(rocket.getVelocity());
        }

        return rocketsVelocity;
    }

    public List<Integer> getRocketPower()
    {
        List<Integer> rocketsPower = new ArrayList<>();

        System.out.println("Get rocket velocity");
        for (Rocket rocket:rockets)
        {
            rocketsPower.add(rocket.getEnginesPower());
        }

        return rocketsPower;
    }

}
