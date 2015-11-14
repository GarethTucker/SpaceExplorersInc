package model.planets;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import model.BuildSpace;
import model.buildings.Building;
import model.buildings.Building.Resource;
import static util.PrintTool.p;

public abstract class Planet {
	
	protected int width;
	private double rotation = 0;	
	protected ArrayList<BuildSpace> buildSpaces = new ArrayList<BuildSpace>();
	protected Point center;
	protected Point origin;
	private Rectangle slider;
	private int sliderHeight = 100;
	protected BuildSpace selectedBuildSpace;
	private double scale = 1;

	
	
	public Planet(int x, int y, int width) {
		this.width = width;
		this.slider = new Rectangle(x, y-sliderHeight, width, sliderHeight);
		center = new Point(x+(width/2), y+(width/2));
		origin = new Point(x+(width/2), y+(width/2));
	}

	public ArrayList<Resource> update() {
		ArrayList<Resource> resources = new ArrayList<Resource>();
		for(BuildSpace buildSpace: buildSpaces){
			ArrayList<Resource> buildingResource = buildSpace.update();
			if(buildingResource != null){
				resources.addAll(buildingResource);
			}
		}
		return resources;
	}	

	public boolean onSlideRect(int xPos, int yPos) {
		return slider.contains(xPos,yPos);
	}

	public void rotate(int degrees) {
		//TODO: Fix > 360
		rotation = rotation + degrees;	
		for(BuildSpace bs: buildSpaces){
			bs.rotate(degrees);
		}
	}

	public void zoom(int wheelRotation) {
		
		scale = scale + (double)wheelRotation/10;		
		if(scale <= 0.1){
			scale = 0.1;
		}
		width = (int) (300*scale);
		
		
		center.x = (int) ((origin.x - 300)*scale+300);
		center.y = (int) ((origin.y - 300)*scale+300);
		for(BuildSpace bs: buildSpaces){
			bs.zoom(wheelRotation);
		}
		p("scale:"+scale+" x:"+center.x+" y:"+center.y);
	}

	public void move(int moveX, int moveY) {
		center.x = center.x + moveX;	
		center.y = center.y + moveY;
		origin.x = center.x + moveX;	
		origin.y = center.y + moveY;
		for(BuildSpace bs: buildSpaces){
			bs.move(moveX, moveY);
		}
	}

	public boolean isBuildingSpace(int xPos, int yPos) {
		for(BuildSpace shape: buildSpaces){
			if(shape.contains(xPos, yPos)){
				return true;
			}
		}
		return false;
	}	

	public void setSelectedBuildingSpace(int xPos, int yPos) {
		for(BuildSpace space: buildSpaces){
			if(space.contains(xPos, yPos)){
				selectedBuildSpace = space;
			}
		}
	}
	
	/* --------------------------------
	 * GETTERS ANS SETTERS
	 * --------------------------------
	 */	

	public Shape getSelectedBox() {
		return selectedBuildSpace.getBox();
	}

	public double getRotation() {
		return rotation;
	}

	public Point getCenter() {
		return center;
	}

	public ArrayList<BuildSpace> getBuildSpaces() {
		return buildSpaces;
	}

	public abstract String getName();

	public int getWidth() {
		return width;
	}

	public BuildSpace getSelectedBuildSpace() {
		return selectedBuildSpace;
		
	}

	public double getScale() {
		return scale ;
	}
}
