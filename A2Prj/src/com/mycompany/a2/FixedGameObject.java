package com.mycompany.a2;

import  java.util.Random;

public abstract class FixedGameObject extends GameObject {
	private int speed;
	private int direction;
	private static int nextId = 0;
	private int id;
	
	public FixedGameObject(int color) {
		// This constructs a new space station fixed object 
		
		super(color);
		this.speed = 0;
		this.direction = 0;
		FixedGameObject.nextId = GetNextId(nextId);
		this.id = nextId;
		
	}
	
	public int GetNextId(int id) {
		return id = id + 1;
	}

	public int getId() {
		return this.id;
	}
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " id = " + getId();
		
		return parentDesc + myDesc;
		
	}

	
}
