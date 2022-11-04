package main;
import java.util.ArrayList;

public class Team {
    //Data fields
    public String teamName;
    public int numberOfMembers;
    public ArrayList<String> membersNames;
    
    //Constructor
    Team(){
        
    }
    Team(String teamName, int numberOfMembers, ArrayList<String> membersNames){
        this.teamName = teamName;
        this.numberOfMembers = numberOfMembers;
        this.membersNames = membersNames;
    }
    //Other methods
    
} //end of Team class