package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;

public abstract class MoveableGameObject extends GameObject implements IMoveable{
//implements the moveable interface
	
	private int speed;
	private int direction;
	
	public MoveableGameObject(int color, int speed, int dir) {
		//constructor for moveable game objects
		super(color);
		this.speed = speed;
		this.direction = dir;
	}

	public int getSpeed() {
		return this.speed;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setDirection(int dir) {
		this.direction = dir;
	}
	
	public void move() {
		final Point2D newLocation;
		final Point2D oldLocation = this.getLoc();
		double oldX = oldLocation.getX();
		double oldY = oldLocation.getY();
		
		double deltaX = Math.cos(Math.toRadians(this.getDirection())) * this.getSpeed();
		double deltaY = Math.sin(Math.toRadians(this.getDirection())) * this.getSpeed();
		
		newLocation = new Point2D(Math.round(oldX + deltaX), Math.round(oldY + deltaY));
		this.setLocation(newLocation);
		
	}
	
	public String toString() {
		
		String parentDesc = super.toString();
		String myDesc = " speed = " + getSpeed() + " direction: " + getDirection();
		
		return parentDesc + myDesc;
		
	}
	
}
