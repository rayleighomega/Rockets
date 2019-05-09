package com.view;

public class MainView
{
    //User side

    public MainView()
    {

        /*View's side, endless loop for print the rockets status*/
        Runnable renderThread = new ViewThread();

        /*Start the threads*/
        new Thread(renderThread).start();

    }




}
