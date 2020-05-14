package com.bkcoding.taxi24.services;

import com.bkcoding.taxi24.domain.Driver;

import java.util.List;

public interface DriverService {
  Driver createDriver(Driver driver);

  List<Driver> allDrivers();

  Driver findById(int id);

  List<Driver> availableDrivers();

  List<Driver> availableDrivers(int distance, double longitude, double latitude);
}
