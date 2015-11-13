package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import model.State;
import view.ButtonPanel;
import view.MainPanel;
import view.ResourceLabel;

public class Main {
	
	public static void main(String[] args){
		State state = new State();
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLACK);		
		MainPanel panel = new MainPanel(state);
		Listener listener = new Listener(state, panel);
		panel.addListener(listener);
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.NORTH);

		ButtonPanel buttonPanel = new ButtonPanel(listener);
		frame.add(buttonPanel, BorderLayout.SOUTH);
			
		frame.pack();
		frame.setVisible(true);	
		
		GameLoop gameLoop = new GameLoop(panel, state);
	}
}
