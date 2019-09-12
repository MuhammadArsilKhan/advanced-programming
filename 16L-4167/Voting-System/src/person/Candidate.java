package person;

import constituency.Constituency;

public class Candidate extends Person {
    int votesCasted;

    String symbol;

    String party;

    Constituency constituency;

    public Candidate(String name, String idNumber, Constituency constituency, int message, boolean bool, int votesCasted,String symbol,String party,Constituency constituency1) {
        super(name,idNumber,constituency,message,bool);
        this.votesCasted=votesCasted;
        this.party=party;
        this.symbol=symbol;
        this.constituency=constituency1;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        party = party;
    }

    public int getVotesCasted() {
        return votesCasted;
    }

    public void setVotesCasted() {
        this.votesCasted++;
    }

    public void printInfo() {
        System.out.println("name : "+this.getName());
        System.out.println("party : "+this.getParty());
        System.out.println("symbol : "+this.getSymbol());

    }

    public Constituency getElectionConstituency()
    {
        return this.constituency;
    }
}
