package de.dhbw.stuttgart.swe2.library.jpa;

import java.util.List;

public class Title extends AbstractIdentifiable {
	
	private String name;
	private float duration;
	private List<CompactDisc> compactDiscs;
	private List<Artist> artists;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getDuration() {
		return duration;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
	public List<CompactDisc> getCompactDiscs() {
		return compactDiscs;
	}
	public void setCompactDiscs(List<CompactDisc> compactDiscs) {
		this.compactDiscs = compactDiscs;
	}
	public List<Artist> getArtists() {
		return artists;
	}
	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}


}
