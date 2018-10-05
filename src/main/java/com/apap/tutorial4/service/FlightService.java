package com.apap.tutorial4.service;
import java.util.List;

import com.apap.tutorial4.model.FlightModel;

/**
 * FlightService
 */
public interface FlightService {
	FlightModel getFlightById(long id);
	FlightModel getFlightByFlightNumber(String flightNumber);
	void addFlight(FlightModel flight);
	void deleteFlight(FlightModel flight);
	void updateFlight(FlightModel oldflight, FlightModel newflight);
	List<FlightModel> getAll();
}
