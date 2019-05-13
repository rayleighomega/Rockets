package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Rocket
{
    private String code = "";
    public Double velocity = 55d;

    private List<Engine> engines = new ArrayList<>();

    public Rocket(String pCode)
    {
        this.setCode(pCode);
    }

    public Rocket speedUp()
    {
        System.out.println("Updating rocket");

        List<Future<Boolean>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Boolean flagDone = true;

        for (Engine engine:engines)
        {
            //Update rocket in a new thread
            Callable<Boolean> t = () ->
            {
                engine.increasePower();

                return true;
            };
            futures.add(executorService.submit(t));
        }

        Integer counterDone = 0;
        while (flagDone) //Waits for all the threads
        {
            for (Future<Boolean> future : futures)
            {
                Boolean flagFuture = future.isDone();
                if (!flagFuture)
                {
                    flagDone = false;
                }
                else
                {
                    counterDone++;
                }

            }

            if (counterDone == futures.size())
            {
                flagDone = false;
            }
        }

        executorService.shutdown();

        Integer enginesPower = 0;
        for (Engine engine: engines)
        {
            enginesPower += engine.enginePower;
        }

        //Double enginesPowerF = (double)enginesPower;
        System.out.println(velocity);
        //this.setVelocity(this.velocity + 100 * Math.sqrt(enginesPowerF));

        System.out.println("Rocket updated");

        return this;
    }

    public Rocket speedDown() throws InterruptedException, ExecutionException
    {
        System.out.println("Updating rocket");

        List<Future<Boolean>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Boolean flagDone = false;

        for (Engine engine:engines)
        {
            //Update rocket in a new thread
            Callable<Boolean> t = () ->
            {
                engine.decreasePower();

                return true;
            };
            futures.add(executorService.submit(t));
        }

        while (flagDone) //Waits for all the threads
        {
            for (Future<Boolean> future : futures)
            {
                if (!future.isDone())
                    flagDone = true;
            }
        }

        Integer enginesPower = 0;
        for (Engine engine: engines)
        {
            enginesPower += engine.enginePower;
        }

        Double enginesPowerF = (double)enginesPower;
        this.setVelocity(this.velocity + 100 * Math.sqrt(enginesPowerF));

        System.out.println("Rocket updated");

        return this;
    }

    public void updateVelocity()
    {
        Integer enginesPower = 0;
        for (Engine engine: engines)
        {
            enginesPower += engine.enginePower;
        }

        Double enginesPowerF = (double)enginesPower;
        this.setVelocity(this.velocity + 100 * Math.sqrt(enginesPowerF));
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

    public class Engine
    {
        Integer engineMaxPower;
        Integer enginePower = 0;

        public Engine(Integer pEngineMaxPower)
        {
            engineMaxPower = pEngineMaxPower;
        }

        public Boolean increasePower()
        {
            if(engineMaxPower - enginePower > 0)
            {
                enginePower += 10; //Increase by 10
            }
            else
            {
                enginePower = engineMaxPower; //Engine reach the maximum power
            }

            return true;
        }

        public Boolean decreasePower()
        {

            if(enginePower - 10 > 0)
            {
                enginePower -= 10; //Decrease by 10
            }
            else
            {
                enginePower = 0; //Engine reach the minimum power
            }


            return true;
        }


    }

}



