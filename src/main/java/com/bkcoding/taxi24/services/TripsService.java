package com.bkcoding.taxi24.services;

import com.bkcoding.taxi24.domain.Invoice;
import com.bkcoding.taxi24.domain.Trips;

import java.util.List;

public interface TripsService {
  Trips createTrip(Trips trips);

  List<Trips> getAllActiveTrips();

  Trips findOne(int id);

  Invoice completeTrip(int tripId);

  Trips createTrip(int rider_id, int driver_id, double latitude, double longitude);
}
