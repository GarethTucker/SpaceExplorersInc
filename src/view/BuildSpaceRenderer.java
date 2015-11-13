package view;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import model.BuildSpace;
import model.planets.Planet;

public class BuildSpaceRenderer{
	
	private BufferedImage image;
	private int x, y;
	
	public BuildSpaceRenderer(Planet planet, BuildSpace bs) {
		int width = planet.getWidth();
		
		String path = "/resources/buildingSpaces.png";
		try {
			InputStream is = getClass().getResourceAsStream(path);
			this.image = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.toRadians(bs.getRotation()), width/2, width/2);
		transform.scale(planet.getScale(), planet.getScale());
		AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		image = op.filter(image, null);
		x = planet.getCenter().x-width/2;
		y = planet.getCenter().y-width/2;
	}

	public void draw(Graphics2D g) {
		g.drawImage(image, x, y, null);
	}
}
