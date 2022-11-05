package main;
import java.util.ArrayList;

public class Team {
    //Data fields
    public String teamName;
    public ArrayList<String> membersNames;
    
    //Constructor
    Team(String teamName, ArrayList<String> membersNames){
        this.teamName = teamName;
        this.membersNames = membersNames;
    }
    
} //end of Team class
