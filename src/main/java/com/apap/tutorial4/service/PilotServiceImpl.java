package com.apap.tutorial4.service;
import java.util.List;

import javax.swing.ListModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.repository.PilotDb;

/**
 * 
 * PilotServiceImpl
 *
 */
@Service 
@Transactional
public class PilotServiceImpl implements PilotService{
	@Autowired 
	private PilotDb pilotDb;

	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}	

	@Override
	public void addPilot(PilotModel pilot) {
		pilotDb.save(pilot);
	}

	@Override
	public void deletePilot(PilotModel pilot) {
		pilotDb.delete(pilot);
	}

	@Override
	public PilotModel getPilotDetailById(long id) {
		return pilotDb.getOne(id);
	}

	@Override
	public List<PilotModel> getAll() {
		List<PilotModel> pilots = pilotDb.findAll();
		return pilots;
	}

	@Override
	public void updatePilot(PilotModel oldPilot, PilotModel newPilot) {
		oldPilot.setFlyHour(newPilot.getFlyHour());
		oldPilot.setName(newPilot.getName());
	}

	
}
