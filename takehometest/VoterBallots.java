import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.List;
import java.util.HashSet;


public class VoterBallots{

       private Map<String,Integer> voteCount;
       // key is the candidate name, value is the
       // number of votes received by that candidate.

       // precondition: each entry in ballotList is a Set representing
       //               one voter's ballot.
       // postcondition: voteCount.get(candidate) is the total number of
       //                times candidate appears on ballots in ballotList.


    //1)
    public VoterBallots(List<Set<String>> ballotList){
	voteCount = new HashMap();
	for (Set x: ballotList){
	    for (Object candidate: x){
		String cand = (String) candidate;
		if (voteCount.containsKey(cand)){
		    Integer count = (Integer) voteCount.get(cand);
		    voteCount.put(cand, count + 1);
		}
		voteCount.put(cand, 1);
	    }
	}
    }



       // postcondition: returns the set containing the candidate(s)
       //                with the most votes

    //2)

    public Set<String> candidatesWithMost(){
	Set winners = new HashSet();
	Integer winVotes = maxVotes();
	Iterator itr = voteCount.keySet().iterator();
	while (itr.hasNext()){
	    Object cand = itr.next();
	    if ((Integer) voteCount.get(cand).equals(maxCount)){
		winners.add(cand);
	    }
	}
	return winners;
    }

    }

    /* 3) O(C) This is because the candidatesWithMost method will take as long as needed to call maxVotes (which is the time that it takes to iterate over all the CANDIDATES). Inserting canddiates into winners will be O(1) because winners is a HashSet.*/
