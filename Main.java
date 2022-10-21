package main;
import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static User users[] = new User[100];
    static String[] languages = {"Java", "C++", "Python"};
    
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
    
    public static void signUp(){
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
            System.out.print("Invalid email, enter again: ");
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
        
        users[User.numUser] = new User(username, nickName, email, major, password);
        System.out.println("Signed in successfully..\nWe are glad you joined us");
    } //end of signUp method
    
    public static int login(){
        String username, password, email, newPass;
        boolean login = false;
        int index = -1;
        byte forget;
        
        do{
            System.out.print("\nUsername: ");
            username = in.next();
            System.out.print("Password: ");
            in.nextLine();
            password = in.nextLine();
            
            for(int i=0 ; i < User.numUser ; i++)
                if(users[i].username.equalsIgnoreCase(username) && users[i].getPassword().equals(password)){
                    login = true;
                    index = i;
                    break;
                }
            
            
            if(login){
                System.out.println(" Logged in successfully, welcome again " + users[index].nickName);
                login = true;
            }
            else{
                System.out.println("Incorrect username/password");
                System.out.print("Enter 1 if you forgot password: ");
                forget = in.nextByte();
                if(forget == 1){
                    System.out.print("Enter the email: ");
                    email = in.next();
                    for(int i=0 ; i < User.numUser ; i++)
                        if(users[i].getEmail().equalsIgnoreCase(email)){
                            System.out.print("Enter new password: ");
                            in.nextLine();
                            newPass = in.nextLine();
                            users[i].setPassword(newPass);
                            break;
                        }
                }
            } //end of outer if-else
        }
        while(!login);
        
        return index;
    } //end of login method
    
    public static void viewInfo(int index){
        byte change;
        String username, nickName, major, email;
        
        System.out.println("\n -- " + users[index].nickName + "\'s Information --");
        System.out.println("  Username: " + users[index].username);
        System.out.println("  Email: " + users[index].getEmail());
        System.out.println("  Major: " + users[index].major);
        System.out.print("\n Change Information? 1. Yes  2. No");
        change = in.nextByte();
        
        if(change == 1){
            System.out.println("Enter new information");
            System.out.print("Username: ");
            username = in.next();
            System.out.print("Nick name: ");
            in.nextLine();
            nickName = in.nextLine();
            System.out.print("Major: ");
            major = in.nextLine();
            System.out.print("Email: ");
            email = in.next();
            users[index].editInformation(username, nickName, email, major);
            viewInfo(index);
        }
    } //end of viewInfo method
    
    public static void addProject(){
        Project project;
        String title, description, prog_language, uploadMethod, member="";
        ArrayList <String> team = new ArrayList<>();
        boolean found = false;
        byte confirm, addTeam, level;
        
        System.out.println("Fill the required fields");
        System.out.print("Title: ");
        in.nextLine();
        title = in.nextLine();
        
        System.out.print("Describe you project: ");
        description = in.nextLine();
        
        System.out.print("Programming language: ");
        prog_language = in.next();
        
        System.out.print("Level:\n"
                + "1. Simple\n"
                + "2. Intermediate\n"
                + "3. Advanced\n");
        level = in.nextByte();
        
        while(level < 1 || level > 3){
            System.out.print("Enter one of three levels: ");
            level = in.nextByte();
        }
        
        for(String val : languages){
            if(prog_language.equalsIgnoreCase(val)){
                found = true;
                break;
            }
        }
        if(!found)
            System.out.println("Sorry, this language is not supported by Iron Gate");
        
        System.out.print("Select the upload method:\n"
                + "1. Text\t"
                + "2. File\t"
                + "3. Image\n");
        uploadMethod = in.next();
        
        System.out.print("Enter 1 to add team members: ");
        addTeam = in.nextByte();
        
        if(addTeam == 1){
            System.out.println("Enter the members names, type '-' if you have done\n");
            while(!member.equals("-")){
                in.nextLine();
                member = in.nextLine();
                team.add(member);
            }
        }
        
        System.out.println("Project Information:"
                + "\nTitle: " + title
                + "\nDescription: " + description
                + "\nProgramming language: " + prog_language
                + "\nLevel: " + level
                + "\nTeam: " + team
        );
        
        System.out.print("\nEnter 1 to confirm the project: ");
        confirm = in.nextByte();
        
        project = new Project(title, description, uploadMethod, prog_language, level, team);
        
        System.out.println("Added Successfully");
    } //end of addProject method
    
    public static void home(){
        users[0] = new User("shahad", "Shahad", "shahad@gmail.com", "CS", "ss111");
        users[1] = new User("norah", "Norah", "norah@gmail.com", "CS", "nn111");
        
        byte platform, choice;
        int index = -1;
        String suggestions;
        
        System.out.println("------Welcome to Iron Gate\n");
        System.out.println("1- About us\n"
                + "2- Contact us\n"
                + "3- Suggestion\n"
                + "4- Sign in\n"
                + "5- Sing up\n"
                + "0- Exit\n");
        platform = in.nextByte();
        
        switch(platform){
            case 1:
               System.out.println("code hosting platform that serves students at the university in all faculties of all specialties and levels. The platform provides the service of raising projects related to courses or graduation projects.");
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
                index = login();
                break;
                
            case 5:
                System.out.println("Fill in all the fields");
                signUp();
                
                break;
                
            case 0:
                System.out.println("Thank you for visiting Iron Gate :)");
                return;
                
            default:
                System.out.println("Invalid choice");
        }
        
        System.out.println("\n1. Add new project\n"
                + "2. Search for projects\n"
                + "3. View profile\n"
                + "0. Logout");
        choice = in.nextByte();
        
        switch(choice){
            case 1:
                addProject();
                break;
                
            case 2:
                
                break;
            case 3:
                viewInfo(index);
                break;
                
            case 0:
                 System.out.println("Logged out");
                 home();
                break;
                
            default:
                System.out.println("Invalid choice");
        }
        
    } //end of home method

} //end of Main class
