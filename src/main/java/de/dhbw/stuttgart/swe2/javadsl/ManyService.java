package de.dhbw.stuttgart.swe2.javadsl;

public interface ManyService<Input, Output> extends ToMany<Input, Output> {
	
	<NextOutput> ManyService<Input, NextOutput> join(ToMany<Output, NextOutput> toMany);
	
	<NextOutput> ManyService<Input, NextOutput> join(ManyService<Output, NextOutput> manyService);
	
	ManyService<Input, Output> filter(Filter<Output> filter);
	
//	<NextOutput> OneService<Input, NextOutput> reduce(ToOne<Output, NextOutput> toOne);


}
