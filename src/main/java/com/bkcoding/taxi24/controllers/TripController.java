package com.bkcoding.taxi24.controllers;

import com.bkcoding.taxi24.domain.Invoice;
import com.bkcoding.taxi24.domain.Trips;
import com.bkcoding.taxi24.dto.ApiResponse;
import com.bkcoding.taxi24.services.TripsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/trips")
public class TripController {
  @Autowired private TripsService tripsService;

  @PostMapping
  public ResponseEntity<ApiResponse<Trips>> createTrip(
      @RequestParam int rider_id,
      @RequestParam int driver_id,
      @RequestParam("dest_lat") double latitude,
      @RequestParam("dest_long") double longitude) {

    final Trips trip = tripsService.createTrip(rider_id, driver_id, latitude, longitude);

    final String message = "Trip created successfully";
    final ApiResponse<Trips> body = new ApiResponse<>(HttpStatus.CREATED, message, trip);

    log.info(message);
    return ResponseEntity.status(HttpStatus.CREATED).body(body);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<Trips>> getTripById(@PathVariable("id") int id) {

    Trips trip = tripsService.findOne(id);

    final String message = "Trip retrieved successfully";
    final ApiResponse<Trips> body = new ApiResponse<>(HttpStatus.OK, message, trip);

    log.info(message);
    return ResponseEntity.ok(body);
  }

  @GetMapping("/active")
  public ResponseEntity<ApiResponse<List<Trips>>> activeTrips() {

    final List<Trips> trips = tripsService.getAllActiveTrips();

    final String message = "Active trips returned successfully";
    final ApiResponse<List<Trips>> body = new ApiResponse<>(HttpStatus.OK, message, trips);

    log.info(message);
    return ResponseEntity.ok(body);
  }

  @PutMapping("/{id}/complete")
  public ResponseEntity<ApiResponse<Invoice>> completeActiveTrip(@PathVariable("id") int id) {

    Invoice invoice = tripsService.completeTrip(id);

    final String message = "Trip completed successfully and invoice generated successfully";
    final ApiResponse<Invoice> body = new ApiResponse<>(HttpStatus.OK, message, invoice);

    log.info(message);
    return ResponseEntity.ok(body);
  }
}
