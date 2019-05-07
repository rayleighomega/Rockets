package com.controller;
import java.io.*;

public class UserController implements Runnable
{
    InputStreamReader reader = new InputStreamReader(System.in);

    public UserController()
    {

    }

    public void waitKey()
    {
        this.run();
    }


    @Override
    public void run()
    {

        //int key = System.in.read();
        //System.out.println((char)key);

        try
        {
            Thread.sleep(3000);
        }
        catch (Exception e)
        {

        }

        this.run(); //Endless loop
    }
}
