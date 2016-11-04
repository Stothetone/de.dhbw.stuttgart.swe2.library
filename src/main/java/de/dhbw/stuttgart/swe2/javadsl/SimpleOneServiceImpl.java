package de.dhbw.stuttgart.swe2.javadsl;

public class SimpleOneServiceImpl<Input, Output> extends SimpleManyServiceImpl<Input, Output>
		implements OneService<Input, Output> {

	private ToOne<Input, Output> toOne;

	SimpleOneServiceImpl(ToOne<Input, Output> toOne) {
		super(toOne);
		this.toOne = toOne;
	}

	@Override
	public <NextOutput> OneService<Input, NextOutput> map(ToOne<Output, NextOutput> toOne) {
		return new BridgingOneServiceImpl<Input, Output, NextOutput>(this, toOne);
	}

	@Override
	public Output getOne(Input input) {
		return toOne.getOne(input);
	}

	@Override
	public <NextOutput> OneService<Input, NextOutput> join(ToOne<Output, NextOutput> toMany) {
		return new BridgingOneServiceImpl<Input, Output, NextOutput>(this, toMany);
	}

	@Override
	public <NextOutput> OneService<Input, NextOutput> join(OneService<Output, NextOutput> oneService) {
		return new BridgingOneServiceImpl<Input, Output, NextOutput>(this, oneService);
	}

}
