package com.apap.tu07.service;

import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.apap.tu07.model.FlightModel;
import com.apap.tu07.repository.FlightDb;

@RunWith(SpringRunner.class)
public class FlightServiceTest {
	@Autowired
	private FlightService flightService;
	
	@MockBean
	private FlightDb flightDb;
	
	@TestConfiguration 
	static class FlightServiceTestContextConfiguration{
		@Bean
		public FlightService flightService() {
			return new FlightServiceImpl();
		}
	}
	
	@Test
	public void whenValidFlightNumber_thenFlightShouldBeFound() {
		FlightModel flightModel = new FlightModel();
		flightModel.setFlightNumber("1765");
		flightModel.setOrigin("Jakarta");
		flightModel.setDestination("Bali");
		flightModel.setTime(new Date(new java.util.Date().getTime()));
		Optional<FlightModel> flight = Optional.of(flightModel);
		Mockito.when(flightDb.findByFlightNumber(flight.get().getFlightNumber())).thenReturn(flight);
		
		
		Optional<FlightModel> found = flightService.getFlightDetailByFlightNumber(flight.get().getFlightNumber());
		
		assertThat(found, Matchers.notNullValue());
		assertThat(found.get().getFlightNumber(), Matchers.equalTo(flightModel.getFlightNumber()));
		
	}

}
