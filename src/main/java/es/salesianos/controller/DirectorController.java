package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Director;
import es.salesianos.service.DirectorService;

@Controller
public class DirectorController {

	@Autowired
	DirectorService service;

	@GetMapping(path = "/director")
	public ModelAndView getDirectors() {
		ModelAndView model = new ModelAndView("director");
		model.addObject("listAllDirectors", service.selectAllDirector());
		return model;
	}

	@GetMapping(path = "/deleteDirector")
	public String deleteDirector(@RequestParam String cod) {
		service.delete(cod);
		return "index";
	}

	@PostMapping(path = "/insertDirector")
	public String insertDirector(@RequestParam String name) {
		Director director = new Director();
		director.setName(name);
		service.insert(director);
		return "index";
	}

	@PostMapping(path = "/searchActor")
	public ModelAndView searchActor(@RequestParam String name) {
		ModelAndView model = new ModelAndView("searchActor");
		model.addObject("listFilterDirector", service.filterAllDirector(name));
		return model;
	}

	@GetMapping(path = "/searchActor")
	public String getsearchActor() {
		return "searchActor";
	}

}
