package model.buildings;

public class LevelZeroStrategy implements BuildingLevelStrategy {

	@Override
	public int update() {
		return 0;
	}

	@Override
	public BuildingLevelStrategy upgrade() {
		return new LevelOneStrategy();
	}
	
	public String toString(){
		return "0";
	}

}
