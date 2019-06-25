package com.mycompany.a2;

public interface ICollection {
	IIterator getIterator();
	void add(Object newObject);
	void remove(Object newObject);
}
