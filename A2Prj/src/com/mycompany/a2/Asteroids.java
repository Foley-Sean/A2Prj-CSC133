package com.mycompany.a2;
import  java.util.Random;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Asteroids extends MoveableGameObject implements IDrawable {

	private int size;
	private static Random random = new Random();
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

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// Draws a circle representing an asteroid
		g.setColor(this.getColor());
		g.fillArc((int) this.getLocation().getX(), (int)this.getLocation().getY(), 
				(int)this.getSize(), (int)this.getSize(), 0, 360);
		
	}
	
	
}
