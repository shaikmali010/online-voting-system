package model;
import java.util.*;

public class DataStore {

	public Map<String, String> users = new HashMap<>();
	public Map<String, String> aadhar = new HashMap<>();
	public Map<String, Boolean> votedStatus = new HashMap<>();
	public Map<String, Integer> votes = new HashMap<>();
	
	public DataStore() {

//		Initialize candidate
		votes.put("Prabhas", 0);
		votes.put("Ramcharan", 0);
		votes.put("Allu Arjun", 0);
		
		
	}
	
}
