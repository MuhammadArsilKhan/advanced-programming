import constituency.Constituency;
import person.Candidate;
import person.Person;
import person.Voter;

import java.util.ArrayList;
import java.util.List;

public class ElectionCommission {
    List<Voter> citizens;
    boolean votingOn;
    List<Constituency> constituencies;

    public ElectionCommission() {
        constituencies=new ArrayList<>();
        votingOn=true;
        citizens=new ArrayList<>();
    }

    public boolean isVotingOn() {
        return votingOn;
    }

    public void setVotingOn(boolean votingOn) {
        this.votingOn = votingOn;
    }

    public void setTime(int time) {
        if(time==6)
        {
            System.out.println("sending notifications to all citizens about the termination of polling..");
            notifyAllCitizens();
        }
    }

    private void notifyAllCitizens() {
        for (Person persons : citizens) {
            System.out.println("sending to "+persons.getName()+"...");
            persons.notification();
        }
    }

    public void addCitizen(Voter citizen) {
        this.citizens.add(citizen);
        int i=0;
        for(i=0;i<constituencies.size();i++)
        {
            if(constituencies.get(i).getConstituencyNumber()==citizen.getConstituency().getConstituencyNumber())
            {
                constituencies.get(i).addVoters(citizen);
                break;
            }
        }
    }

    public void addConstituency(Constituency constituency) {
        this.constituencies.add(constituency);
    }

    public void addCandidate(Candidate candidate) {
        for(int i=0;i<constituencies.size();i++)
        {
            if(constituencies.get(i).getConstituencyNumber()==candidate.getElectionConstituency().getConstituencyNumber())
            {
                constituencies.get(i).addCandidates(candidate);
            }
            break;
        }
    }

    public Voter getCitizen(String name) {
        for(int i=0;i<citizens.size();i++)
        {
            if(citizens.get(i).getName().equalsIgnoreCase(name))
            {
                return citizens.get(i);
            }
        }
        return null;
    }


}
