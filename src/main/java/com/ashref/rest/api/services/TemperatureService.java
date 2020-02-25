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
	
	public TemperatureResponse closestToZero(TemperatureRequest request) {
		TemperatureResponse response = new TemperatureResponse();
		int[] t = request.getTemperatures();
		if(t.length > 0) {
	        int num = t[0];
	        for (int i = 1; i < t.length; i++) {
	            if(Math.abs(t[i]) < Math.abs(num)) 
	            	num = t[i];
	            if(t[i] == Math.abs(num)) 
	            	num = t[i];
	        }
	        
			response.setResult(num);
		}
		return response;
	}
	
}
