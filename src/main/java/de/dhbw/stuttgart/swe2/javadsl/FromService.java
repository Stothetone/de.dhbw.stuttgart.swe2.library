package de.dhbw.stuttgart.swe2.javadsl;

public interface FromService<T> {
	
	<NextOutput> ManyService<T, NextOutput> join(ToMany<T, NextOutput> toMany);
	
	<NextOutput> ManyService<T, NextOutput> join(ManyService<T, NextOutput> manyService);

	<NextOutput> OneService<T, NextOutput> join(ToOne<T, NextOutput> toMany);
	
	<NextOutput> OneService<T, NextOutput> join(OneService<T, NextOutput> manyService);


}
