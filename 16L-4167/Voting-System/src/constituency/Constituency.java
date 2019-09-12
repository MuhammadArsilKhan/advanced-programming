package constituency;

import person.Candidate;
import person.Person;
import person.Voter;

import java.util.ArrayList;
import java.util.List;

public class Constituency {
    int constituencyNumber;

    List<Candidate> candidates;

    List<Person> voters;

    public Constituency(int constituencyNumber)
    {
        this.constituencyNumber=0;
        candidates=new ArrayList<>();
        voters=new ArrayList<>();
    }

    public int getConstituencyNumber() {
        return constituencyNumber;
    }

    public void setConstituencyNumber(int constituencyNumber) {
        this.constituencyNumber = constituencyNumber;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void addCandidates(Candidate candidate) {
        this.candidates.add(candidate);
    }

    public List<Person> getVoters() {
        return voters;
    }

    public void addVoters(Person voter) {
        this.voters.add(voter);
    }

    public Candidate getWinningCandidate() {
        int winner=0;
        for(int i=0;i<candidates.size();i++)
        {
            if(candidates.get(winner).getVotesCasted()<candidates.get(i).getVotesCasted())
            {
                winner=i;
            }
        }
        return candidates.get(winner);
    }
}
