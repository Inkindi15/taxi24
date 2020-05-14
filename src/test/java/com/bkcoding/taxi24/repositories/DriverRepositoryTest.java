package com.bkcoding.taxi24.repositories;

import com.bkcoding.taxi24.domain.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static com.bkcoding.taxi24.domain.Driver.EDriverStatus.AVAILABLE;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class DriverRepositoryTest {

  @Autowired private DriverRepository driverRepository;

  @Test
  void whenfindAllByStatus_returnListOfDrivers() {
    // given
    Driver raissa = new Driver();
    raissa.setStatus(AVAILABLE);
    raissa.setNames("raissa");
    driverRepository.save(raissa);

    // when
    final List<Driver> drivers = driverRepository.findAllByStatus(AVAILABLE);

    // assert that
    assertTrue(() -> !drivers.isEmpty(), "Drivers list is not empty");
  }

  @Test
  void existsByPermitCard() {
    // given
    Driver raissa = new Driver();
    raissa.setStatus(AVAILABLE);
    raissa.setNames("raissa");
    raissa.setPermitCard("RAB678R");
    driverRepository.save(raissa);

    // when
    final boolean doesExists = driverRepository.existsByPermitCard("RAB678R");

    // assert that
    assertTrue(doesExists, "Driver does exists");
  }
}
