package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking_system.entity.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
}
