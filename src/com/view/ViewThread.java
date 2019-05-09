package com.view;

public class ViewThread implements Runnable
{

    public ViewThread()
    {

    }

    @Override
    public void run()
    {
        View view = new View();

        while(true)
        {
            view.draw();
        }

    }



}
