package com.ashref.rest.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashref.rest.api.payload.requests.TemperatureRequest;
import com.ashref.rest.api.payload.responses.TemperatureResponse;
import com.ashref.rest.api.services.TemperatureService;

@RestController
@RequestMapping("/api/temperature")
public class TemperatureController {
	@Autowired
	private TemperatureService service;
	
	@PostMapping("/min")
	public TemperatureResponse getMinTemperature(@RequestBody TemperatureRequest request) {
		return service.min(request);
	}
	
	@PostMapping("/max")
	public TemperatureResponse getMaxTemperature(@RequestBody TemperatureRequest request) {
		return service.max(request);
	}
	
	@PostMapping("/avg")
	public TemperatureResponse getAvgTemperature(@RequestBody TemperatureRequest request) {
		return service.avg(request);
	}
}
