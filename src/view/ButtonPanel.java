package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Listener;

public class ButtonPanel extends JPanel{

	
	public ButtonPanel(Listener listener){
		Dimension size = new Dimension(600,50);
		setPreferredSize(size);
		setOpaque(false);
		JButton buildFactory = new JButton("Factory");
		buildFactory.addActionListener(listener);
		buildFactory.setActionCommand("factory");
		
		JButton buildMine = new JButton("Mine");
		buildMine.addActionListener(listener);
		buildMine.setActionCommand("mine");
		add(buildFactory);
		add(buildMine);
	}
}
