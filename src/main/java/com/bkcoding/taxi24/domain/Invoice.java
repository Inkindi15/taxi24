package com.bkcoding.taxi24.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Invoice {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private LocalDate doneAt;
  @OneToOne private Trips trip;
  @OneToOne private Driver driver;
  private double unitPrice = 300;
  private double distance;
  private double totalPrice;
}
