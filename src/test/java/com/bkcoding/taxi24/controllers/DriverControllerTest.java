package com.bkcoding.taxi24.controllers;

import com.bkcoding.taxi24.domain.Driver;
import com.bkcoding.taxi24.dto.DriverDto;
import com.bkcoding.taxi24.services.DriverService;
import com.bkcoding.taxi24.services.RiderService;
import com.bkcoding.taxi24.services.TripsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.bkcoding.taxi24.domain.Driver.EDriverStatus.AVAILABLE;
import static com.bkcoding.taxi24.domain.Driver.EGender.FEMALE;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class DriverControllerTest {

  Driver driver;
  @Autowired private MockMvc mvc;
  @MockBean private DriverService driverService;
  @MockBean private RiderService riderService;
  @MockBean private TripsService tripsService;

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @BeforeEach
  public void setUp() {
    // given
    driver = new Driver();
    driver.setId(1);
    driver.setStatus(AVAILABLE);
    driver.setNames("RAISSA");

    // when
    when(driverService.availableDrivers()).thenReturn(Lists.newArrayList(driver));
    when(driverService.availableDrivers(3, -1.93543, 30.079811))
        .thenReturn(Lists.newArrayList(driver));
    when(driverService.createDriver(driver)).thenReturn(driver);
    when(driverService.allDrivers()).thenReturn(Lists.newArrayList(driver));
    when(driverService.findById(1)).thenReturn(driver);
  }

  @Test
  void createDriver() throws Exception {
    final DriverDto requestBody = new DriverDto();
    requestBody.setGender(FEMALE);
    requestBody.setNames("RAISSA");
    requestBody.setPermitCard("RAB647B");
    mvc.perform(
            post("/drivers")
                .content(asJsonString(requestBody))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void getAllDriver() {}

  @Test
  void findById() {}

  @Test
  void findAvailableDrivers() {}

  @Test
  void findAvailableDriversAroundDistance() {}
}
