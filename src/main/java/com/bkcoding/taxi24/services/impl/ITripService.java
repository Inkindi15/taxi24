package com.bkcoding.taxi24.services.impl;

import com.bkcoding.taxi24.domain.Driver;
import com.bkcoding.taxi24.domain.Invoice;
import com.bkcoding.taxi24.domain.Rider;
import com.bkcoding.taxi24.domain.Trips;
import com.bkcoding.taxi24.exceptions.NotFoundException;
import com.bkcoding.taxi24.repositories.DriverRepository;
import com.bkcoding.taxi24.repositories.TripsRepository;
import com.bkcoding.taxi24.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.bkcoding.taxi24.domain.Driver.EDriverStatus.AVAILABLE;
import static com.bkcoding.taxi24.domain.Driver.EDriverStatus.ONTRIP;
import static com.bkcoding.taxi24.domain.Trips.ETripStatus.ACTIVE;
import static com.bkcoding.taxi24.domain.Trips.ETripStatus.COMPLETED;

@Service
public class ITripService implements TripsService {
  @Autowired InvoiceService invoiceService;
  @Autowired private TripsRepository tripsRepository;
  @Autowired private LocationUtil locationUtil;
  @Autowired private RiderService riderService;
  @Autowired private DriverService driverService;
  @Autowired private DriverRepository driverRepository;

  @Override
  public Trips createTrip(Trips trips) {
    return tripsRepository.save(trips);
  }

  @Override
  public List<Trips> getAllActiveTrips() {
    return tripsRepository.findAllByStatus(ACTIVE);
  }

  @Override
  public Trips findOne(int id) {
    return tripsRepository.findById(id).orElseThrow(() -> new NotFoundException("Trip not found"));
  }

  @Override
  public Invoice completeTrip(int tripId) {
    final Invoice invoice = new Invoice();
    Trips trip = findOne(tripId);
    final Driver driver = trip.getDriver();
    trip.setStatus(COMPLETED);
    trip.setCompletedAt(LocalDate.now());
    invoice.setDriver(driver);
    invoice.setDoneAt(LocalDate.now());
    invoice.setTotalPrice(invoice.getUnitPrice() * trip.getDistance());
    invoice.setDistance(trip.getDistance());
    invoice.setTrip(trip);

    driver.setStatus(AVAILABLE);
    driverRepository.save(driver);

    return invoiceService.create(invoice);
  }

  @Override
  public Trips createTrip(int rider_id, int driver_id, double dest_lat, double dest_long) {

    final Rider rider = riderService.findById(rider_id);
    final Driver driver = driverService.findById(driver_id);

    final Trips trip = new Trips();
    trip.setFromLat(rider.getLatitude());
    trip.setFromLng(rider.getLongitude());
    trip.setDriver(driver);
    trip.setRider(rider);
    trip.setToLat(dest_lat);
    trip.setToLng(dest_long);
    trip.setStatus(ACTIVE);
    trip.setDistance(
        Math.round(
            locationUtil.getDistanceFromLatLonInKm(
                rider.getLatitude(), rider.getLongitude(), dest_lat, dest_long)));

    driver.setStatus(ONTRIP);
    driverRepository.save(driver);

    return tripsRepository.save(trip);
  }
}
