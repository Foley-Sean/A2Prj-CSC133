package com.mycompany.a2;


public class NonPlayerShip extends Ship {
	private  MissileLauncher ML;

	public NonPlayerShip(int color, int speed, int dir) {
		// Create non player ship
		
		super(color, speed, dir);
	
		//call missile launcher constructor to solidify relationship
		
		this.ML = new MissileLauncher(color, speed, dir);
		
		
	}

	public String toString() {
		
		String parentDesc = super.toString();
		
		return "Non Player Ship: " + parentDesc;
		
	}

	public MissileLauncher getMissleLauncher() {
		// Return misile launcher
		return this.ML;
	}
	

	
}
