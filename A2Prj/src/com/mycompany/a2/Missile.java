package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;

public class Missile extends MoveableGameObject {
	private int fuelLevel;
	private boolean source;
	private Ship ps;

	public Missile(Point2D loc, int direction, int speed, int color, Ship ship) {
		
		super(color, speed, direction);
		
		this.setLocation(loc);
		this.setColor(getColor());
		this.setDirection(direction);
		this.setSpeed(speed + 10);
		this.fuelLevel = 15;
		this.ps = ship;
		
	}
	
	public String toString() {
		String parentDesc = super.toString();  
		String myDesc = " fuel level = " + this.getFuel();
		
		if(ps instanceof PlayerShip) {
			//there is an error in this logic - always returns non player missile (source is always false or perhaps somehting else in game world)
			return "Player Missile: " + parentDesc + myDesc;
		}
		else if(ps instanceof NonPlayerShip) {
			return "Non Player Missile: " + parentDesc + myDesc;
		}
		
		return "Error";
		
	}
	
	public void setDirection(int delta) {
		//this is legacy functionality
		//direction of missiles is handled elsewhere
		if(this.source) {
			this.setDirection(this.getDirection() + delta);
		}
	}
	
	public void Speed(int delta) {
		
		this.setSpeed(this.getSpeed() + delta);
		
	}
	
	public void decFuel() {
		this.fuelLevel--;
	}
	
	public int getFuel() {
		return this.fuelLevel;
	}
	//might not need some of these
	public void setShip() {
		this.ps = this.getShip();
	}
	public Ship getShip() {
		return this.ps;
	}
	
	public Ship shipType(Ship ship) {
		Ship test = ship;
		test = test.getShip();
		
		return test;
	}
		
	
}

	
