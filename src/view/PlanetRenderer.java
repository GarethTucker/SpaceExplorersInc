package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static util.PrintTool.p;

import javax.imageio.ImageIO;

import model.BuildSpace;
import model.buildings.Building;
import model.planets.Planet;


public class PlanetRenderer {
	
	private BufferedImage image = null;
	private Planet planet;
	private int width;	

	public PlanetRenderer(Planet planet) {
		this.planet = planet;
		this.width = planet.getWidth();
		String path = "/resources/"+planet.getName()+".png";
		try {
			InputStream is = getClass().getResourceAsStream(path);
			this.image = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g) {
		
		g.setColor(Color.YELLOW);
		g.draw(planet.getSelectedBox());
		
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.toRadians(planet.getRotation()), width/2, width/2);
		transform.scale(planet.getScale(), planet.getScale());
		AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		image = op.filter(image, null);
		int x = planet.getCenter().x - width/2;
		int y = planet.getCenter().y - width/2;
		g.drawImage(image, x, y, null);	

		for(BuildSpace bs: planet.getBuildSpaces()){
			new BuildSpaceRenderer(planet, bs).draw(g);
			if(bs.hasBuilding()){
				new BuildingRenderer(planet, bs).draw(g);
			}
		}
	}
}
