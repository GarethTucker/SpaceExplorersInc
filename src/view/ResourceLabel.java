package view;

import java.awt.Color;
import javax.swing.JLabel;

import static util.PrintTool.p;

import model.State;
import model.buildings.Building.Resource;

public class ResourceLabel extends JLabel{
	
	int gold = 0;
	int parts = 0;

	public ResourceLabel(){
		
		
	}

	public void update(State state) {
		if(state.getResources().containsKey(Resource.GOLD)){
			gold = state.getResources().get(Resource.GOLD);
		}
		if(state.getResources().containsKey(Resource.PARTS)){
			parts = state.getResources().get(Resource.PARTS);
		}
		this.setText("<html>RESOURCES<br>GOLD: "+gold+"<br>PARTS: "+parts+"</html>");
		setForeground(Color.GRAY);
		
	}
}
