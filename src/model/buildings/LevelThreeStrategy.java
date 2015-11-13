package model.buildings;

public class LevelThreeStrategy implements BuildingLevelStrategy {

	@Override
	public int update() {
		return 3;
	}

	@Override
	public BuildingLevelStrategy upgrade() {
		return this;
	}
	
	public String toString(){
		return "3";
	}

}
