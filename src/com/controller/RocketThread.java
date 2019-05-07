package com.controller;

import com.view.UserControllerListener;

public class RocketThread implements Runnable
{
    public RocketThread()
    {

    }

    public void run()
    {
        RocketController rocketController = new RocketController();

        while(true)
        {
            try
            {
                Thread.sleep(3000);
            }
            catch (Exception e)
            {

            }
        }

    }


}
