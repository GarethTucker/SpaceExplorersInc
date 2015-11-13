package model.planets;

import java.awt.Point;

import model.BuildSpace;
import view.PlanetRenderer;

/**
 * Building placement is -75, -125, -225
 * @author User
 *
 */
public class Earth extends Planet{
	
	public Earth(Point point){
		super(point.x, point.y, 300);
		BuildSpace bs1 = new BuildSpace(this, -75);
		BuildSpace bs2 = new BuildSpace(this, -125);
		BuildSpace bs3 = new BuildSpace(this, 137);
		buildSpaces.add(bs1);
		buildSpaces.add(bs2);
		buildSpaces.add(bs3);
		
		selectedBuildSpace = bs1;
	}

	@Override
	public String getName() {
		return "earth";
	}

}
