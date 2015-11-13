package model.buildings;

import java.util.ArrayList;
import java.util.HashMap;

public class Construction extends Building {

	public Construction() {
		super("construction", Resource.NULL);
	}

	@Override
	public HashMap<Resource, Integer> getCost() {
		HashMap<Resource, Integer> cost = new HashMap<Resource, Integer>();
		return cost;
	}
	
	

}
