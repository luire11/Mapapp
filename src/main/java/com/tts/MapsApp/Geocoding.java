package com.tts.MapsApp;

import lombok.Data;

@Data
public class Geocoding {
	private Geometry geometry;

	public Geometry getGeometry() {
		
		return geometry;
	}

}
