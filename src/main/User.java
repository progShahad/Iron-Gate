package main;
import java.util.*;
//import static main.Main.in;
//import static main.Main.users;

public class User extends Info{
    //Data fields
    public String username, nickName, major;
    private String password, email;
    public Date create;
    public Project[] projects;
    
    Scanner in = new Scanner(System.in);
//    public static int numUser = 0;
    
    //Constructor
//    User(){
//        
//    }
    User(String username, String nickName, String email, String major, String password){
        this.username = username;
        this.nickName = nickName;
        this.email = email;
        this.major = major;
        this.password = password;
        create = new Date();
//        numUser++;
    }
    //Accessors & Mutators
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    
    //Other methods
    public void editInformation(){
        System.out.println("Choose what to edit:\n"
                + "1. Username\n"
                + "2. Nickname\n"
                + "3. Major\n"
                + "4. Email\n"
                + "5. Password\n"
                + "6. All");
        byte edit = in.nextByte();
        
        switch(edit){
            case 1:
                System.out.println("New username: ");
                in.nextLine();
                username = in.nextLine();
                break;
            case 2:
                System.out.println("New nickname: ");
                in.nextLine();
                nickName = in.nextLine();
                break;
            case 3:
                System.out.println("New major: ");
                in.nextLine();
                major = in.nextLine();
                break;
            case 4:
                System.out.println("New email: ");
                setEmail(in.next());
                while( !email.contains("@") ){
                    System.out.print("Email must contain '@', enter again: ");
                    email = in.next();
                }
                break;
            case 5:
                System.out.println("New password: ");
                in.nextLine();
                setPassword(in.nextLine());
                Main.checkPass(password);
                break;
            case 6:
                System.out.println("New username: ");
                in.nextLine();
                username = in.nextLine();
                System.out.println("New nickname: ");
                nickName = in.nextLine();
                System.out.println("New major: ");
                major = in.nextLine();
                System.out.println("New email: ");
                setEmail(in.next());
                while( !email.contains("@") ){
                    System.out.print("Email must contain '@', enter again: ");
                    email = in.next();
                }
                System.out.println("New password: ");
                in.nextLine();
                setPassword(in.nextLine());
                
                while(!Main.checkPass(password)){
                    System.out.println("Invalid password, enter again: ");
                    setPassword(in.nextLine());
                }
                
                break;
        }
    }
    
    public void viewInfo(){
        byte change;
        String username, nickName, major, email;
        do{
            System.out.println("\n -- " + this.nickName + "\'s Information --");
            System.out.println("  Username: " + this.username);
            System.out.println("  Email: " + this.email);
            System.out.println("  Major: " + this.major);
            System.out.println("\n Change Information? 1. Yes  2. No");
            change = in.nextByte();

            if(change == 1){
                editInformation();
//                viewInfo();
            }
        }
        while(change == 1);
    } //end of viewInfo method
    
//    abstract void addTeam(String teamName, int number, ArrayList<String> members);
    
} //end of User class