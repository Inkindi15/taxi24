package com.bkcoding.taxi24.controllers;

import com.bkcoding.taxi24.domain.Driver;
import com.bkcoding.taxi24.dto.ApiResponse;
import com.bkcoding.taxi24.dto.DriverDto;
import com.bkcoding.taxi24.exceptions.ValidationException;
import com.bkcoding.taxi24.services.DriverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Slf4j
@RequestMapping("/drivers")
public class DriverController {
  @Autowired private DriverService driverService;

  /**
   * This endpoint creates a driver.
   *
   * @param driver of {@link DriverDto} is a dto model to hold driver info.
   * @param result of {@link BindingResult} is for any validation errors.
   * @return the created {@link Driver}
   */
  @PostMapping
  public ResponseEntity<ApiResponse<Driver>> createDriver(
      @RequestBody DriverDto driver, BindingResult result) {

    // Check validation errors
    if (result.hasErrors()) {
      String errors =
          result.getAllErrors().stream()
              .map(DefaultMessageSourceResolvable::getDefaultMessage)
              .collect(Collectors.joining("::"));
      throw new ValidationException(errors);
    }

    final Driver createdDriver = driverService.createDriver(driver.mapToDriver());

    final String message = "Driver created successfully..";
    ApiResponse<Driver> body = new ApiResponse<>(CREATED, message, createdDriver);

    log.info(message);
    return ResponseEntity.status(CREATED).body(body);
  }

  /**
   * This endpoint fetch all drivers.
   *
   * @return a list of {@link Driver}
   */
  @GetMapping
  public ResponseEntity<ApiResponse<List<Driver>>> getAllDriver() {

    final List<Driver> drivers = driverService.allDrivers();

    final String message = "Drivers retrieved successfully...";
    ApiResponse<List<Driver>> body = new ApiResponse<>(OK, message, drivers);

    log.info(message);
    return ResponseEntity.ok(body);
  }

  /**
   * This endpoint fetch a single {@link Driver}.
   *
   * @param id the {@link Driver} id.
   * @return the {@link Driver}
   */
  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<Driver>> findById(@PathVariable("id") int id) {

    Driver driver = driverService.findById(id);

    final String message = "The driver retrieved successfully ..";
    ApiResponse<Driver> body = new ApiResponse<>(OK, message, driver);

    log.info(message);
    return ResponseEntity.ok(body);
  }

  /**
   * This method fetch all available {@link Driver}
   *
   * @return a {@link List} of {@link Driver}
   */
  @GetMapping("/available")
  public ResponseEntity<ApiResponse<List<Driver>>> findAvailableDrivers() {
    final List<Driver> drivers = driverService.availableDrivers();

    final String message = "Available Drivers retrieved successfully...";
    ApiResponse<List<Driver>> body = new ApiResponse<>(OK, message, drivers);

    log.info(message);
    return ResponseEntity.ok(body);
  }

  /**
   * This endpoint fetch available drivers within distance in a specific location.
   *
   * @return a {@link List} of {@link Driver}
   */
  @GetMapping("/around")
  public ResponseEntity<ApiResponse<List<Driver>>> findAvailableDriversAroundDistance(
      @RequestParam int distance, @RequestParam double longitude, @RequestParam double latitude) {

    final List<Driver> drivers = driverService.availableDrivers(distance, longitude, latitude);

    final String message = "Available Drivers retrieved successfully...";
    ApiResponse<List<Driver>> body = new ApiResponse<>(OK, message, drivers);

    log.info(message);
    return ResponseEntity.ok(body);
  }
}
