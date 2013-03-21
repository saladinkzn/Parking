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

/**
 * Класс - пример контроллера.
 * 
 * Обратите внимание: 1. @Controller - говорит Spring Framework, что данный
 * класс является контроллером.
 * 
 * @author Timur
 * 
 */
@Controller
public class IndexController {
	/**
	 * @Autowired - вставляет ParkingRepository в данный контроллер.
	 */
	@Autowired
	ParkingRepository parkingRepository;

	/**
	 * Метод-обработчик запроса по адресу /
	 * 
	 * @param request
	 *            объект, служащий для передачи данных между контроллером и вью
	 * @return строка - название view без расширения.
	 */
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		// Получаем список парковок
		final List<Parking> allParkings = parkingRepository.getAllModerated();
		// Передаем его на view.
		request.setAttribute("parkings", allParkings);
		// Передаем управление на index.jsp
		return "index";
	}

	/**
	 * Метод-обработчик формы
	 * 
	 * @RequestMapping: value - /add - значит что данный метод обрабатывает
	 *                  запрос по адресу /add
	 * 
	 * @param address
	 *            - тк этот параметр помечен аннотацией @RequestParam, то в него
	 *            будет передано значение из поля name формы
	 * @return строка - название view без расширения.
	 */
	
	@RequestMapping("/add")
	public String addParking()
	{
		return "add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNewParking(
			@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam(value = "longitude") double longitude,
			@RequestParam("latitude") double latitude,
			@RequestParam("workingPlan") String workingPlan,
			@RequestParam("pricing") double pricing,
			@RequestParam("description") String description) {
		// Создаем новую парковку
		Parking parking = new Parking(address, latitude, longitude);
		parking.setName(name);
		parking.setWorkingPlan(workingPlan);
		parking.setPricing(pricing);
		parking.setDescription(description);
		// Сохраняем парковку
		parkingRepository.save(parking);
		// Отображаем страницу успеха.
		return "success";
	}
}
