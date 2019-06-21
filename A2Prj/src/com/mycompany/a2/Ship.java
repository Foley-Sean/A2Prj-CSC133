package com.mycompany.a2;
import  java.util.Random;

public abstract class Ship extends MoveableGameObject {

	private int missileCount;
	private int size;
	private static Random random = new Random();
	private final static int MIN = 0;
	private final static int MAX_SPEED = 15;
	private final static int MAX_DIR = 359;   // 0 - 359 = 360 degrees
	private final static int MIN_SIZE = 15;
	private final static int MAX_SIZE = 25;
	
	public Ship(int color, int speed, int dir) {
		// Create a ship
		
		super(color, speed, dir);
		
		
		if(this instanceof NonPlayerShip) {
			//choose between a big size or small size randomly
			int x = Math.round(random.nextInt(2));
			
			if(x == 0) {
				//small size
				this.size = MIN_SIZE;
				this.missileCount = 4;
			}
			
			else if(x == 1) {
				this.size = MAX_SIZE;
				this.missileCount = 4;
			}
			
		}
		else if(this instanceof PlayerShip) {
			
			this.size = MAX_SIZE;
			this.missileCount = 10;
			
		}
		
		
		
	}
	
	
	public int getSize() {
		return this.size;
	}
	
	public int getMissileCount() {
		return this.missileCount;
	}
	
	public void decMissileCount() {
		this.missileCount--;
	}
	
	public void setMissileCount(int mc) {
		this.missileCount = mc;
		
	}
	
	public Ship getShip() {
			return this;
	}
	
	public String toString() {
		
		String parentDesc = super.toString();
		String myDesc = " size = " + getSize() + " missiles = " + getMissileCount();;
		
		return parentDesc + myDesc;
		
	}

}
