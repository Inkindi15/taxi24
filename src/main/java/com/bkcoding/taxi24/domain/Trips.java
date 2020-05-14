package com.bkcoding.taxi24.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Trips {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Enumerated(EnumType.STRING)
  private ETripStatus status;

  private double fromLat;
  private double fromLng;
  private double distance;
  private double toLat;
  private double toLng;
  @OneToOne private Driver driver;
  @OneToOne private Rider rider;

  private LocalDate doneAt = LocalDate.now();

  private LocalDate completedAt;

  public enum ETripStatus {
    ACTIVE,
    COMPLETED,
    CANCELED
  }
}
