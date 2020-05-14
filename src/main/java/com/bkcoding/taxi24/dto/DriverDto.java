package com.bkcoding.taxi24.dto;

import com.bkcoding.taxi24.domain.Driver;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DriverDto {
  @NotBlank(message = "Please provide names")
  private String names;

  @NotNull(message = "Please provide the gender")
  private Driver.EGender gender;

  @NotBlank(message = "Please provide the permit card")
  private String permitCard;

  private double latitude;
  private double longitude;

  public Driver mapToDriver() {
    return new Driver(
        names, gender, permitCard, Driver.EDriverStatus.AVAILABLE, latitude, longitude);
  }
}
