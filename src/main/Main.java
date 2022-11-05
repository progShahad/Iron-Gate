/*
CS 311 - Object Oriented Programming 1
Term Project: IRON GATE

By the programmers:
- Shahad AlQarni
- Norah Al Abeedah
- Nada Alali
- Muneera Aljalal
- Reem Almalki

Instructor: Ezaz Aldahasi

This program provides the service of uploading projects related to courses
*/

package main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static Scanner in = new Scanner(System.in);
    
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Project> projects = new ArrayList<>();
    static Course [] courses = new Course[6];
    static String[] languages = {"JAVA", "C++", "C", "C#", "PYTHON", "SQL", "HTML"};
    static ArrayList<Team> teams = new ArrayList<>();
    
    public static void main(String[] args) {
        home();
    } //end of main
    
    public static void home(){
        users.add( new User("shahad", "Shahad", "shahad@gmail.com", "CS", "Sshh1112") );
        users.add( new User("norah", "Norah", "norah@gmail.com", "CS", "Nn111234") );
        
        courses[0] = new Course("Introduction to computing", 4);
        courses[1] = new Course("Fundamentals of programming", 5);
        courses[2] = new Course("Object oriented programming1", 7);
        courses[3] = new Course("Object oriented programming2", 8);
        courses[4] = new Course("Data base", 9);
        courses[5] = new Course("Web based systems", 10);
        
        Team team;
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Shahad","Muneera", "Nada", "Norah", "Reem"));
        team = new Team("Geniuses", names);
        teams.add(team);
        
        projects.add(new Project("Iron Gate", "Code hosting platform that serves students at the university in all faculties of all specialties and levels.", "File", languages[0], (byte)2, team, courses[2], "norah@gmail.com"));
        projects.add(new Project("Delivery Service", "Providing delivery services for customers and employees.", "Text", languages[1], (byte)1, courses[1], "shahad@gmail.com"));
        
        users.get(0).projects.add(projects.get(0)); //add Iron Gate to the user (Shahad)
        users.get(1).projects.add(projects.get(0)); //add Iron Gate to the user (Norah)
        users.get(0).projects.add(projects.get(1)); //add Delivery Service to the user (Shahad)
        
        byte platform, choice;
        int index = -1;
        String suggestions = "", username, password;
        
        System.out.println("---------- Welcome to Iron Gate ----------");
        
        while(index < 0){ //while not signed in
            //home menu
            System.out.println("\n1- About us\n"
                            + "2- Contact us\n"
                            + "3- Suggestion\n"
                            + "4- Sign in\n"
                            + "5- Sing up\n"
                            + "0- Exit");
            platform = in.nextByte();
            switch(platform){
                case 1:
                   System.out.println("\n---------------- About Us ----------------\n\n"
                           + "Code hosting platform that serves students at the university\n"
                           + "in all faculties of all specialties and levels.\n"
                           + "The platform provides the service of raising projects\n"
                           + "related to courses or graduation projects.\n"
                           + "\n------------------------------------------");
                   break;

                case 2:
                    System.out.println("\n--------------- Contact Us ---------------\n"
                            + " Email: contact@Iron_gate.com\n"
                            + " Phone: 9200385\n"
                            + "------------------------------------------");
                    break;

                case 3:
                    System.out.println("\n--------- Write your Suggestions ---------");
                    in.nextLine();
                    suggestions += in.nextLine() + "\n";
                    System.out.println("\nThank you!\n"
                            + "------------------------------------------\n");
                    break;

                case 4: //sign in
                    System.out.print("\nUsername: ");
                    username = in.next();
                    System.out.print("Password: ");
                    in.nextLine();
                    password = in.nextLine();
                    index = sign(username, password);
                    System.out.println("\nLogged in successfully\n"
                                + "Welcome again, " + users.get(index).nickName
                                + "\n------------------------------------------");
                    break;

                case 5: //sign up
                    sign();

                    break;

                case 0: //exit the program
                    System.out.println("Thank you for visiting Iron Gate :)");
                    return;

                default:
                    System.out.println("xx  Invalid choice  xx");
            } //end of switch
        } //end of while
        
        do{ //after sign in
            System.out.println("\n1. Add new project\n"
                    + "2. Search for projects\n"
                    + "3. Edit your projects\n"
                    + "4. View profile\n"
                    + "0. Logout\n"
                    + "-1. Exit");
            choice = in.nextByte();

            switch(choice){
                case 1:
                    addProject(users.get(index));
                    break;

                case 2:
                    System.out.println("\nSearch by:\n1. level\n2. Programming language\n3. Course");
                    byte searchProject = in.nextByte();

                    while(searchProject > 3 || searchProject < 1){
                        System.out.println("\nChoose 1/2/3: ");
                        searchProject = in.nextByte();
                    }
                    if(searchProject == 1){ //by level
                        System.out.println("\nChoose the level:\n1. Simple\n2. Intermediate\n3. Advanced");
                        byte level = in.nextByte();
                        search(level);
                    }
                    else if(searchProject == 2){ //by language
                        System.out.println("\nEnter the language:\t");
                        String language = in.next();
                        while( !searchLanguage(language) ){
                            System.out.println("This language is not available, enter again:\t");
                            language = in.next();
                        }
                        search(language);
                    }
                    else{ //by course
                        System.out.println("\nEnter the course name: ");
                        in.nextLine();
                        String courseName = in.nextLine();
                        int courseIndex = searchCourse(courseName);
                        while( courseIndex < 0 ){
                            System.out.println("Enter again: ");
                            courseName = in.nextLine();
                            courseIndex = searchCourse(courseName);
                        }
                        search(courses[courseIndex]);
                    }

                    break;
                    
                case 3: //edit
                    System.out.println("------------- Your projects -------------");
                    if(users.get(index).projects.size() > 0){
                        for(int i=0 ; i < users.get(index).projects.size() ; i++)
                            System.out.println((i+1) + "- " + users.get(index).projects.get(i).title);
                        System.out.print("\nEnter the number of project to update: ");
                        int projectNum = in.nextInt();
                        users.get(index).projects.get(projectNum-1).editInformation();
                    }
                    else
                        System.out.print("\nYou do not have projects yet\n");
                    break;
                    
                case 4:
                    users.get(index).viewInfo();
                    break;
                    
                case 0: //logout - back to home menu
                     System.out.println("Logged out, bye bye " + users.get(index).nickName + "\n");
                     home();
                     return;

                case -1: //exit the program
                    System.out.println("Thank you for visiting Iron Gate :)");
                    return;

                default:
                    System.out.println("xx  Invalid choice  xx");
            }
        }
        while(choice != -1);
        
    } //end of home method
    
    public static int sign(String username, String password){ //sign in
        String user, pass, email, newPass, confirmPass;
        int index = -1;
        byte forget;
        boolean found = false;
        
        for(int i=0 ; i < users.size() ; i++)
            if(users.get(i).username.equalsIgnoreCase(username) && users.get(i).getPassword().equals(password)){
                index = i;
                break;
            }
        
        if(index < 0){
            System.out.println("Incorrect username/password");
            System.out.print("\nEnter 1 if you forgot password: ");
            forget = in.nextByte();
            if(forget == 1){
                while(!found){
                    System.out.print("\nEnter the email: "); //to reset the password
                    email = in.next();
                    for(int i=0 ; i < users.size() ; i++){
                        if(users.get(i).getEmail().equalsIgnoreCase(email)){ //search for the given email
                            found = true;
                            System.out.print("Enter new password: ");
                            in.nextLine();
                            newPass = in.nextLine();
                            while( !checkPass(newPass) ){ //check the new password before reset
                                System.out.print("\nInvalid password\nPlease enter again: ");
                                newPass = in.nextLine();
                            }
                            
                            System.out.print("Confirm password: ");
                            confirmPass = in.nextLine();
                            while( !newPass.equals(confirmPass) ){
                                System.out.println("Confirm password does not match password\n");
                                System.out.print("Confirm password: ");
                                confirmPass = in.nextLine();
                            }
                            users.get(i).setPassword(newPass);
                            index = i;
                            break;
                        }
                    }
                    if(!found)
                        System.out.print("Email is not found\n");
                }
            }
            else{
                System.out.print("Username: ");
                user = in.next();
                System.out.print("Password: ");
                in.nextLine();
                pass = in.nextLine();
                return sign(user, pass);
            }
        } //end of outer if-else
        
        return index;
    } //end of sign method
    
    public static void sign(){ //sign up
        String username, nickName, major, email, password, confirmPass;
        
        System.out.println("--------- Fill in all the fields ---------");
        System.out.print("Username: ");
        username = in.next();
        
        System.out.print("Nick name: ");
        in.nextLine();
        nickName = in.nextLine();
        
        System.out.print("Major: ");
        major = in.nextLine();
        
        System.out.print("Email: ");
        email = validEmail(in.next()); //to store a valid email
        
        System.out.print("Password: ");
        in.nextLine();
        password = in.nextLine();
        
        while( !checkPass(password) ){
            System.out.print("Invalid password\nPlease enter again: ");
            password = in.nextLine();
        }
          
        System.out.print("Confirm password: ");
        confirmPass = in.nextLine();
        
        while( !password.equals(confirmPass) ){
            System.out.println("Confirm password does not match password\n");
            System.out.print("Confirm password: ");
            confirmPass = in.nextLine();
        }
        
        System.out.println("\n------------ Your Information ------------\n"
                + "Username: " + username
                + "\nNick name: " + nickName
                + "\nMajor: " + major
                + "\nEmail: " + email
                );
        
        users.add( new User(username, nickName, email, major, password) );
        System.out.println("\nSigned up successfully..\nWe are glad you joined us, " + nickName
                            + "\n------------------------------------------");
    } //end of sign method
    
    public static boolean checkPass(String password){ //this method checks the validation of password
        if ( password.length() < 8 )
            return false;
        // count the number of digits
        int digits = 0;
        for (int i=0 ; i < password.length() ; i++){
            if ( Character.isDigit(password.charAt(i)) )
                digits++;
            if ( digits >= 2 )
                return true;
        }
        return false;
    } //end of checkPass method
    
    public static String validEmail(String email){ //this method checks the email validation
        while( !email.contains("@") ){
            System.out.print("Email must contain '@', enter again: ");
            email = in.next();
        }
        return email;
    } //end of validEmail method
    
    public static void addProject(User currentUser){ //this method adds a new project
        String title, description, prog_language, uploadMethod, courseName, contactInfo;
        Team team;
        byte confirm, addTeam, level;
        int courseIndex, existingTeams = 0;
        
        System.out.println("\n------- Fill in the required fields -------");
        System.out.print("\nTitle: ");
        in.nextLine();
        title = in.nextLine();
        
        System.out.println("\nDescribe your project:");
        description = in.nextLine();
        
        System.out.print("\nProgramming language: ");
        prog_language = in.next();
        if( !searchLanguage(prog_language) ) //if the given language is not available, the project cannot be added
            return;
        
        System.out.print("\nLevel:\n"
                + "1. Simple\n"
                + "2. Intermediate\n"
                + "3. Advanced\n");
        level = in.nextByte();
        
        while(level < 1 || level > 3){
            System.out.print("Enter one of three levels: ");
            level = in.nextByte();
        }
        
        do{
            System.out.print("\nCourse name: ");
            in.nextLine();
            courseName = in.nextLine();
            courseIndex = searchCourse(courseName);
            if( courseIndex < 0 ){
                System.out.print("Enter 1 to stop search: ");
                if(in.nextInt() == 1)
                    break;
            }
        }
        while(courseIndex < 0);
        
        System.out.print("\nSelect the upload method:\n"
                + "1. Text\t"
                + "2. File\t"
                + "3. Image\n");
        uploadMethod = in.next();
        
        System.out.print("\nEnter 1 to add team members: ");
        addTeam = in.nextByte();
        
        if(addTeam == 1){
             System.out.println("\nThe existing teams:");
            for(int i=0 ; i < teams.size() ; i++) //display the teams that the user is member of
                if(teams.get(i).membersNames.contains(currentUser.nickName)){
                    System.out.println((i+1) + "- " + teams.get(i).teamName);
                    existingTeams++;
                }
            
                if(existingTeams == 0){
                    System.out.println("No teams.");
                    team = addTeam();
                }
                else{
                    System.out.println("\nIf your team is existing, enter the number of it, else enter 0:");
                    int teamNum = in.nextInt();
                    if(teamNum > 0)
                        team = teams.get(teamNum-1);
                    else
                        team = addTeam();
                }
        } //end of outer if
        else
            team = null;
        
        System.out.println("\nContact information: ");
        in.nextLine();
        contactInfo = in.nextLine();
        
        System.out.print("\nEnter any number to confirm the project: ");
        confirm = in.nextByte();
        
        prog_language = prog_language.toUpperCase();
        
        if(team == null)
            projects.add( new Project(title, description, uploadMethod, prog_language, level, courses[courseIndex], contactInfo) );
        else
            projects.add( new Project(title, description, uploadMethod, prog_language, level, team, courses[courseIndex], contactInfo) );
        
        projects.get(projects.size()-1).viewInfo();
        currentUser.projects.add(projects.get(projects.size()-1));
        
        System.out.println("\n----------- Added Successfully -----------");
    } //end of addProject method
    
    public static boolean searchLanguage(String language){ //this method checks if the given language is available
        boolean found = false;
        for(String val : languages){
            if(language.equalsIgnoreCase(val)){
                found = true;
                break;
            }
        }
        if(!found)
            System.out.println("Sorry, this language is not supported by Iron Gate");
        return found;
    } //end of searchLanguage method
    
    public static int searchCourse(String courseName){ //this method checks if the given course is available
        int index = -1;
        byte answer;
        //modify lettercase
        courseName = courseName.toLowerCase();
        courseName = courseName.replaceFirst(courseName.charAt(0)+"", Character.toUpperCase(courseName.charAt(0))+"");
        
        for(int i=0 ; i < courses.length ; i++){
            if( courses[i].name.equals(courseName) ){
                index = i;
                break;
            }
            else if( courses[i].name.matches(courseName + ".*") ){
                System.out.print("Do you mean " + courses[i].name + " ? 1.Yes  ");
                answer = in.nextByte();
                in.nextLine();
                if(answer == 1){
                    index = i;
                    break;
                }
            }
        }
        if(index < 0)
            System.out.println("Sorry, this course is not available");
        return index;
    }
    
    public static Team addTeam(){ //this method adds a new team
        String name;
        ArrayList<String> members = new ArrayList<>();
        Team team;
        System.out.println("Enter the members names, type '-' if you have done");
        in.nextLine();
        name = in.nextLine();
        while(!name.equals("-")){
            members.add(name);
            name = in.nextLine();
        }
        System.out.println("Enter the team name: ");
        name = in.nextLine();
        
        team = new Team(name, members);
        return team;
    } //end of addTeam method
    
    public static void search(byte level){ //search for projects by level
        int results = 0;
        System.out.println("\n----- Results -----");
        for(int i=0 ; i < projects.size() ; i++){
            if(projects.get(i).level == level){
                results++;
                System.out.print((i+1) + "- " + projects.get(i).title + ", ");
                if(projects.get(i).level == 1)
                    System.out.print("Simple");
                else if(projects.get(i).level == 2)
                    System.out.print("Intermediate");
                else
                    System.out.print("Advanced");
                System.out.println(", " + projects.get(i).prog_language);
            }
        }
        System.out.println(results + " results.\n");
        if(results > 0)
            expand();
    } //end of search method
    
    public static void search(String language){ //search for projects by programming language
        int results = 0;
        System.out.println("\n----- Results -----");
        for(int i=0 ; i < projects.size() ; i++){
                if(projects.get(i).prog_language.equalsIgnoreCase(language)){
                    results++;
                    System.out.print((i+1) + "- " + projects.get(i).title + ", ");
                    if(projects.get(i).level == 1)
                        System.out.print("Simple");
                    else if(projects.get(i).level == 2)
                        System.out.print("Intermediate");
                    else
                        System.out.print("Advanced");
                    System.out.println(", " + projects.get(i).prog_language);
                }
        }
        System.out.println(results + " results.\n");
        if(results > 0)
            expand();
    } //end of search method
    
    public static void search(Course course){ //search for projects by course
        int results = 0;
        System.out.println("\n----- Results -----");
        for(int i=0 ; i < projects.size() ; i++){
            if(projects.get(i).course.equals(course)){
                results++;
                System.out.println((i+1) + "- " + projects.get(i).title + ", "
                        + projects.get(i).level + ", "
                        + projects.get(i).prog_language + ", "
                        + projects.get(i).course.name);
            }
        }
        System.out.println(results + " results.\n");
        if(results > 0)
            expand();
    } //end of search method
    
    public static void expand(){ //this method displays the selected project information
        System.out.println("Enter the number of project to be expanded, 0 to exit:");
        int projectNum = in.nextInt();
        while(projectNum != 0){
            projects.get(projectNum-1).viewInfo();
            System.out.println("\nEnter 1 to like this project\n0 to dislike\nother number to skip:");
            byte feedback = in.nextByte();
            if(feedback == 1)
                projects.get(projectNum-1).likes++;
            else if(feedback == 0)
                projects.get(projectNum-1).dislikes++;
            
            System.out.print("\nEnter 1 to write a comment: ");
            feedback = in.nextByte();
            if(feedback == 1){
                System.out.println("----------- Write your comment -----------");
                in.nextLine();
                projects.get(projectNum-1).comments += in.nextLine() + "\n------------------------------------------\n";
                System.out.println("Thank you for your feedback"
                        + "\n------------------------------------------");
            }
            
            System.out.print("\nEnter the number of project to be expanded, 0 to exit: ");
            projectNum = in.nextInt();
        }
    } //end of expand method
    
} //end of Main class
