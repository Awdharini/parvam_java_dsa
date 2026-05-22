package com.booking_system.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking_system.entity.Driver;
import com.booking_system.entity.Ride;
import com.repository.DriverRepository;
import com.repository.RideRepository;

@Service
public class AnalyticsService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private DriverRepository driverRepository;

    // Total Revenue
    public double getTotalRevenue(){
       List<Ride> rides = rideRepository.findAll();

        double total = 0;

        for(Ride ride : rides){

            if(ride.getFare() != null){

                total += ride.getFare();
            }
        }

        return total;
    }

    // Total Completed Rides
    public long getCompletedRides(){

        List<Ride> rides = rideRepository.findAll();

        return rides.stream()
                .filter(r -> "COMPLETED".equals(r.getStatus()))
                .count();
    }
 // Total Active Drivers
    public long getAvailableDrivers(){

        List<Driver> drivers = driverRepository.findAll();

        return drivers.stream()
                .filter(d -> "AVAILABLE".equals(d.getStatus()))
                .count();
    }

    // Total Busy Drivers
    public long getBusyDrivers(){

        List<Driver> drivers = driverRepository.findAll();

        return drivers.stream()
                .filter(d -> "BUSY".equals(d.getStatus()))
                .count();
    }
      // Ride Status Analytics
    public Map<String, Long> rideStatusAnalytics(){

        List<Ride> rides = rideRepository.findAll();

        Map<String, Long> analytics = new HashMap<>();

        analytics.put(
                "BOOKED",
                rides.stream()
                        .filter(r -> "BOOKED".equals(r.getStatus()))
                        .count()
        );

        analytics.put(
                "STARTED",
                rides.stream()
                        .filter(r -> "STARTED".equals(r.getStatus()))
                        .count()
        );
analytics.put(
                "COMPLETED",
                rides.stream()
                        .filter(r -> "COMPLETED".equals(r.getStatus()))
                        .count()
        );

        return analytics;
    }

    // Peak Ride Analysis
    public String peakHourAnalysis(){

        List<Ride> rides = rideRepository.findAll();

        if(rides.size() > 10){

            return "High Traffic Booking Hours Detected";
        }

        return "Normal Ride Traffic";
    }
  // AI Driver Performance
    public Driver getTopDriver(){

        List<Driver> drivers = driverRepository.findAll();

        return drivers.stream()
                .filter(d -> d.getRating() != null)
                .max(Comparator.comparing(Driver::getRating))
                .orElse(null);
    }
}
