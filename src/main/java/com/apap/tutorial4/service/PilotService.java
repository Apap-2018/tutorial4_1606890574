package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.model.FlightModel;

/**
 * 
 * PilotService
 *
 */
public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	PilotModel getPilotDetailById(long id);
	List<PilotModel> getAll();
	void updatePilot(PilotModel oldPilot, PilotModel newPilot);
	void addPilot(PilotModel pilot);
	void deletePilot(PilotModel pilot);
}
