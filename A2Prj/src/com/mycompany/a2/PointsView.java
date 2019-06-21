package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class PointsView extends Container implements Observer {
	private Label pointsValueLabel;
	private Label livesValueLabel;
	private Label timeValueLabel;
	private Label soundOnOff;
	private Label missileValueLabel;
	
	@Override
	public void update(Observable observable, Object data) {
		//Updates when the game changes
		IGameWorld gw = (IGameWorld) data;
		
		this.pointsValueLabel.setText("" + gw.getScore());
		this.livesValueLabel.setText("" + gw.getLives());
		this.timeValueLabel.setText("" + gw.getTime());
		this.soundOnOff.setText(""+ gw.whatSound());
		this.missileValueLabel.setText("" + gw.getMissileCount());
		
		this.repaint();
		
	}
	
	public PointsView() {
		Container myContainer = new Container();
		myContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		
		//points
		Label pointsTextLabel = new Label("Points:");
		pointsValueLabel = new Label("XXX");
		
		pointsTextLabel.getAllStyles().setFgColor(ColorUtil.MAGENTA);
		myContainer.add(pointsTextLabel);
		myContainer.add(pointsValueLabel);
		
		//time 
		Label timeTextLabel = new Label("Time:");
		timeValueLabel = new Label("XXX");
		
		timeTextLabel.getAllStyles().setFgColor(ColorUtil.MAGENTA);
		myContainer.add(timeTextLabel);
		myContainer.add(timeValueLabel);
		
		//lives
		Label livesTextLabel = new Label("Lives:");
		livesValueLabel = new Label("XXX");
		
		livesTextLabel.getAllStyles().setFgColor(ColorUtil.MAGENTA);
		myContainer.add(livesTextLabel);
		myContainer.add(livesValueLabel);
		
		//missiles
		Label missilesTextLabel = new Label("Missiles:");
		missileValueLabel = new Label("XXX");
		
		missilesTextLabel.getAllStyles().setFgColor(ColorUtil.MAGENTA);
		myContainer.add(missilesTextLabel);
		myContainer.add(missileValueLabel);
		
		//sound
		Label soundOnOffText = new Label("Sound:");
		soundOnOff = new Label("XXX");
		
		soundOnOffText.getAllStyles().setFgColor(ColorUtil.MAGENTA);
		myContainer.add(soundOnOffText);
		myContainer.add(soundOnOff);
		
		
		this.add(myContainer);
		
	}
	

}
