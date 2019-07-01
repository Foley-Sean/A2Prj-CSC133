package com.mycompany.a2;
import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

public class MapView extends Container implements Observer {
	private Point loc = new Point(getX(), getY());
	//Point2D pCmpRelScrn = new Point2D(getAbsoluteX(), getAbsoluteY());
	private IGameWorld gw;
	private GameObjectCollection gc;
	private IIterator itr;
	//private double width;
	//private double height;
	public MapView(GameWorld gw2) {
		//find way to set to black
		//this.getAllStyles().setBgColor(ColorUtil.BLACK);
		//this.repaint();
		gw = gw2;
		gc = gw2.getWorld();
		itr = gc.getIterator();
		
	}
	@Override
	public void update(Observable observable, Object data) {
		// calls repaint when invoked to draw game world objects
		gw = (IGameWorld) data;
		itr = gw.getIterator();
		this.repaint();	
		
	}
	
	@Override
	public void paint(Graphics g) {
		//super.paint(g);
		
		while(itr.hasNext()) {
			GameObject obj = (GameObject)itr.getNext();
			if(obj instanceof IDrawable) {
				((IDrawable) obj).draw(g, loc);
			}
		}
		
	}
	


}
