package de.dhbw.stuttgart.swe2.javadsl;

import java.util.List;

public class SimpleManyServiceImpl<Input, Output> implements ManyService<Input, Output> {

	public static <Input, Output> ManyService<Input, Output> from(ToMany<Input, Output> toMany) {
		return new SimpleManyServiceImpl<Input, Output>(toMany);
	}

	private ToMany<Input, Output> toMany;

	SimpleManyServiceImpl(ToMany<Input, Output> toMany) {
		this.toMany = toMany;
	}

	@Override
	public List<Output> get(Input input) {
		return toMany.get(input);
	}

	@Override
	public <NextOutput> ManyService<Input, NextOutput> join(ManyService<Output, NextOutput> toMany) {
		return new BridgingManyServiceImpl<Input, Output, NextOutput>(this, toMany);
	}

	@Override
	public <NextOutput> ManyService<Input, NextOutput> join(ToMany<Output, NextOutput> toMany) {
		return new BridgingManyServiceImpl<Input, Output, NextOutput>(this, toMany);
	}

}
