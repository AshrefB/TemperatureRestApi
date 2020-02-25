package com.ashref.rest.api.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.ashref.rest.api.payload.requests.TemperatureRequest;
import com.ashref.rest.api.payload.responses.TemperatureResponse;

@Service
public class TemperatureService {
	public TemperatureResponse min(TemperatureRequest request) {
		TemperatureResponse response = new TemperatureResponse();
		int[] t = request.getTemperatures();
		Arrays.sort(t);
		response.setResult(t[0]);
		return response;
	}
	
	public TemperatureResponse max(TemperatureRequest request) {
		TemperatureResponse response = new TemperatureResponse();
		int[] t = request.getTemperatures();
		Arrays.sort(t);
		response.setResult(t[t.length-1]);
		return response;
	}
	
	public TemperatureResponse avg(TemperatureRequest request) {
		TemperatureResponse response = new TemperatureResponse();
		int[] t = request.getTemperatures();
		response.setResult((int) Arrays.stream(t).average().getAsDouble());
		return response;
	}
	
}
