package com.view;

import com.rockets.Rocket;

import java.util.Timer;
import java.util.TimerTask;

public class MainView
{
    //Create two rockets inside the view
    Rocket r1 = new Rocket("32WESSDS", 3);
    Rocket r2 = new Rocket("LDSFJA32", 6);

    public MainView()
    {
        //Create the instance and implementation of the run method
        TimerTask timerTask = new TimerTask()
        {
            //Should be outside of the run loop
            MainRender render = new MainRender();

            @Override
            public void run()
            {
                render.draw();
            }
        };

        //Create the timer to use with the TimerTask
        try
        {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(timerTask, 1000, 3*1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }


}
