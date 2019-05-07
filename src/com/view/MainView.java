package com.view;

public class MainView
{
    //User side

    public MainView()
    {

        /*Render's side, endless loop for print the rockets status*/
        Runnable renderThread = new RenderThread();

        /*Start the threads*/
        new Thread(renderThread).start();

    }




}
