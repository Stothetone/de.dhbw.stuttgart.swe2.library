package de.dhbw.stuttgart.swe2.javadsl;

import java.util.Collections;
import java.util.List;

public abstract class AbstractToOne<Input, Output> implements ToOne<Input, Output> {
	
	@Override
	public List<Output> get(Input input) {
		return Collections.singletonList(getOne(input));
	}

}
