package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import model.buildings.Building;
import model.buildings.Building.Resource;
import model.planets.Planet;
import static util.PrintTool.p;

public class State {
	private BuildingCreator buildingCreator;
	private PlanetCreator planetCreator;
	private HashMap<Resource, Integer> resources = new HashMap<Resource, Integer>();
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	private Planet selectedPlanet;
	
	

	public State(){
		buildingCreator = new BuildingCreator();	
		planetCreator = new PlanetCreator();
		Planet earth = planetCreator.create("earth", new Point(150, 150));
		Planet earth2 = planetCreator.create("earth", new Point(400,400));
		planets.add(earth);
		planets.add(earth2);
		selectedPlanet = earth;		
	}

	public void update() {
		for(Planet planet: planets){
			ArrayList<Resource> additionalResources = planet.update();
			if(additionalResources != null){
				addResources(additionalResources);
			}
		}
	}

	private void addResources(ArrayList<Resource> additionalResources) {
		for(Resource resource: additionalResources){
			if(resources.keySet().contains(resource)){
				resources.put(resource, resources.get(resource)+1);
			}else{
				resources.put(resource, 1);
			}
		}		
	}

	public void addBuilding(String type) {

		Building b = buildingCreator.create(type, resources);
		BuildSpace space = selectedPlanet.getSelectedBuildSpace();
		space.addBuilding(b);
	}

	public void click(int x, int y) {
		for(Planet planet: getPlanets()){
			if(planet.isBuildingSpace(x, y)){
				planet.setSelectedBuildingSpace(x, y);
			}
		}
	}
	
	public void zoom(int wheelRotation) {
		for(Planet planet: planets){
			planet.zoom(wheelRotation);
		}
	}
	

	public ArrayList<Planet> getPlanets() {
		return planets;
	}

	public HashMap<Resource, Integer> getResources() {
		return resources;
	}	
	
	public Planet getSelectedPlanet() {
		return selectedPlanet;
	}

	public void setSelectedPlanet(Planet selectedPlanet) {
		this.selectedPlanet = selectedPlanet;
	}

	
}
