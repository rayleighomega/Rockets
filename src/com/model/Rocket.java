package com.model;

public class Rocket
{
    private String code = "";
    private Integer engines;
    private Double velocity = 0d;

    public Rocket(String code, Integer engines)
    {
        this.setCode(code);
        this.setEngines(engines);
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

    public Double getVelocity()
    {
        return velocity;
    }

    public void setVelocity(Double velocity)
    {
        this.velocity = velocity;
    }
}
