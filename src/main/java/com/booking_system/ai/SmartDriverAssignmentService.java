package com.booking_system.ai;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.booking_system.entity.Driver;

@Service
public class SmartDriverAssignmentService {

    public Driver assignBestDriver(List<Driver> drivers){

        return drivers.stream()
                .max(Comparator.comparing(Driver::getRating))
                .orElse(null);
    }
}