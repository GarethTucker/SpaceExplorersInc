package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.SwingUtilities;

import static util.PrintTool.p;

import model.State;
import model.planets.Planet;
import view.MainPanel;

public class Listener implements MouseListener, MouseMotionListener, ActionListener, MouseWheelListener{
	
	private final State state;
	private final MainPanel panel;
	private int x,y;
	//private final int MOVEAMOUNT = 15;
	
	public Listener(State state, MainPanel panel){
		this.state = state;
		this.panel = panel;
		panel.addMouseWheelListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		String input = action.getActionCommand();
		state.addBuilding(input);
	}

	@Override
	public void mouseDragged(MouseEvent action) {
		if(SwingUtilities.isLeftMouseButton(action)){
			for(Planet planet: state.getPlanets()){
				if(planet.onSlideRect(action.getX(), action.getY())){
					if(action.getX() > x){					
						planet.rotate(10);
					}else{
						planet.rotate(-10);
					}
					this.x = action.getX();
				}
			}
		}else if(SwingUtilities.isRightMouseButton(action)){
			int moveX = -(this.x - action.getX());
			int moveY = -(this.y - action.getY());
			for(Planet planet: state.getPlanets()){
//				if(action.getX() > x){
//					moveX = MOVEAMOUNT;
//				}else if(action.getX() < x){
//					moveX = -MOVEAMOUNT;
//				}
//				if(action.getY() > y){
//					moveY = MOVEAMOUNT;
//				}else if(action.getY() < y){
//					moveY = -MOVEAMOUNT;
//				}
				planet.move(moveX, moveY);
			}
			this.x = action.getX();
			this.y = action.getY();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent action) {
		state.click(action.getX(), action.getY());
//		panel.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent action) {
		this.x = action.getX();
		this.y = action.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent action) {
		state.zoom(action.getWheelRotation());	
	}
	
}
