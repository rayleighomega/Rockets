package com.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class UserController implements KeyListener, Runnable
{
    public UserController()
    {

    }

    public void waitKey()
    {
        this.run();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
    }


    @Override
    public void keyReleased(KeyEvent e)
    {
    }

    @Override
    public void run()
    {
        System.out.println("AA");
        try
        {
            Thread.sleep(10);
        }
        catch (Exception e)
        {

        }
        System.out.println("AA");

        this.run();
    }
}
