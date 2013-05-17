package model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;

public class Scores extends Observable {
	
	private static Scores instance;
	
	private Map<String, Integer> scores;
	
	private Scores() {
		scores = new HashMap<String, Integer>();
	}
	
	public void setScore(String player, int score) {
		scores.put(player, score);
		setChanged();
		notifyObservers();
	}
	
	public Map<String, Integer> getScores() {
		TreeMap<String, Integer> map = new TreeMap<String, Integer>(new ValueComparator(scores));
		return map;
	}
	
	public static Scores getInstance() {
		if (instance == null) {
			instance = new Scores();
		}
		return instance;
	}
	
	private class ValueComparator implements Comparator<String> {

		private Map<String, Integer> map;
		
		public ValueComparator(Map<String, Integer> map) {
			this.map = map;
		}
		
		@Override
		public int compare(String arg0, String arg1) {
			Integer i1 = map.get(arg0);
			Integer i2 = map.get(arg1);
			return i1.compareTo(i2);
		}
		
	}

}
