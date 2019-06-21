package com.mycompany.a2;
import  java.util.Random;

public class Asteroids extends MoveableGameObject {

	private int size;
	private static Random random = new Random();
	private final static int MIN = 0;
	private final static int MAX_SPEED = 15;
	private final static int MAX_DIR = 359;   // 0 - 359 = 360 degrees
	private final static int MIN_SIZE = 6;
	private final static int MAX_SIZE = 30;
	
	
	public Asteroids(int color, int speed, int dir) {
		super(color, speed, dir);  //auto generated 
		this.size = random.nextInt((MAX_SIZE - MIN_SIZE) + 1) + MIN_SIZE;
		
		
	}
	
	public int getSize() {
		return this.size;
	}
	
	public String toString() {
		
		String parentDesc = super.toString();
		String myDesc = " size = " + getSize();
		
		return "Asteroid: " + parentDesc + myDesc;
		
	}
	
	
}
