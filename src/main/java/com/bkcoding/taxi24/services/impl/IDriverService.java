package com.bkcoding.taxi24.services.impl;

import com.bkcoding.taxi24.domain.Driver;
import com.bkcoding.taxi24.exceptions.NotFoundException;
import com.bkcoding.taxi24.exceptions.UniqueConstraintException;
import com.bkcoding.taxi24.repositories.DriverRepository;
import com.bkcoding.taxi24.services.DriverService;
import com.bkcoding.taxi24.services.LocationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.bkcoding.taxi24.domain.Driver.EDriverStatus.AVAILABLE;

@Service
public class IDriverService implements DriverService {
  @Autowired private LocationUtil locationUtil;
  @Autowired private DriverRepository driverRepository;

  @Override
  public Driver createDriver(Driver driver) {
    if (driverRepository.existsByPermitCard(driver.getPermitCard())) {
      throw new UniqueConstraintException(
          "Permit card of ::" + driver.getPermitCard() + ":: already exists");
    }
    return driverRepository.save(driver);
  }

  @Override
  public List<Driver> allDrivers() {
    return driverRepository.findAll();
  }

  @Override
  public Driver findById(int id) {
    return driverRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Driver not found"));
  }

  @Override
  public List<Driver> availableDrivers() {
    return driverRepository.findAllByStatus(AVAILABLE);
  }

  @Override
  public List<Driver> availableDrivers(int distance, double longitude, double latitude) {

    return driverRepository.findAllByStatus(AVAILABLE).stream()
        .filter(
            driver ->
                locationUtil.getDistanceFromLatLonInKm(
                        latitude, longitude, driver.getLatitude(), driver.getLongitude())
                    <= distance)
        .collect(Collectors.toList());
  }
}
