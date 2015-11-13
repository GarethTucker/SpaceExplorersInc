package model;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import model.buildings.Building;
import model.buildings.Building.Resource;
import model.planets.Planet;
import static util.PrintTool.p;

public class BuildSpace {

	private Shape box;
	private double initialRotation;
	private Building building;
	private int boxWidth = 50;
	private int boxHeight = 30;
	private double rotation = 0;
	private double scale = 1;
	private Planet planet;
	
	public BuildSpace(Planet planet, double degreesRotation){
		building = null;
		this.initialRotation = degreesRotation;
		this.planet = planet;
		int width = planet.getWidth();
		box = new Rectangle(planet.getCenter().x-(boxWidth/2), planet.getCenter().y-(width/2)+5, boxWidth, boxHeight);
		rotate(degreesRotation);		
	}
	

	public ArrayList<Resource> update() {
		if(building != null){
			return building.update();
		}
		return null;
	}

	public boolean contains(int xPos, int yPos) {
		return box.contains(xPos, yPos);
	}

	public void rotate(double degrees) {
		//TODO: Fix > 360
		rotation = rotation+degrees;
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.toRadians(degrees), planet.getCenter().x, planet.getCenter().y);
		box = transform.createTransformedShape(box);
	}

	public void zoom(int wheelRotation) {
		scale  = scale + (double)wheelRotation/10;		
		if(scale <= 0.1){
			scale = 0.1;
		}
		
		boxWidth = (int) (50*scale);
		boxHeight = (int) (30*scale);
		
		int x = planet.getCenter().x-(boxWidth/2);
		int y = planet.getCenter().y-(planet.getWidth()/2);
		
		box = new Rectangle(x, y, boxWidth, boxHeight);
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.toRadians(rotation), planet.getCenter().x, planet.getCenter().y);
		box = transform.createTransformedShape(box);		
	}
	

	public void move(int moveX, int moveY) {
		int x = planet.getCenter().x-(boxWidth/2);
		int y = planet.getCenter().y-(planet.getWidth()/2);
		
		box = new Rectangle(x, y, boxWidth, boxHeight);
		
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.toRadians(rotation), planet.getCenter().x, planet.getCenter().y);
		box = transform.createTransformedShape(box);
	}

	public void addBuilding(Building b) {
		building = b;
	}

	public boolean hasBuilding() {
		return building != null;
	}

	public double getInitialRotation() {
		return initialRotation;
	}
	
	public Shape getBox(){
		return box;
	}

	public Building getBuilding() {
		return building;
	}

	public double getRotation() {
		return rotation;
	}


}
