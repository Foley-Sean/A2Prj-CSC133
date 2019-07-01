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
		g.drawLine(pCmpRelPrnt.getX(), pCmpRelPrnt.getY(), pCmpRelPrnt.getX() - 30 ,
				pCmpRelPrnt.getY() - 30);
	}
	
}
