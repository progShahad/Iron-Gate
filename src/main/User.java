package main;
import java.util.Scanner;
import java.util.ArrayList;

public class User extends Info{
    //Data fields
    public String username, nickName, major;
    private String password, email;
    public ArrayList<Project> projects;
    
    Scanner in = new Scanner(System.in);
    
    //Constructor
    User(String username, String nickName, String email, String major, String password){
        this.username = username;
        this.nickName = nickName;
        this.email = email;
        this.major = major;
        this.password = password;
        projects = new ArrayList<>();
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
    @Override
    public void viewInfo(){ //display the user information
        byte change;
        do{
            System.out.println("\n ------- " + this.nickName + "\'s Information -------");
            System.out.println("  Username: " + this.username);
            System.out.println("  Email: " + this.email);
            System.out.println("  Major: " + this.major);
            System.out.println("\nChange Information? 1. Yes  2. No");
            change = in.nextByte();

            if(change == 1){
                editInformation();
            }
        }
        while(change == 1);
        
        System.out.println("------------------------------------------");
    } //end of viewInfo method
    
    @Override
    public void editInformation(){ //edit the user information
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
                System.out.print("New username: ");
                in.nextLine();
                username = in.nextLine();
                break;
            case 2:
                System.out.print("New nickname: ");
                in.nextLine();
                nickName = in.nextLine();
                break;
            case 3:
                System.out.print("New major: ");
                in.nextLine();
                major = in.nextLine();
                break;
            case 4:
                System.out.print("New email: ");
                setEmail(in.next());
                email = Main.validEmail(email);
                break;
            case 5:
                System.out.print("New password: ");
                in.nextLine();
                setPassword(in.nextLine());
                while( !Main.checkPass(password) ){
                    System.out.print("Invalid password, enter again: ");
                    setPassword(in.nextLine());
                }
                break;
            case 6:
                System.out.print("New username: ");
                in.nextLine();
                username = in.nextLine();
                
                System.out.print("New nickname: ");
                nickName = in.nextLine();
                
                System.out.print("New major: ");
                major = in.nextLine();
                
                System.out.print("New email: ");
                setEmail(in.next());
                email = Main.validEmail(email);
                
                System.out.print("New password: ");
                in.nextLine();
                setPassword(in.nextLine());
                
                while( !Main.checkPass(password) ){
                    System.out.print("Invalid password, enter again: ");
                    setPassword(in.nextLine());
                }
                
                break;
        }
        System.out.println("\n ---------------- Updated ----------------");
    } //end of editInformation method
    
} //end of User class
