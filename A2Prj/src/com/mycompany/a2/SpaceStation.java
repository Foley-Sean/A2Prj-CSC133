package com.mycompany.a2;
import java.util.Random;

public class SpaceStation extends FixedGameObject {
	private Random random = new Random();
	private int blinkRate;
	private boolean light;
	private int MAX = 6;
	private int MIN = 0;

	public SpaceStation(int color) {
		// A stationary space station where a player ship can reload missiles.
		// Has a random blink rate and unique id. 
		
		super(color);
		
		this.blinkRate = random.nextInt(MAX - MIN) + MIN;	//generates blink rate 0-6
		this.setLight(light);
	
	}
	
	public int getBlinkRate() {
		return this.blinkRate;
	}
	
	public void setBlinkRate(int blink) {
		this.blinkRate = blink;
	}
	
	public void setLight(Boolean on) {
		this.light = on;
	}
	
	public boolean getLight() {
		return this.light;
	}
	public String toString() {
		String parentDesc = super.toString();
		
		String myDesc = " blink rate = " +  getBlinkRate();
		return "Space Station: " + parentDesc + myDesc;
		
	}

}
