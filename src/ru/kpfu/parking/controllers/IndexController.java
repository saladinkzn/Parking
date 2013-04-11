package ru.kpfu.parking.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

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

	@RequestMapping("/ad1")
	public String add1(HttpServletRequest request) {
		// Получаем список парковок
		UserService userService = UserServiceFactory.getUserService();
		if (request.getUserPrincipal() != null) {
			boolean adminUser = userService.isUserAdmin();
			if (adminUser) {
				final List<Parking> allParkings = parkingRepository
						.getAllNotModerated();
				// Передаем его на view.
				request.setAttribute("parkings", allParkings);
				// Передаем управление на index.jsp
				return "ad1";
			} else
				return index(request);
		} else {
			return "redirect:" + (userService.createLoginURL("/ad1"));
		}
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
	@RequestMapping(value="/ad1", method=RequestMethod.POST)
	public String addd1(HttpServletRequest request, @RequestParam("id") Long id) {
		parkingRepository.deleteParking(parkingRepository.getById(id));
		return "redirect:/ad1";

	}
	@RequestMapping(value="ad2", method=RequestMethod.POST)
	public String addd2(HttpServletRequest request, @RequestParam("id") Long id) {
		parkingRepository.setModerated(parkingRepository.getById(id));
		return "redirect:/ad1";

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
	public String addParking(HttpServletRequest request) {
		if (request.getUserPrincipal() != null) {
			return "add";
		} else {
			UserService userService = UserServiceFactory.getUserService();
			return "redirect:" + (userService.createLoginURL("/add"));
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNewParking(@RequestParam("name") String name,
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

	/**
	 * Получение маркеров,прошедших модерацию
	 * 
	 * @return json с инфой для отображения
	 */
	@RequestMapping(value = "/markers")
	@ResponseBody
	public String getMarkers() {
		StringBuilder stringBuilder = new StringBuilder();
		List<Parking> allParkParkingings = parkingRepository.getAllModerated();
		stringBuilder.append("[");
		for (int i = 0; i < allParkParkingings.size(); i++) {
			Parking parking = allParkParkingings.get(i);
			stringBuilder.append("{\"x\":");
			stringBuilder.append(parking.getLatitude());
			stringBuilder.append(",\"y\":");
			stringBuilder.append(parking.getLongitude());
			stringBuilder.append(",\"text\":");
			stringBuilder.append("\"");
			stringBuilder.append(parking.getDescription());
			stringBuilder.append("\"");
			stringBuilder.append("}");
			if (i < allParkParkingings.size() - 1) {
				stringBuilder.append(",");
			}
		}
		stringBuilder.append("]");

		return stringBuilder.toString();
	}
}
