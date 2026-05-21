package com.booking_system.ai;

import org.springframework.stereotype.Service;

@Service
public class FraudDetectionService {

    public boolean detectFraud(double distance){

        return distance > 200;
    }
}
