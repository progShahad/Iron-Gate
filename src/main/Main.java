package main;
import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Project> projects = new ArrayList<>();
    static Course [] courses = new Course[6];
    static String[] languages = {"JAVA", "C++", "C", "C#", "PYTHON", "SQL", "HTML"};
    
    public static void main(String[] args) {
        home();
    } //end of main
    
    public static boolean checkPass(String password){
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
    
    public static void sign(){
        String username, nickName, major, email, password, confirmPass;
        
        System.out.print("Username: ");
        username = in.next();
        
        System.out.print("Nick name: ");
        in.nextLine();
        nickName = in.nextLine();
        
        System.out.print("Major: ");
        major = in.nextLine();
        
        System.out.print("Email: ");
        email = in.next();
        
        while( !email.contains("@") ){
            System.out.print("Email must contain '@', enter again: ");
            email = in.next();
        }
        
        System.out.print("Password: ");
        in.nextLine();
        password = in.nextLine();
        
        while( !checkPass(password) ){
            System.out.println("Invalid password\nPlease enter password again..");
            password = in.nextLine();
        }
          
        System.out.print("Confirm password: ");
        confirmPass = in.nextLine();
        
        while( !password.equals(confirmPass) ){
            System.out.println("Confirm password does not match password");
            System.out.print("Password: ");
            password = in.nextLine();
            System.out.print("Confirm password: ");
            confirmPass = in.nextLine();
        }
        
        System.out.println(username + "\n" + nickName + "\n" + major + "\n" + email);
        
        users.add( new User(username, nickName, email, major, password) );
        System.out.println("Signed up successfully..\nWe are glad you joined us");
    } //end of sign method
    
    public static int sign(String username, String password){ //sign in
        String user, pass, email, newPass;
        int index = -1;
        byte forget;
        
        for(int i=0 ; i < users.size() ; i++)
            if(users.get(i).username.equalsIgnoreCase(username) && users.get(i).getPassword().equals(password)){
                index = i;
                break;
            }
        if(index >= 0){
            System.out.println(" Logged in successfully, welcome again " + users.get(index).nickName);
        }
        else{
            System.out.println("Incorrect username/password");
            System.out.print("Enter 1 if you forgot password: ");
            forget = in.nextByte();
            if(forget == 1){
                System.out.print("Enter the email: ");
                email = in.next();
                for(int i=0 ; i < users.size() ; i++)
                    if(users.get(i).getEmail().equalsIgnoreCase(email)){
                        System.out.print("Enter new password: ");
                        in.nextLine();
                        newPass = in.nextLine();
                        users.get(i).setPassword(newPass);
                        break;
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
    
    public static int searchCourse(String courseName){
        int index = -1;
        byte answer;
        courseName = courseName.toLowerCase();
        courseName = courseName.replace(courseName.charAt(0), Character.toUpperCase(courseName.charAt(0)));
        
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
    
    public static void addProject(){
        String title, description, prog_language, uploadMethod, name="", courseName;
        Team team;
        ArrayList<String> members = new ArrayList<>();
        byte confirm, addTeam, level;
        int courseIndex;
        
        System.out.println("Fill the required fields");
        System.out.print("Title: ");
        in.nextLine();
        title = in.nextLine();
        
        System.out.print("Describe you project: ");
        description = in.nextLine();
        
        System.out.print("Programming language: ");
        prog_language = in.next();
        if( !searchLanguage(prog_language) )
            return;
        
        System.out.print("Level:\n"
                + "1. Simple\n"
                + "2. Intermediate\n"
                + "3. Advanced\n");
        level = in.nextByte();
        
        while(level < 1 || level > 3){
            System.out.print("Enter one of three levels: ");
            level = in.nextByte();
        }
        
        do{
            System.out.print("Course name: ");
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
        
        System.out.print("Enter 1 to add team members: ");
        addTeam = in.nextByte();
        
        if(addTeam == 1){
            System.out.println("Enter the members names, type '-' if you have done\n");
            in.nextLine();
            name = in.nextLine();
            while(!name.equals("-")){
                members.add(name);
                name = in.nextLine();
            }
            System.out.println("Enter the team name: ");
            name = in.nextLine();
            
            team = new Team(name, members.size(), members);
        }
        else
            team = null;
        
        System.out.print("\nEnter 1 to confirm the project: ");
        confirm = in.nextByte();
        
        if(team == null)
            projects.add( new Project(title, description, uploadMethod, prog_language, level, courses[courseIndex]) );
        else
            projects.add( new Project(title, description, uploadMethod, prog_language, level, team, courses[courseIndex]) );
        
        projects.get(projects.size()-1).viewInfo();
        
        System.out.println("\n--- Added Successfully ---");
    } //end of addProject method
    
    public static boolean searchLanguage(String language){
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
    
    public static void expand(){
        System.out.println("\nEnter the number of project to be expanded, 0 to exit: ");
        int projectNum = in.nextInt();
        while(projectNum != 0){
            projects.get(projectNum-1).viewInfo();
            System.out.print("\nEnter 1 to like this project, 0 to dislike, other number to skip: ");
            byte feedback = in.nextByte();
            if(feedback == 1)
                projects.get(projectNum-1).likes++;
            else if(feedback == 0)
                projects.get(projectNum-1).dislikes++;
            
            System.out.print("Enter 1 to write a comment: ");
            feedback = in.nextByte();
            if(feedback == 1){
                System.out.println("Write your comment:");
                in.nextLine();
                projects.get(projectNum-1).comments += in.nextLine() + "\n------------------------------------------\n";;
                System.out.println("Thank you for your feedback");
            }
            
            System.out.print("Enter the number of project to be expanded, 0 to exit: ");
            projectNum = in.nextInt();
        }
    } //end of expand method
    
    public static void search(byte level){ //by level
        int results = 0;
        System.out.println("\n--- Results ---");
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
    
    public static void search(String language){ //by language
        int results = 0;
        System.out.println("\n--- Results ---");
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
    
    public static void search(Course course){ //by course
        int results = 0;
        System.out.println("\n--- Results ---");
        for(int i=0 ; i < projects.size() ; i++){
            if(projects.get(i).course.equals(course)){
                results++;
                System.out.println((i+1) + "- " + projects.get(i).title + ", " + projects.get(i).level + ", " + projects.get(i).prog_language + ", " + projects.get(i).course.name);
            }
        }
        System.out.println(results + " results.\n");
        if(results > 0)
            expand();
    } //end of search method
    
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
        team = new Team("Geniuses", 5, names);
        projects.add(new Project("Iron Gate", "Code hosting platform that serves students at the university in all faculties of all specialties and levels.", "File", "Java", (byte)2, team, courses[2]));
        
        byte platform, choice;
        int index = -1;
        String suggestions, username, password;
        
        System.out.println("------ Welcome to Iron Gate ------");
        
        while(index < 0){
            System.out.println("\n1- About us\n"
                            + "2- Contact us\n"
                            + "3- Suggestion\n"
                            + "4- Sign in\n"
                            + "5- Sing up\n"
                            + "0- Exit");
            platform = in.nextByte();
            switch(platform){
                case 1:
                   System.out.println("Code hosting platform that serves students at the university in all faculties of all specialties and levels.\nThe platform provides the service of raising projects related to courses or graduation projects.");
                   break;

                case 2:
                    System.out.println("\n Email: contact@Iron_gate.com\n"
                            + " Phone: 9200385");
                    break;

                case 3:
                    System.out.println("\nWrite your Suggestions:");
                    in.nextLine();
                    suggestions = in.nextLine();
                    System.out.println("Thank you!");
                    break;

                case 4:
                    System.out.print("\nUsername: ");
                    username = in.next();
                    System.out.print("Password: ");
                    in.nextLine();
                    password = in.nextLine();
                    index = sign(username, password);
                    break;

                case 5:
                    System.out.println("Fill in all the fields");
                    sign();

                    break;

                case 0:
                    System.out.println("Thank you for visiting Iron Gate :)");
                    return;

                default:
                    System.out.println("Invalid choice");
            } //end of switch
        } //end of while
        
        do{
            System.out.println("\n1. Add new project\n"
                    + "2. Search for projects\n"
                    + "3. View profile\n"
                    + "0. Logout\n"
                    + "-1. Exit");
            choice = in.nextByte();

            switch(choice){
                case 1:
                    addProject();
                    break;

                case 2:
                    System.out.println("Search by:\n1. level\n2. Programming language\n3. Course");
                    byte searchProject = in.nextByte();

                    while(searchProject > 3 || searchProject < 1){
                        System.out.println("\nChoose 1/2/3: ");
                        searchProject = in.nextByte();
                    }
                    if(searchProject == 1){ //level
                        System.out.println("Choose the level:\n1. Simple\n2. Intermediate\n3. Advanced");
                        byte level = in.nextByte();
                        search(level);
                    }
                    else if(searchProject == 2){ //language
                        System.out.println("Enter the language:\t");
                        String language = in.next();
                        while( !searchLanguage(language) ){
                            System.out.println("This language is not available, enter again:\t");
                            language = in.next();
                        }
                        search(language);
                    }
                    else{ //course
                        System.out.println("Enter the course name: ");
                        in.nextLine();
                        String courseName = in.nextLine();
                        int courseIndex = searchCourse(courseName);
                        while( courseIndex < 0 ){
                            System.out.println("Enter again: ");
//                            in.nextLine();
                            courseName = in.nextLine();
                            courseIndex = searchCourse(courseName);
                        }
                        search(courses[courseIndex]);
                    }

                    break;
                case 3:
                    users.get(index).viewInfo();
                    break;

                case 0:
                     System.out.println("Logged out\n");
                     home();
                     return;

                case -1:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
        while(choice != -1);
        
    } //end of home method

} //end of Main class