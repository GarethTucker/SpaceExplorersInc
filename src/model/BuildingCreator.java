package model;

import java.util.HashMap;

import model.buildings.Building;
import model.buildings.Building.Resource;
import model.buildings.Factory;
import model.buildings.Mine;
import static util.PrintTool.p;
public class BuildingCreator {

	public Building create(String input, HashMap<Resource, Integer> resources) {
			
		if(input.equals("factory") && canBuild(resources, (new Factory()))){
			return new Factory();
		}else if(input.equals("mine")){
			return new Mine();
		}
		return null;
	}
	
	public  boolean canBuild(HashMap<Resource, Integer> resources, Building building){
		HashMap<Resource, Integer> cost = building.getCost();
		for(Resource resource: cost.keySet()){			
			if(resources.containsKey(resource) && resources.get(resource) >= cost.get(resource)){
				removeResources(resources, cost);
				return true;
			}
		}
		return false;		
	}

	private void removeResources(HashMap<Resource, Integer> resources, HashMap<Resource, Integer> cost) {
		for(Resource resource: cost.keySet()){
			resources.put(resource, resources.get(resource) - cost.get(resource));
		}
		
	}
}
