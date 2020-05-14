package com.bkcoding.taxi24.repositories;

import com.bkcoding.taxi24.domain.Trips;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static com.bkcoding.taxi24.domain.Trips.ETripStatus.ACTIVE;
import static com.bkcoding.taxi24.domain.Trips.ETripStatus.COMPLETED;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TripsRepositoryTest {
  @Autowired private TripsRepository tripsRepository;

  @Test
  void findAllByStatus() {
    // given
    Trips trip = new Trips();
    trip.setStatus(ACTIVE);
    tripsRepository.save(trip);

    // when
    final List<Trips> trips = tripsRepository.findAllByStatus(COMPLETED);

    // assert that
    assertTrue(trips.isEmpty(),"They are no completed trips");
  }
}
