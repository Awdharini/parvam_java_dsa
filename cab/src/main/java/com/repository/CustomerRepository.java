package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking_system.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
