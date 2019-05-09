package com.model;

import java.util.concurrent.Callable;

public class Rocket implements Callable<Rocket>
{
    private String code = "";
    private Integer engines;
    private Float velocity = 0f;

    public Rocket(String code, Integer engines, Float velocity)
    {
        this.setCode(code);
        this.setEngines(engines);
        this.setVelocity(velocity);
    }

    @Override
    public Rocket call() throws Exception
    {
        try
        {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Flying");
                Thread.sleep(1000);
            }
            throw new InterruptedException();

        }
        catch (InterruptedException e) {
            return this;
        }
    }

    private void launch()
    {


    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public Integer getEngines()
    {
        return engines;
    }

    public void setEngines(Integer engines)
    {
        this.engines = engines;
    }

    public Float getVelocity()
    {
        return velocity;
    }

    public void setVelocity(Float velocity)
    {
        this.velocity = velocity;
    }

}



