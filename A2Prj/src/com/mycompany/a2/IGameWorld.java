package com.mycompany.a2;

public interface IGameWorld {

	//interface that specifies all necessary GameWorld public methods
	int getScore();
	int getTime();
	int getLives();
	boolean getSound();
	String whatSound();
	int getMissileCount();
	double getWidth();
	double getLength();
	IIterator getIterator();
}
