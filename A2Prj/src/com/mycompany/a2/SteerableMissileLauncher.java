package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;

public class SteerableMissileLauncher extends MissileLauncher implements ISteerable {
	//need to implement a way to change direction
	
	public SteerableMissileLauncher(Point2D point2d, int color, int speed, int dir) {
		super(color, speed, dir);
		
	}


	public int getDirectionML() {
		return this.getDirection();
		
	}
	


	@Override
	public void rotateRight() {
		// turn a steerable object by a given theta
		final int THETA = 10;
		int dir = this.getDirection();
		this.setDirection(dir + THETA);
		
	}


	@Override
	public void rotateLeft() {
		// turn a sterrable missile launcher by a given theta
		final int THETA = 10;
		int dir = this.getDirection();
		this.setDirection(dir - THETA);
		
	}
	
	public String toString() {
		String myDesc = "ML Direction: " + this.getDirectionML();
		
		return myDesc;
		
	}
	
	

}
