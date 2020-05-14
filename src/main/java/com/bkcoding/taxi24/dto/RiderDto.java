package com.bkcoding.taxi24.dto;

import com.bkcoding.taxi24.domain.Rider;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RiderDto {
  @NotBlank(message = "Please provide the names")
  private String names;

  private double latitude;
  private double longitude;

  public Rider mapToRider() {
    return new Rider(names, latitude, longitude);
  }
}
