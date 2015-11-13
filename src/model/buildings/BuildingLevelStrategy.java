package model.buildings;

public interface BuildingLevelStrategy {
	
	public int update();

	public BuildingLevelStrategy upgrade();

}
