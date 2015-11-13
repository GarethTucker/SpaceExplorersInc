package model.buildings;

import java.util.ArrayList;
import java.util.HashMap;

import model.buildings.Building.Resource;

public class Mine extends Building{
		
	public Mine() {
		super("mine", Resource.GOLD);
	}

	@Override
	public HashMap<Resource, Integer> getCost() {
		HashMap<Resource, Integer> cost = new HashMap<Resource, Integer>();
		return cost;
	}
	
}
