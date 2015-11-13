package model.buildings;

import java.util.HashMap;

public class Factory extends Building {

	public Factory() {
		super("factory", Resource.PARTS);
	}

	@Override
	public HashMap<Resource, Integer> getCost() {
		HashMap<Resource, Integer> cost = new HashMap<Resource, Integer>();
		cost.put(Resource.GOLD, 5);
		return cost;
	}

}
