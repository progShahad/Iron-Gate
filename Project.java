package main;
import java.util.ArrayList;

public class Project extends Course {
    //Data fields
    public String title, description, comments, uploadMethod, project_language;
    ArrayList <String> team;
    public int likes;
    public byte level;
    
    //Constructors
    Project(){
        team = new ArrayList<>();
        likes = 0;
    }
    Project(String title, String description, String uploadMethod, String project_language, byte level, ArrayList<String> team){
        this.title = title;
        this.description = description;
        this.uploadMethod = uploadMethod;
        this.project_language = project_language;
        this.level = level;
        this.team = team;
    }
    //Other methods
    
} //end of Project class
