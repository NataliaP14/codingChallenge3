package codingChallenge3;
import java.util.*;

public class VoteMain {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello! Please enter the amount of voters you would like to have: ");
		int numOfVoters = input.nextInt();
		
		//array for the names
		 String[] names = {"Alice", "Charlie", "Bob"};
		 //hashset to make sure only valid names can be entered
		 Set<String> validNames = new HashSet<>(Set.of(names));
		 
		 Map<String, Integer> pointsMap = new HashMap<>();
	        for (String name : validNames) {
	            pointsMap.put(name, 0);
	        }
		
	      //implementing logic to print the ranks a certain amount of times
		for (int i = 0; i < numOfVoters; i++) {
			System.out.println();
			for (int j = 0; j < 3; j++) {
			boolean validVote;

                do {
                	//prints Ranks 1 through 3 # amount of times and user can enter names
                    System.out.print("Rank " + (j + 1) + ": ");
                    String userInput = input.next();
                    validVote = validNames.contains(userInput);
                    //if not a valid name, prints error message and u can try again
                    if (validVote = false) {
                        System.out.println("Invalid name. Please enter a valid name: Alice, Charlie, or Bob");
                    } else {
                    	//method for assigning points to certain ranks
                    	int points = getPointsForRank(j + 1);
                        pointsMap.put(userInput, pointsMap.get(userInput) + points);
                    }
                } while (validVote = false);
			}
			
			
		}
		
		input.close();
		
		//method for determining the winner
		 String winner = findWinner(pointsMap);
	        System.out.println("\nWinner: " + winner);
	}

	    private static int getPointsForRank(int rank) {
	        switch (rank) {
	        //rank 1 gets 3 points
	            case 1:
	                return 3;
	        //rank 2 gets 2 points
	            case 2:
	                return 2;
	        //rank 3 gets 1 point
	            case 3:
	                return 1;
	            default:
	                return 0;
	        }
	    }

	    //method for determining winner
	    private static String findWinner(Map<String, Integer> pointsMap) {
	        int points = 0;
	        String winner = null;

	        for (Map.Entry<String, Integer> entry : pointsMap.entrySet()) {
	        	//if there is a int thats greater than the max points, it sets that string (the name) as the winner
	            if (entry.getValue() > points) {
	               points = entry.getValue();
	               winner = entry.getKey();
	            }
	        }

	        return winner;
	    }
	
	
}
