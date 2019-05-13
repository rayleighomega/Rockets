package com.controller;

import com.model.Rocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class RocketController
{
    //Initial values
    private Float rocket1Velocity = 0f;
    private Float rocket2Velocity = 0f;

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

        try
        {
            switch (action)
            {
                case "SpeedUp" :
                    rocket = rocket.speedUp();
                    rocket.updateVelocity();
                    System.out.println(rocket.velocity);
                    this.rockets.set(rocketNumber-1, rocket);
                    break;
                case "SpeedDown" :
                    rocket = rocket.speedDown();
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

}
