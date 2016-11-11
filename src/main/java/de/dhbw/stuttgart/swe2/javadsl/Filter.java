package de.dhbw.stuttgart.swe2.javadsl;

public interface Filter<T> {
	
	boolean filter(T input);
	
}