package com.view;

public class RenderThread implements Runnable
{

    public RenderThread()
    {

    }

    @Override
    public void run()
    {
        Render render = new Render();

        while(true)
        {
            render.draw();
        }

    }



}
