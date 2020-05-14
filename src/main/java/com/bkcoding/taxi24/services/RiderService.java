package com.bkcoding.taxi24.services;

import com.bkcoding.taxi24.domain.Driver;
import com.bkcoding.taxi24.domain.Rider;

import java.util.List;

public interface RiderService {
  Rider createRider(Rider rider);

  List<Rider> allRivers();

  Rider findById(int id);

  List<Driver> searcharound(int riderId);
}
