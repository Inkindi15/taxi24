package com.bkcoding.taxi24.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Rider {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String names;
  private double latitude;
  private double longitude;

  public Rider(String names, double latitude, double longitude) {
    this.names = names;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
