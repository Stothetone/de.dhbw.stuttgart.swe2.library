package de.dhbw.stuttgart.swe2.javadsl;

public interface OneService<Input, Output> extends ManyService<Input, Output>, ToOne<Input, Output>{
	
	<NextOutput> OneService<Input, NextOutput> map(ToOne<Output, NextOutput> toOne);
	
	<NextOutput> OneService<Input, NextOutput> join(ToOne<Output, NextOutput> toMany);
	
	<NextOutput> OneService<Input, NextOutput> join(OneService<Output, NextOutput> manyService);
	
	Output getOne(Input input);
	

}
