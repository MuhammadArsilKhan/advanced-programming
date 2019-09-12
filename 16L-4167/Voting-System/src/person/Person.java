package person;

import constituency.Constituency;
import message.Email;
import message.Message;
import message.SMS;

import java.util.List;
import java.util.Scanner;

public abstract class Person {

    String name;

    String idNumber;

    Constituency constituency;

    Message message;

    boolean voteCasted;

    public Person(String name,String idNumber,Constituency constituency, int message, boolean bool) {
           this.name=name;
           this.idNumber=idNumber;
           this.constituency=constituency;
           if(message==1)
           {
               this.message=new Email();
           }
           else
           {
               this.message=new SMS();
           }
           this.voteCasted=bool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Constituency getConstituency() {
        return constituency;
    }

    public void setConstituency(Constituency constituency) {
        this.constituency = constituency;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public boolean isVoteCasted() {
        return voteCasted;
    }

    public void setVoteCasted(boolean voteCasted) {
        this.voteCasted = voteCasted;
    }

    public boolean castVote() {
        if(!isVoteCasted())
        {
            System.out.println("select the candidate you want to cast the vote");
            List<Candidate> candidateList=constituency.getCandidates();
            for(int i=0;i<candidateList.size();i++)
            {
                System.out.println("press "+(i+1)+" for");
                candidateList.get(i).printInfo();
                System.out.println(" ");
                System.out.println("  ");
            }
            Scanner scanner=new Scanner(System.in);
            int option=scanner.nextInt();
            candidateList.get(option-1).setVotesCasted();
            this.setVoteCasted(true);
            System.out.println("your have casted the vote...thank you for contributing in making our nation great...");
            System.out.println("you will recieve a notification when polling ends...");
            return true;
        }
        return false;
    }

    public void notification() {
        message.sendMessage();
    }

}
