package com.booking_system.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking_system.ai.FarePredictionService;
import com.booking_system.ai.SmartDriverAssignmentService;
import com.booking_system.entity.Driver;
import com.booking_system.entity.Ride;
import com.repository.DriverRepository;

@Service
public class RideService {

    @Autowired
    private com.repository.RideRepository rideRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private FarePredictionService farePredictionService;

    @Autowired
    private SmartDriverAssignmentService smartDriverAssignmentService;

      public Ride bookRide(Ride ride){

        ride.setBookedAt(LocalDateTime.now());

        ride.setStatus("BOOKED");

        List<Driver> availableDrivers =
                driverRepository.findByStatus("AVAILABLE");

        Driver bestDriver =
                smartDriverAssignmentService.assignBestDriver(availableDrivers);

        if(bestDriver != null){

            ride.setDriverId(bestDriver.getId());

            bestDriver.setStatus("BUSY");

            driverRepository.save(bestDriver);

            ride.setStatus("DRIVER_ASSIGNED");
        }

        if (ride.getDistance() != null) {
            ride.setFare(farePredictionService.predictFare(ride.getDistance()));
        }

        return rideRepository.save(ride);
    }

    public List<Ride> getAllRides(){

        return rideRepository.findAll();
    }

    public void startRide(Long id){

        Ride ride = rideRepository.findById(id).orElse(null);

        if(ride != null){

            ride.setStatus("STARTED");

            rideRepository.save(ride);
        }
    }
      public void endRide(Long id){

        Ride ride = rideRepository.findById(id).orElse(null);

        if(ride != null){

            ride.setStatus("COMPLETED");

            rideRepository.save(ride);
        }
    }
}