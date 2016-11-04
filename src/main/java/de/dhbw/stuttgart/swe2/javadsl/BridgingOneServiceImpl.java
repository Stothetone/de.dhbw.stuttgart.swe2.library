package de.dhbw.stuttgart.swe2.javadsl;

public class BridgingOneServiceImpl<Input, Bridged, Output> extends BridgingManyServiceImpl<Input, Bridged, Output>
		implements OneService<Input, Output> {

	private OneService<Input, Bridged> first2;
	private ToOne<Bridged, Output> second2;

	public BridgingOneServiceImpl(OneService<Input, Bridged> first, ToOne<Bridged, Output> second) {
		super(first, second);
		first2 = first;
		second2 = second;
	}

	public BridgingOneServiceImpl(OneService<Input, Bridged> first, OneService<Bridged, Output> second) {
		super(first, second);
	}

	@Override
	public <NextOutput> OneService<Input, NextOutput> map(ToOne<Output, NextOutput> toOne) {
		return new BridgingOneServiceImpl<Input, Output, NextOutput>(this, toOne);
	}

	@Override
	public Output getOne(Input input) {
		Bridged one = first2.getOne(input);
		return second2.getOne(one);
	}


	@Override
	public <NextOutput> OneService<Input, NextOutput> join(ToOne<Output, NextOutput> toOne) {
		return new BridgingOneServiceImpl<Input, Output, NextOutput>(this, toOne);
	}


	@Override
	public <NextOutput> OneService<Input, NextOutput> join(OneService<Output, NextOutput> toOne) {
		return new BridgingOneServiceImpl<Input, Output, NextOutput>(this, toOne);
	}

}
