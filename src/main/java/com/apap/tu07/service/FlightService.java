package com.apap.tu07.service;

import java.util.Optional;
import java.util.List;
import com.apap.tu07.model.FlightModel;

/**
 * FlightService
 */
public interface FlightService {
	void deleteByFlightNumber(String flightNumber);

    Optional<FlightModel> getFlightDetailByFlightNumber(String flightNumber);

	FlightModel addFlight(FlightModel flight);

	Optional<FlightModel> getFlightById(long flightId);

	void updateFlight(long flightId, FlightModel flight);
	
	List<FlightModel> getAllFlight();
}