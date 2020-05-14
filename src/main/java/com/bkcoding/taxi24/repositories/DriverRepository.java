package com.bkcoding.taxi24.repositories;

import com.bkcoding.taxi24.domain.Driver;
import com.bkcoding.taxi24.domain.Driver.EDriverStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
  List<Driver> findAllByStatus(EDriverStatus status);

  boolean existsByPermitCard(String permitCard);
}
