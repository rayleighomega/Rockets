package com.view;

import com.controller.UserController;
import com.model.Rocket;

import java.util.Timer;
import java.util.TimerTask;

public class MainView
{
    //User side

    //Create two rockets inside the view
    Rocket r1 = new Rocket("32WESSDS", 3);
    Rocket r2 = new Rocket("LDSFJA32", 6);

    public MainView()
    {
        /*The view needs a periodic call to the render method
        that prints in the rocket's status in the console*/

        //Create the instance and implementation of the run method
        TimerTask timerTask = new TimerTask()
        {
            //Should be outside of the run loop
            MainRender render = new MainRender();

            @Override
            public void run()
            {
                //render.draw(); //Print function
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

        /*Controller's side, wait the input key from the user*/
        Runnable userController = new UserController();

        new Thread(userController).start();

        try
        {
            userController.wait();
        }
        catch (Exception e)
        {

        }


    }


}
