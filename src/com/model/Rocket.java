package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Rocket
{
    private String code = "";
    private Double velocity = 0d;
    private Integer enginesPower = 0;

    private List<Engine> engines = new ArrayList<>();

    public Rocket(String pCode)
    {
        this.setCode(pCode);
    }

    public Double powerUp() throws Exception
    {
        Integer enginesPower = 0;

        System.out.println("Updating rocket");

        List<Future<Integer>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (Engine engine:engines)
        {
            //Update each rocket in a new thread. Could have different response time for power updating
            Callable<Integer> t = engine::increasePower;
            futures.add(executorService.submit(t));
        }

        for (Future<Integer> future : futures)
        {
            enginesPower += future.get(); //The exception is thrown by the method
        }

        executorService.shutdown();

        Double enginesPowerF = (double)enginesPower;
        System.out.println(velocity);
        this.setVelocity(this.velocity + 100 * Math.sqrt(enginesPowerF));

        System.out.println("Rocket updated");

        this.setEnginesPower(enginesPower);
        return this.velocity;
    }

    public Double powerDown() throws InterruptedException, ExecutionException
    {
        Integer enginesPower = 0;

        System.out.println("Updating rocket");

        List<Future<Integer>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (Engine engine:engines)
        {
            //Update each rocket in a new thread. Could have different response time for power updating
            Callable<Integer> t = engine::decreasePower;
            futures.add(executorService.submit(t));
        }

        for (Future<Integer> future : futures) //Using future.get the run can wait the results from the callable
        {
            enginesPower += future.get(); //The exception is thrown by the method
        }

        executorService.shutdown();

        Double enginesPowerF = (double)enginesPower;
        System.out.println(velocity);
        this.setVelocity(this.velocity + 100 * Math.sqrt(enginesPowerF));

        System.out.println("Rocket updated");
        this.setEnginesPower(enginesPower);
        return this.velocity;
    }

    public void newEngine(Integer engineMaxPower)
    {
        engines.add(new Engine(engineMaxPower));
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
        return engines.size();
    }

    public Double getVelocity()
    {
        return this.velocity;
    }

    public void setVelocity(Double pVelocity)
    {
        this.velocity = pVelocity;
    }

    public Integer getEnginesPower()
    {
        return enginesPower;
    }

    public void setEnginesPower(Integer enginesPower)
    {
        this.enginesPower = enginesPower;
    }

    public class Engine
    {
        Integer engineMaxPower;
        Integer enginePower = 0;

        public Engine(Integer pEngineMaxPower)
        {
            engineMaxPower = pEngineMaxPower;
        }

        public Integer increasePower() throws Exception
        {
            if(engineMaxPower - enginePower > 0)
            {
                enginePower += 10; //Increase by 10
            }
            else
            {
                enginePower = engineMaxPower; //Engine reach the maximum power
            }

            Thread.sleep((int)(Math.random()*1000));
            return enginePower;
        }

        public Integer decreasePower() throws Exception
        {

            if(enginePower - 10 > 0)
            {
                enginePower -= 10; //Decrease by 10
            }
            else
            {
                enginePower = 0; //Engine reach the minimum power
            }

            Thread.sleep((int)(Math.random()*1000));
            return enginePower;
        }


    }

}



