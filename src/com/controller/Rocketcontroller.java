package com.controller;

import com.model.Rocket;
import com.view.UserControllerListener;

import java.util.ArrayList;
import java.util.List;

public class RocketController implements UserControllerListener
{
    private List<String> rocketsCodes = new ArrayList<>();
    private List<Integer> rocketsEngines = new ArrayList<>();
    private List<Float> rocketsVelocity = new ArrayList<>();

    private List<Rocket> rockets = new ArrayList<>();

    public void RocketController()
    {
        //Create two rockets by default
        rockets.add(createRocket("32WESSDS", 3));
        rockets.add(createRocket("LDSFJA32", 6));

        //Rocket status
        rocketsCodes.add(rockets.get(0).getCode());
        rocketsCodes.add(rockets.get(1).getCode());

        rocketsEngines.add(rockets.get(0).getEngines());
        rocketsEngines.add(rockets.get(1).getEngines());

        rocketsVelocity.add(rockets.get(0).getVelocity());
        rocketsVelocity.add(rockets.get(1).getVelocity());
    }

    public Rocket createRocket(String code, Integer engines)
    {
        return new Rocket(code, engines);
    }


    public List<String> getRocketsCodes()
    {
        return rocketsCodes;
    }

    public List<Integer> getRocketsEngines()
    {
        return rocketsEngines;
    }

    public List<Float> getRocketsVelocity()
    {
        return rocketsVelocity;
    }

    @Override
    public Character UserInput(Integer rocketPower, Integer rocketNumber)
    {
        Rocket rocket = rockets.get(rocketNumber);
        rockets.set(rocketNumber, rocket);
        return null;
    }

    @Override
    public Rocket GetRocket(Integer rocketNumber)
    {
        return rockets.get(rocketNumber);
    }
}
