package com.model;

public class Rocket
{
    private String code = "";
    private Integer engines;
    private Float velocity = 0f;
    private Integer power = 0;

    public Rocket(String code, Integer engines, Float velocity)
    {
        this.setCode(code);
        this.setEngines(engines);
        this.setVelocity(velocity);
    }

    public void setPower(Integer power)
    {
        this.power = power;
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



