package com.mycompany.a2;

import  java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import  com.codename1.ui.geom.Point2D; 	// point 2d x,y coordinates


public abstract class GameObject {
	
	private Point2D location;
	private int color;
	private Random random = new Random();
	private final double MIN_X_Y = 0.0;
	private double MAX_X = 1024.0;
	private double MAX_Y = 768.0;
	
	public GameObject(int color) {
		
		this.color = color;
		if(color == ColorUtil.LTGRAY) {
			
			this.setLocation(new Point2D(512, 384));
		}
		else
		this.setLocation(new Point2D(Math.round(random.nextFloat() * (MAX_X - MIN_X_Y)  + MIN_X_Y), Math.round(random.nextFloat() * (MAX_Y - MIN_X_Y) + MIN_X_Y)));
		
	}
	
	public void setColor(int color) {		//used by other classes to set a color
		this.color = color;
	}
	
	public Point2D getLoc() {
		return this.getLocation();
		
	}
	
	public int getColor() {
		
		return this.color;
		
	}
	public String toString() {
 		String myDesc = "loc = " + getLoc() + " color = " + "[" + 
 												ColorUtil.red(getColor()) + "," + 
 												ColorUtil.green(getColor()) + "," +
 												ColorUtil.blue(getColor()) + "]";
		
		return myDesc;
	}

	public Point2D getLocation() {
		return this.location;
	}

	public void setLocation(Point2D location) {
		this.location = location;
	}
	

}
