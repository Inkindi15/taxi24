package com.bkcoding.taxi24.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Driver {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String names;

  @Enumerated(EnumType.STRING)
  private EGender gender;

  @Column(unique = true)
  private String permitCard;

  private EDriverStatus status;
  private double latitude;
  private double longitude;

  public Driver(
      String names,
      EGender gender,
      String permitCard,
      EDriverStatus status,
      double latitude,
      double longitude) {
    this.names = names;
    this.gender = gender;
    this.permitCard = permitCard;
    this.status = status;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public enum EGender {
    MALE,
    FEMALE
  }

  public enum EDriverStatus {
    AVAILABLE,
    ONTRIP
  }
}
