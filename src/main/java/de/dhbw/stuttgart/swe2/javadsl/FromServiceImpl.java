package de.dhbw.stuttgart.swe2.javadsl;

public class FromServiceImpl<T> implements FromService<T> {
	
	public static <T> FromService<T> from() {
		return new FromServiceImpl<T>();
	}

	public static <T> FromService<T> from(Class<T> c) {
		return new FromServiceImpl<T>();
	}
	
	@Override
	public <NextOutput> ManyService<T, NextOutput> join(ToMany<T, NextOutput> toMany) {
		return new SimpleManyServiceImpl<T, NextOutput>(toMany);
	}

	@Override
	public <NextOutput> ManyService<T, NextOutput> join(ManyService<T, NextOutput> manyService) {
		return new SimpleManyServiceImpl<T, NextOutput>(manyService);
	}

	@Override
	public <NextOutput> OneService<T, NextOutput> join(ToOne<T, NextOutput> toOne) {
		return new SimpleOneServiceImpl<T, NextOutput>(toOne);
	}

	@Override
	public <NextOutput> OneService<T, NextOutput> join(OneService<T, NextOutput> toOne) {
		return new SimpleOneServiceImpl<T, NextOutput>(toOne);
	}

}
