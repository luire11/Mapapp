package com.tts.MapsApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MapController {
	
	@Autowired
	private MapService mapService;
	
	
	public MapService getMapService() {
		return mapService;
	}


	public void setMapService(MapService mapService) {
		this.mapService = mapService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayMap(Model model) {
		model.addAttribute("location", new Location());
		return "index.html";
	}
	


	@GetMapping("/home")
	public String getDefaultMap(Model model) {
		model.addAttribute(new Location());		
		return "index.html";
	}
	
	
	@PostMapping("/home")
	public String getMapForLocation(Location location, Model model) {
	    mapService.addCoordinates(location);
	    model.addAttribute(location);
	    return "index.html";
	}
	
}
