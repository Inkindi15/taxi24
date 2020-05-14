package com.bkcoding.taxi24.services.impl;

import com.bkcoding.taxi24.domain.Driver;
import com.bkcoding.taxi24.domain.Rider;
import com.bkcoding.taxi24.exceptions.NotFoundException;
import com.bkcoding.taxi24.repositories.DriverRepository;
import com.bkcoding.taxi24.repositories.RiderRepository;
import com.bkcoding.taxi24.services.LocationUtil;
import com.bkcoding.taxi24.services.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IRiderService implements RiderService {
  @Autowired private RiderRepository riderRepository;
  @Autowired private DriverRepository driverRepository;
  @Autowired private LocationUtil locationUtil;

  @Override
  public Rider createRider(Rider rider) {
    return riderRepository.save(rider);
  }

  @Override
  public List<Rider> allRivers() {
    return riderRepository.findAll();
  }

  @Override
  public Rider findById(int id) {
    return riderRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Rider not found!!!"));
  }

  @Override
  public List<Driver> searcharound(int riderId) {

    final Rider rider = findById(riderId);

    return driverRepository.findAll().stream()
        .filter(
            driver ->
                locationUtil.getDistanceFromLatLonInKm(
                        driver.getLatitude(),
                        driver.getLongitude(),
                        rider.getLatitude(),
                        rider.getLongitude())
                    <= 3)
        .limit(3)
        .collect(Collectors.toList());
  }
}
