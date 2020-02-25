package com.ashref.rest.api.payload.requests;

import lombok.Data;

@Data
public class TemperatureRequest {
	private int[] temperatures;
}
