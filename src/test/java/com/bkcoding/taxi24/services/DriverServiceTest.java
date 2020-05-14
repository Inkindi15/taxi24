package com.bkcoding.taxi24.services;

import com.bkcoding.taxi24.domain.Driver;
import com.bkcoding.taxi24.repositories.DriverRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static com.bkcoding.taxi24.domain.Driver.EDriverStatus.AVAILABLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class DriverServiceTest {

  Driver driver;
  @Autowired private DriverService driverService;
  @MockBean private DriverRepository driverRepository;

  @BeforeEach
  public void setUp() {
    // given
    driver = new Driver();
    driver.setId(1);
    driver.setStatus(AVAILABLE);
    driver.setNames("RAISSA");

    // when
    when(driverRepository.findAllByStatus(AVAILABLE)).thenReturn(Lists.newArrayList(driver));
    when(driverRepository.save(driver)).thenReturn(driver);
    when(driverRepository.findAll()).thenReturn(Lists.newArrayList(driver));
    when(driverRepository.findById(1)).thenReturn(Optional.of(driver));
  }

  @Test
  void createDriver() {

    assertEquals(
        driverService.createDriver(driver).getNames(),
        "RAISSA",
        "Created driver name equals 'RAISSA'");
  }

  @Test
  void allDrivers() {

    assertTrue(
        driverService.allDrivers().get(0).getNames().equals("RAISSA"),
        "One of the driver in the returned list has the name 'RAISSA'");
  }

  @Test
  void findById() {

    assertTrue(
        driverService.findById(1).getNames().equals("RAISSA"),
        "The returned Driver has the name 'RAISSA'");
  }

  @Test
  void availableDrivers() {

    assertTrue(
        driverService.findById(1).getNames().equals("RAISSA"),
        "One of the driver in the returned list has the name 'RAISSA'");
  }
}
