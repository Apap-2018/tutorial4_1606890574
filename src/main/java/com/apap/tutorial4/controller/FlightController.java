package com.apap.tutorial4.controller;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.service.FlightService;
import com.apap.tutorial4.service.FlightServiceImpl;
import com.apap.tutorial4.service.PilotService;
import com.apap.tutorial4.repository.FlightDb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * FlightController
 *
 */
@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired 
	private PilotService pilotService;
	
	@Autowired FlightDb flightdb;
	
	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value="licenseNumber")String licenseNumber, Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);

		model.addAttribute("flight", flight);
		return "addFlight";
	}
	
	@RequestMapping(value = "/flight/add", method = RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight) {
		flightService.addFlight(flight);;
		return "add";
	}
	
	@RequestMapping(value = "/flight/delete/{id}", method = RequestMethod.GET)
	private String delete(@PathVariable(value="id") long id, Model model) {
		FlightModel flight = flightService.getFlightById(id);
		flightService.deleteFlight(flight);
		return "delete-flight";
	}
	
	@RequestMapping(value = "/flight/update/{flightNumber}")
	private String updateFlight(@ModelAttribute FlightModel oldflight, Model model, @PathVariable(value="flightNumber")String flightNumber) {
		model.addAttribute("flightNumber", flightNumber);
		model.addAttribute("flight", oldflight);
		return "update-flight";
	}
	
	
	@RequestMapping(value = "/flight/update/{flightNumber}", method = RequestMethod.POST)
	private String updateFlightSubmit(@ModelAttribute FlightModel newflight, @PathVariable(value="flightNumber")String flightNumber) {
		FlightModel oldflight = flightService.getFlightByFlightNumber(flightNumber);
		flightService.updateFlight(oldflight, newflight);
		return "flight-updated";
	}
	
	@RequestMapping(value = "/flight/viewall", method = RequestMethod.GET)
	private String viewall(Model model) {
		List<FlightModel> flights = flightService.getAll();
		model.addAttribute("flights", flights);	
		return "view-all-flight";
	}
	
}
