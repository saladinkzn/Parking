package ru.kpfu.parking.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.kpfu.parking.entities.Parking;
import ru.kpfu.parking.repositories.ParkingRepository;

@Controller
public class IndexController {
	@Autowired
	ParkingRepository parkingRepository;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		final List<Parking> allParkings = parkingRepository.getAll();
		request.setAttribute("parkings", allParkings);
		return "index";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNewParking(HttpServletRequest request, @RequestParam("name") String name) {
		Parking parking = new Parking(name);
		parkingRepository.save(parking);
		return "success";
	}
}
