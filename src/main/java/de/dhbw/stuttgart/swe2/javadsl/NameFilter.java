package de.dhbw.stuttgart.swe2.javadsl;

import de.dhbw.stuttgart.swe2.library.jpa.Staff;

public class NameFilter implements Filter<Staff>
{

	@Override
	public boolean filter(Staff input) {
		if(input.getFirstName().equals("Hanswurst"))
		{
			return true;
		}
		return false;
	}
	
}
