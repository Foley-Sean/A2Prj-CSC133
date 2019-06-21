package com.mycompany.a2;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld {
	//This class acts a mediator between the actual GameWorld class and the viewers
	//Only the getters are allowed to be used
	
	private GameWorld gw;
	
	public GameWorldProxy(GameWorld gw) {
		this.gw = gw;
	}

	@Override
	public int getScore() {
		
		return gw.getScore();
	}

	@Override
	public int getTime() {
		
		return gw.getTime();
	}

	@Override
	public int getLives() {
	
		return gw.getLives();
	}

	@Override
	public boolean getSound() {
	
		return gw.getSound();
	}

	@Override
	public String whatSound() {
	
		return gw.whatSound();
	}

	@Override
	public int getMissileCount() {
	
		return gw.getMissileCount();
	}

	@Override
	public double getWidth() {
	
		return gw.getWidth();
	}

	@Override
	public double getLength() {
	
		return gw.getLength();
	}


	
	
	
	
}
