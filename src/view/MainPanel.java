package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Listener;
import model.State;
import model.planets.Planet;

public class MainPanel extends JPanel{
	
	private Dimension size = new Dimension(600, 500);
	private State state;
	private ResourceLabel resourceLabel;
	
	public MainPanel(State state){
		this.state = state;		
		setPreferredSize(size);	
		setBackground(Color.BLACK);

		resourceLabel = new ResourceLabel();
		add(resourceLabel, BorderLayout.EAST);				
		repaint();
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		resourceLabel.update(state);
		
		Graphics2D g2 = (Graphics2D) g;	
		
		for(Planet planet: state.getPlanets()){
			new PlanetRenderer(planet).draw(g2);
		}
	}

	public void addListener(Listener listener) {
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
}
