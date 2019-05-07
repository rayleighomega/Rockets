package com.view;

import com.model.Rocket;

public interface UserControllerListener
{
    abstract Character UserInput(Integer rocketPower, Integer rocketNumber);
    abstract Rocket GetRocket(Integer rocketNumber);
}
