package com.booking_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking_system.entity.Driver;
import com.repository.DriverRepository;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    // Add Driver
    public Driver addDriver(Driver driver){

        driver.setStatus("AVAILABLE");

        if(driver.getRating() == null){
            driver.setRating(4.0);
        }
         return driverRepository.save(driver);
    }

    // Get All Drivers
    public List<Driver> getAllDrivers(){

        return driverRepository.findAll();
    }

    // Get Available Drivers
    public List<Driver> getAvailableDrivers(){

        return driverRepository.findByStatus("AVAILABLE");
    }

    // Update Driver Status
    public void updateDriverStatus(Long id, String status){

        Driver driver =
                driverRepository.findById(id).orElse(null);

        if(driver != null){
             driver.setStatus(status);

            driverRepository.save(driver);
        }
    }

    // Update Driver Rating
    public void updateDriverRating(Long id, Double rating){

        Driver driver =
                driverRepository.findById(id).orElse(null);

        if(driver != null){

            driver.setRating(rating);

            driverRepository.save(driver);
        }
    }

    // Delete Driver
    public void deleteDriver(Long id){

        driverRepository.deleteById(id);
    }
}
