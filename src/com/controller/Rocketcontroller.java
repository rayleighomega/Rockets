package com.controller;

import com.model.Rocket;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RocketController
{
    private Callable<Rocket> rocket1;
    private Callable<Rocket> rocket2;

    Thread rocket1Thread;
    Thread rocket2Thread;

    private Float rocket1Velocity = 0f;
    private Float rocket2Velocity = 0f;

    public RocketController()
    {
        this.connectRockets();
    }

    public void connectRockets()
    {
        if(rocket1Thread.isAlive())
        {
            rocket1Thread.interrupt();
        }
        else
        {
            //Create two rockets by default
            rocket1 = new Rocket("32WESSDS", 3, rocket1Velocity);
            ExecutorService exec = Executors.newFixedThreadPool(3);
            Future<Rocket> future = exec.submit(rocket1);
        }


        rocket2 = new Rocket("LDSFJA32", 6, rocket2Velocity);
        rocket2Thread = new Thread(rocket2);
        rocket2Thread.start();
        rocket2Thread.setName("Rocket2");
    }


}
