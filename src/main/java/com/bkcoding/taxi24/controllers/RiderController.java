package com.bkcoding.taxi24.controllers;

import com.bkcoding.taxi24.domain.Driver;
import com.bkcoding.taxi24.domain.Rider;
import com.bkcoding.taxi24.dto.ApiResponse;
import com.bkcoding.taxi24.dto.RiderDto;
import com.bkcoding.taxi24.exceptions.ValidationException;
import com.bkcoding.taxi24.services.RiderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/riders")
public class RiderController {
  @Autowired private RiderService riderService;

  @PostMapping
  public ResponseEntity<ApiResponse<Rider>> createRider(
      @RequestBody RiderDto rider, BindingResult result) {

    // Check validation errors
    if (result.hasErrors()) {
      String errors =
          result.getAllErrors().stream()
              .map(DefaultMessageSourceResolvable::getDefaultMessage)
              .collect(Collectors.joining("::"));
      throw new ValidationException(errors);
    }

    final Rider createdRider = riderService.createRider(rider.mapToRider());

    final String message = "Rider created successfully...";
    final ApiResponse<Rider> body = new ApiResponse<>(HttpStatus.CREATED, message, createdRider);

    log.info(message);
    return ResponseEntity.status(HttpStatus.CREATED).body(body);
  }

  @GetMapping
  public ResponseEntity<ApiResponse<List<Rider>>> getAllRiders() {

    final List<Rider> riders = riderService.allRivers();

    final String message = "All Riders retrieved successfully";
    final ApiResponse<List<Rider>> body = new ApiResponse<>(HttpStatus.OK, message, riders);

    log.info(message);
    return ResponseEntity.ok(body);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<Rider>> findById(@PathVariable("id") int id) {

    Rider rider = riderService.findById(id);

    final String message = "Rider retrieved successfully";
    final ApiResponse<Rider> body = new ApiResponse<>(HttpStatus.OK, message, rider);

    log.info(message);
    return ResponseEntity.ok(body);
  }

  @GetMapping("/{id}/closest-drivers")
  public ResponseEntity<Object> findAround(@PathVariable("id") int id) {

    final List<Driver> closestDrivers = riderService.searcharound(id);

    final String message = "Closest drivers fetched successfully";
    final ApiResponse<List<Driver>> body =
        new ApiResponse<>(HttpStatus.OK, message, closestDrivers);

    log.info(message);
    return ResponseEntity.ok(body);
  }
}
