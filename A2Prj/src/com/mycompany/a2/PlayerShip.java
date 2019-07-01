package com.mycompany.a2;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class PlayerShip extends Ship implements ISteerable, IDrawable {

	private SteerableMissileLauncher MML;
	
	
	public PlayerShip(int color, int speed, int dir) {
		// player ship construction
		super(color, speed, dir-90);
		
		this.MML = new SteerableMissileLauncher(getLocation(), color, speed, dir-90);
		
		
	}
	
	public String toString() {
		String parentDesc = super.toString();
		
		return "Player Ship: " + parentDesc + " MML Direction: " + this.MML.getDirectionML();
		
	}

	public SteerableMissileLauncher getMissleLauncher() {
		return this.MML;
		
	}
	
	public int showMissleCount() {
		int mag = this.getMissileCount();
		
		return mag;
		
	}
	

	@Override
	public void rotateRight() {
		// This is an override of the rotateRight function in ISteerable
		// Rotates the player ship right by a small amount.
		this.setDirection(this.getDirection() + 10);
	}

	@Override
	public void rotateLeft() {
		// This is an override of the rotateLeft function in ISteerable
		// Rotates the player ship left by a small amount
		this.setDirection(this.getDirection() - 10);
		
		
	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// Handles drawing of the component
		g.setColor(this.getColor());
		//g.drawLine((int)pCmpRelPrnt.getX(), (int)pCmpRelPrnt.getY(), (int)pCmpRelPrnt.getX() + 200, (int) pCmpRelPrnt.getY() + 200);
		g.drawRect((int)this.getLocation().getX(), (int) this.getLocation().getY(), this.getSize(), this.getSize());
		g.drawRect((int)this.getMissleLauncher().getLocation().getX(), (int)this.getMissleLauncher().getLocation().getY(),
				15, 50);
	}
	
	

}
