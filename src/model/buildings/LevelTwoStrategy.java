package model.buildings;

public class LevelTwoStrategy implements BuildingLevelStrategy {

	@Override
	public int update() {
		return 2;
	}

	@Override
	public BuildingLevelStrategy upgrade() {
		return new LevelThreeStrategy();
	}
	
	public String toString(){
		return "2";
	}

}
