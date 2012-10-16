package model;

public class SolarSystem {
	
	
	private static String systemName;
	private static int techLevel;
	private static int resourceLevel;
	private static int xLocation;
	private static int yLocation;
	private static Planet planet;
	
	
	
	
	public SolarSystem(String systemName, Planet planet, int techLevel, int resourceLevel, int xLocation,
			int yLocation){
		
		this.systemName = systemName;
		this.planet = planet;
		this.techLevel = techLevel;
		this.resourceLevel = resourceLevel;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {


	}

}
