package main;

import java.util.Scanner;

public class Project extends Info {
    //Data fields
    public String title, description, comments, uploadMethod, prog_language;
    Team team;
    public int likes, dislikes;
    public byte level;
    Course course;
    Scanner in = new Scanner(System.in);
    
    //Constructors
//    Project(){
//        likes = 0;
//        dislikes = 0;
//    }
//    Project(String username, String nickName, String email, String major, String password){
//        super(username, nickName, email, major, password);
//    }
    Project(String title, String description, String uploadMethod, String project_language, byte level, Team team, Course course){
        this(title, description, uploadMethod, project_language, level, course);
        this.team = team;
    }
    
    Project(String title, String description, String uploadMethod, String project_language, byte level, Course course){
        this.title = title;
        this.description = description;
        this.uploadMethod = uploadMethod;
        this.prog_language = project_language;
        this.level = level;
        this.course = course;
        likes = 0;
        dislikes = 0;
        comments = "";
    }
    
    //Other methods
//    @Override
//    void addTeam(String teamName, int number, ArrayList<String> members){
//        team = new Team(teamName, number, members);
//    }
    
    @Override
    public void viewInfo(){
        System.out.println("\n--- Project Information ---"
                + "\nTitle: " + title
                + "\nDescription: " + description
                + "\nProgramming language: " + prog_language
                + "\nLevel: " + level
                + "\nCourse name: " + course.name
                + "\nCourse level: " + course.level
                + "\nLikes: " + likes
                + "\nDislikes: " + dislikes);
        if(team != null)
                System.out.println("Team name: " + team.teamName + " " + team.membersNames);
        
        System.out.print("\nEnter 1 to view the comments of projects: ");
        if(in.nextInt() == 1){
            if(comments == "")
                System.out.println("No comments on this project\n");
            else
                System.out.println(comments);
        }
    }
    
    public void editInformation(){
        Scanner in = new Scanner(System.in);
        System.out.println("Choose what to edit:\n"
                + "1. Title\n"
                + "2. Description\\n"
                + "3. Level\n"
                + "4. All");
        byte edit = in.nextByte();
        
        switch(edit){
            case 1:
                System.out.println("New title: ");
                in.nextLine();
                title = in.nextLine();
                break;
            case 2:
                System.out.println("New description: ");
                in.nextLine();
                description = in.nextLine();
                break;
            case 3:
                System.out.println("New level: ");
                level = in.nextByte();
                break;
            case 4:
                System.out.println("New title: ");
                in.nextLine();
                title = in.nextLine();
                System.out.println("New description: ");
                description = in.nextLine();
                System.out.println("New level: ");
                level = in.nextByte();
                break;
        }
        
        
    }
    
    
} //end of Project class