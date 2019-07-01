package com.mycompany.a2;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class NonPlayerShip extends Ship implements IDrawable {
	private  MissileLauncher ML;

	public NonPlayerShip(int color, int speed, int dir) {
		// Create non player ship
		
		super(color, speed, dir);
	
		//call missile launcher constructor to solidify relationship
		
		this.ML = new MissileLauncher(color, speed, dir);
		
		
	}

	public String toString() {
		
		String parentDesc = super.toString();
		
		return "Non Player Ship: " + parentDesc;
		
	}

	public MissileLauncher getMissleLauncher() {
		// Return misile launcher
		return this.ML;
	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		//g.drawLine((int)pCmpRelPrnt.getX(), (int)pCmpRelPrnt.getY(), (int)pCmpRelPrnt.getX() + 200, (int) pCmpRelPrnt.getY() + 200);
		g.fillRect((int)this.getLocation().getX(), (int) this.getLocation().getY(), this.getSize(), this.getSize());
	}
	

	
}
