package de.dhbw.stuttgart.swe2.javadsl;

import java.util.ArrayList;
import java.util.List;

public class BridgingManyServiceImpl<Input, Bridged, Output> implements ManyService<Input, Output> {

	private ManyService<Input, Bridged> first;
	private ManyService<Bridged, Output> second;

	public BridgingManyServiceImpl(ManyService<Input, Bridged> first, ManyService<Bridged, Output> second) {
		this.first = first;
		this.second = second;
	}

	public BridgingManyServiceImpl(ManyService<Input, Bridged> first, ToMany<Bridged, Output> second) {
		this.first = first;
		this.second = new SimpleManyServiceImpl<Bridged, Output>(second);
	}

	@Override
	public <NextOutput> ManyService<Input, NextOutput> join(ManyService<Output, NextOutput> toMany) {
		return new BridgingManyServiceImpl<Input, Output, NextOutput>(this, toMany);
	}

	@Override
	public <NextOutput> ManyService<Input, NextOutput> join(ToMany<Output, NextOutput> toMany) {
		return new BridgingManyServiceImpl<Input, Output, NextOutput>(this, toMany);
	}

	@Override
	public List<Output> get(Input input) {
		List<Output> output = new ArrayList<Output>();
		List<Bridged> list = first.get(input);
		for (Bridged bridged : list) {
			
			if(!bridged.equals(null))
			{
				output.addAll(second.get(bridged));
			}
		}
		return output;
	}

}
