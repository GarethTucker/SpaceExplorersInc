package model.buildings;

import java.util.ArrayList;
import java.util.HashMap;

import model.buildings.Building.Resource;

import static util.PrintTool.p;

public abstract class Building {
	
	public enum Resource{
		GOLD("gold"), PARTS("parts"), NULL("null");
		
		public String type;
		Resource(String type){
			this.type = type;
		}
	}
	
	private BuildingLevelStrategy strategy;
	private final String type;
	private final Resource resource;
	private int resourceTime = 0;
	private boolean underConstruction;
	private int constructionTime = 0;	

	public Building(String type, Resource resource){		
		strategy = new LevelZeroStrategy();
		this.type = type;
		this.resource = resource;
		underConstruction = true;
	}
	
	public ArrayList<Resource> update(){
		if(underConstruction){
			constructionTime++;
			if(constructionTime == 500){
				underConstruction = false;
				strategy = new LevelOneStrategy();
			}
		}
		resourceTime++;
		ArrayList<Resource> resources = new ArrayList<Resource>();
		if(resourceTime == 100){
			for(int i= 0; i < strategy.update(); i++){
				resources.add(resource);
			}
			resourceTime = 0;
		}
		return resources;
	}
	
	public String toString(){
		return getType()+":level "+strategy.toString();
	}

	public void upgrade() {
		strategy = strategy.upgrade();		
	}

	public String getType() {
		if(underConstruction){
			return "construction";
		}
		return type;
	}		
	
	public abstract HashMap<Resource, Integer> getCost();
}
