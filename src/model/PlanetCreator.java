package model;

import java.awt.Point;

import model.planets.Earth;
import model.planets.Planet;

public class PlanetCreator {

	public Planet create(String input, Point point) {

		if(input.equals("earth")){
			return new Earth(point);
			
		}
		return null;
	}
}
