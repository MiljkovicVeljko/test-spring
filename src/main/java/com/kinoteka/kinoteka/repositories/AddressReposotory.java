package com.kinoteka.kinoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kinoteka.kinoteka.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
  
}
