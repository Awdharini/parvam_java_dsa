package com.booking_system.ai;

import org.springframework.stereotype.Service;

@Service
public class FarePredictionService {

    public double predictFare(double distance){

        double rate = 15;

        return distance * rate;
    }
}