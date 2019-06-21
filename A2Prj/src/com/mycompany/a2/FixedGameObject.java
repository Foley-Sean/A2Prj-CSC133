package com.mycompany.a2;


public abstract class FixedGameObject extends GameObject {
	private int speed;
	private int direction;
	private static int nextId = 0;
	private int id;
	
	public FixedGameObject(int color) {
		// This constructs a new space station fixed object 
		
		super(color);
		this.setSpeed(0);
		this.setDirection(0);
		FixedGameObject.nextId = GetNextId(nextId);
		this.id = nextId;
		
	}
	
	private void setDirection(int i) {
		this.direction = i;
		
	}

	private void setSpeed(int i) {
		this.speed = i;
		
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
