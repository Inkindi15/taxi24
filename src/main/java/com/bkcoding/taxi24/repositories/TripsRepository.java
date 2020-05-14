package com.bkcoding.taxi24.repositories;

import com.bkcoding.taxi24.domain.Trips;
import com.bkcoding.taxi24.domain.Trips.ETripStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripsRepository extends JpaRepository<Trips, Integer> {
  List<Trips> findAllByStatus(ETripStatus status);
}
