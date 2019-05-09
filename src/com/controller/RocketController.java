package com.controller;

import com.model.Rocket;

import java.util.ArrayList;
import java.util.List;

public class RocketController
{
    private Float rocket1Velocity = 0f;
    private Float rocket2Velocity = 0f;

    private List<Rocket> rockets = new ArrayList<>();

    public RocketController()
    {
        rockets.add(new Rocket("32WESSDS", 3, rocket1Velocity));
        rockets.add(new Rocket("LDSFJA32", 6, rocket2Velocity));

        this.updateRocket(1, 0);
        this.updateRocket(2, 0);
    }

    public void updateRocket(Integer rocketNumber, Integer rocketPower)
    {
        Thread t = new Thread(() ->
        {
            System.out.println("Updating rocket");
            rockets.get(rocketNumber).setPower(rocketPower);
        });
        t.start();
    }

    public List<String>  getRocketsCodes()
    {
        List<String> rocketsCodes = new ArrayList<>();

        Thread t = new Thread(() ->
        {
            System.out.println("Get rocket code");
            for (Rocket rocket:rockets)
            {
                rocketsCodes.add(rocket.getCode());
            }
        });
        t.start();

        return rocketsCodes;
    }

    public List<Integer>  getRocketsEngines()
    {
        List<Integer> rocketsEngines = new ArrayList<>();

        Thread t = new Thread(() ->
        {
            System.out.println("Get rocket engines");
            for (Rocket rocket:rockets)
            {
                rocketsEngines.add(rocket.getEngines());
            }
        });
        t.start();

        return rocketsEngines;
    }

    public List<Float> getRocketsVelocity()
    {
        List<Float> rocketsVelocity = new ArrayList<>();

        Thread t = new Thread(() ->
        {
            System.out.println("Get rocket velocity");
            for (Rocket rocket:rockets)
            {
                rocketsVelocity.add(rocket.getVelocity());
            }
        });
        t.start();

        return rocketsVelocity;
    }

}
