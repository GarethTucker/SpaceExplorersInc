package model.buildings;

import static util.PrintTool.p;

public class LevelOneStrategy implements BuildingLevelStrategy {

	@Override
	public int update() {
		return 1;	
		
	}

	@Override
	public BuildingLevelStrategy upgrade() {
		return new LevelTwoStrategy();
	}
	
	public String toString(){
		return "1";
	}

}
