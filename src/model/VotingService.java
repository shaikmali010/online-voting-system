package model;

public class VotingService {

	private DataStore data;
	
//	Constructor
	public VotingService(DataStore data) {
		this.data = data;
	}
	
//	Candidate List
	public void showCandidates() {
		System.out.println("\ncandidates: ");
		for(String c : data.votes.keySet()) {
			System.out.println("- "+c);
		}
	}
	
//	Votes
	public void vote(String username, String candidate) {
		
		if(data.votedStatus.get(username)) {
			System.out.println("Yor already voted!");
			return;
		}
		
		if(!data.votes.containsKey(candidate)) {
			System.out.println("Invalide candidate!");
			return;
		}
		
		data.votes.put(candidate, data.votes.getOrDefault(candidate, 0) + 1);
		data.votedStatus.put(username,  true);
		
		System.out.println("voted casted successfully!");
	}
	
//	Display the result
	public void showResult() {
		System.out.println("\n--- Results ---");
		
		String winner = "";
		int maxVotes = 0;
		
		for(String c : data.votes.keySet()) {
			int count = data.votes.get(c);
			System.out.println(c+" : "+count);
			
			if(count > maxVotes) {
				maxVotes = count;
				winner = c;
			}
		}
		
		System.out.println("Winner: "+winner);
	}
}
