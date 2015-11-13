package controller;

import model.State;
import view.MainPanel;

public class GameLoop{

	private boolean gameRunning = true;
	private long lastFpsTime;
	long lastLoopTime = System.nanoTime();
	final int TARGET_FPS = 60;
	final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;   
	int count = 0;
	
	public GameLoop(MainPanel panel, State state){
		// keep looping round till the game ends
		while (gameRunning){
			// work out how long its been since the last update, this
			// will be used to calculate how far the entities should
			// move this loop
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double)OPTIMAL_TIME);

			// update the frame counter
			lastFpsTime += updateLength;
			// update our FPS counter if a second has passed since
			// we last recorded
			if (lastFpsTime >= 1000000000){
//				System.out.println("(FPS: "+fps+")");
				lastFpsTime = 0;
			}

			// update the game logic
			doGameUpdates(delta);

			// draw everything
			state.update();
			panel.repaint();
			

			// we want each frame to take 10 milliseconds, to do this
			// we've recorded when we started the frame. We add 10 milliseconds
			// to this and then factor in the current time to give 
			// us our final value to wait for
			// remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
			
			try {
				long updateTime = (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000;
				if(updateTime < 0){
					updateTime = 0;
				}
				Thread.sleep( updateTime );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	private void doGameUpdates(double delta){
//		for (int i = 0; i < stuff.size(); i++){
//			// all time-related values must be multiplied by delta!
//			Stuff s = stuff.get(i);
//			s.velocity += Gravity.VELOCITY * delta;
//			s.position += s.velocity * delta;
//
//			// stuff that isn't time-related doesn't care about delta...
//			if (s.velocity >= 1000)
//			{
//				s.color = Color.RED;
//			}
//			else
//			{
//				s.color = Color.BLUE;
//			}
//		}
	}
}
