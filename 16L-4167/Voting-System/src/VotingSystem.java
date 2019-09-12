import constituency.Constituency;
import person.Candidate;
import person.Person;
import person.Voter;

import java.util.Scanner;

public class VotingSystem {

    public static void main(String[] args) throws InterruptedException {

        ElectionCommission electionCommission=new ElectionCommission();
        Constituency constituency1=new Constituency(127);
        Constituency constituency2=new Constituency(128);
        Constituency constituency3=new Constituency(129);
        electionCommission.addConstituency(constituency1);
        electionCommission.addConstituency(constituency2);
        electionCommission.addConstituency(constituency3);
        Voter voter=new Voter("arsil","35201-23423423-32",constituency1,1,false);
        electionCommission.addCitizen(voter);
        voter=new Voter("iftikhar","35201-54534534-21",constituency2,2,false);
        electionCommission.addCitizen(voter);
        Candidate candidate=new Candidate("nawaz shareef","32424-2342342-32",constituency1,2,false,0,"car","PMLN",constituency1);
        electionCommission.addCandidate(candidate);
        candidate=new Candidate("imran khan","32424-23423890-32",constituency1,2,false,0,"bike","PTI",constituency1);
        electionCommission.addCandidate(candidate);
        System.out.println("give you identity as name to cast vote...");
        Scanner scanner=new Scanner(System.in);
        Voter voter1=electionCommission.getCitizen(scanner.nextLine());
        voter1.castVote();
        Thread.sleep(3000);
        electionCommission.setTime(6);
    }
}
