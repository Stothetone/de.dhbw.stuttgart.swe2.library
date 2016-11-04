package de.dhbw.stuttgart.swe2.javadsl;

import java.util.List;

public interface ToMany<Input, Output> {
	
	List<Output> get(Input input);

}
