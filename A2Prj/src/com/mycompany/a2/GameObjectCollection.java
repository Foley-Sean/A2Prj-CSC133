package com.mycompany.a2;

import java.util.Vector;

public class GameObjectCollection implements ICollection {

	private Vector objectCollection;
	
	public GameObjectCollection() {
		objectCollection = new Vector();
	}
	@Override
	public void add(Object newObject) {
		// Adds an object to the game collection
		objectCollection.addElement(newObject);
	}

	@Override
	public void remove(Object newObject) {
		// Removes an object from the game collection
		objectCollection.removeElement(newObject);
	}

	@Override
	public IIterator getIterator() {
		// Gets the iterator from the interface
		return new GameObjectVectorIterator();
	}
	
	private class GameObjectVectorIterator implements IIterator{
		//this class is *heavily* inspired from the CSC133 Lecture Notes 
		
		private int elementIndex;
		
		public GameObjectVectorIterator() {
			elementIndex = -1;
		}
		
		@Override
		public boolean hasNext() {
			if (objectCollection.size() <= 0) {
				return false;	
			}
			if(elementIndex == objectCollection.size() -1 ) {
				return false;
			}
			return true;
		}
		
		@Override
		public Object getNext() {
			elementIndex ++;
			return(objectCollection.elementAt(elementIndex));
		}
		
	}
	
}
