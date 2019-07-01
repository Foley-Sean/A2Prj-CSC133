package com.mycompany.a2;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class MissileLauncher extends MoveableGameObject implements IDrawable {

	public MissileLauncher(int color, int speed, int dir) {
		// Create a missile launcher
		//This is a non steerable version that is used for non player ships
		
		super(color, speed, dir);
			
	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		int x = (int)(pCmpRelPrnt.getX() /*+ this.getLocation().getX()*/);
		int y = (int)(pCmpRelPrnt.getY() /*+ this.getLocation().getY()*/);
		
		double angle = Math.toRadians(90 - this.getDirection());
		double deltaX = Math.cos(angle);
		double deltaY = Math.sin(angle);
		
		g.drawLine(x, y, (int) (x + (50 *deltaX)), (int)(y + (50 *deltaY)));
	}

	
	
}
