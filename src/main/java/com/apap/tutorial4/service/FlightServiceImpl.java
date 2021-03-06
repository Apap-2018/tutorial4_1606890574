package com.apap.tutorial4.service;
import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.repository.FlightDb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * 
 * FlightServiceImpl
 *
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService{
	@Autowired
	private FlightDb flightDb;

	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
		
	}

	@Override
	public FlightModel getFlightById(long id) {
		return flightDb.getOne(id);
	}

	@Override
	public void deleteFlight(FlightModel flight) {
		flightDb.delete(flight);
	}

	@Override
	public FlightModel getFlightByFlightNumber(String flightNumber) {
		return flightDb.findByFlightNumber(flightNumber);
	}
	
	@Override
	public void updateFlight(FlightModel oldFlight, FlightModel newFlight) {
		oldFlight.setDestination(newFlight.getDestination());
		oldFlight.setOrigin(newFlight.getOrigin());
		oldFlight.setTime(newFlight.getTime());
		
	}

	@Override
	public List<FlightModel> getAll() {
		// TODO Auto-generated method stub
		return flightDb.findAll();
	}
	
}
