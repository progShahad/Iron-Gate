package main;
import java.util.Scanner;
import java.util.Date;

public class Project extends Info {
    //Data fields
    public String title, description, comments, uploadMethod, prog_language, contactInfo;
    public Team team;
    public int likes, dislikes;
    public byte level;
    public Course course;
    public Date create;
    
    Scanner in = new Scanner(System.in);
    
    //Constructors
    
    //team project
    Project(String title, String description, String uploadMethod, String prog_language, byte level, Team team, Course course, String contactInfo){
        this(title, description, uploadMethod, prog_language, level, course, contactInfo);
        this.team = team;
    }
    //individual project
    Project(String title, String description, String uploadMethod, String prog_language, byte level, Course course, String contactInfo){
        this.title = title;
        this.description = description;
        this.uploadMethod = uploadMethod;
        this.prog_language = prog_language;
        this.level = level;
        this.course = course;
        this.contactInfo = contactInfo;
        likes = 0;
        dislikes = 0;
        comments = "";
        create = new Date();
    }
    
    //Other methods
    @Override
    public void viewInfo(){ //this method displays the project information
        System.out.println("\n----------- Project Information -----------\n"
                + "\nTitle: " + title
                + "\nDescription: " + description
                + "\nProgramming language: " + prog_language
                + "\nProject level: " + level
                + "\nCourse name: " + course.name
                + "\nCourse level: " + course.level
                + "\nLikes: " + likes
                + "\nDislikes: " + dislikes
                + "\nDate of upload: " + create);
        if(team != null)
                System.out.println("Team name: " + team.teamName + " " + team.membersNames);
        
        System.out.println("Contact information: " + contactInfo);
        
        System.out.print("\nEnter 1 to view the comments of projects: ");
        if(in.nextInt() == 1){
            if(comments == "")
                System.out.println("No comments on this project\n");
            else
                System.out.println(comments);
        }
    } //end of viewInfo method
    
    @Override
    public void editInformation(){ //edit the project information
        Scanner in = new Scanner(System.in);
        System.out.println("\nChoose what to edit:\n"
                + "1. Title\n"
                + "2. Description\n"
                + "3. Level\n"
                + "4. Contact Information\n"
                + "5. All");
        byte edit = in.nextByte();
        
        switch(edit){
            case 1:
                System.out.print("New title: ");
                in.nextLine();
                title = in.nextLine();
                break;
            case 2:
                System.out.println("New description: ");
                in.nextLine();
                description = in.nextLine();
                break;
            case 3:
                System.out.print("New level: ");
                level = in.nextByte();
                break;
            case 4:
                System.out.println("New contact information:");
                in.nextLine();
                contactInfo = in.nextLine();
                break;
            case 5:
                System.out.print("New title: ");
                in.nextLine();
                title = in.nextLine();
                System.out.println("New description: ");
                description = in.nextLine();
                System.out.print("New level: ");
                level = in.nextByte();
                System.out.println("New contact information:");
                in.nextLine();
                contactInfo = in.nextLine();
                break;
        }
        System.out.println("\n ---------------- Updated ----------------");
    } //end of editInformation method
    
} //end of Project class
