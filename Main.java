package main;
import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static User users[] = new User[100];
    
    public static void main(String[] args) {
        users[0] = new User("shahad", "Shahad", "shahad@gmail.com", "CS", "ss111");
        users[1] = new User("norah", "Norah", "norah@gmail.com", "CS", "nn111");
        
        byte sign, choice;
        int index = -1;
        
        System.out.println("\tWelcome to Iron Gate\n "
                + "About us....");
        System.out.println("1. Sign in\n2. Sign up");
        sign = in.nextByte();
        
        switch(sign){
            case 1:
                index = login();
                
                break;
            case 2:
                System.out.println("Fill in all the fields");
                signUp();
                
                break;
            default:
                System.out.println("Invalid choice");
        }
        
        System.out.println("1. Add new project\n2. Search for projects\n3. View profile");
        choice = in.nextByte();
        
        switch(choice){
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                viewInfo(index);
                break;
            default:
                System.out.println("Invalid choice");
        }
    } //end of main
    
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
        
        System.out.print("Password: ");
        in.nextLine();
        password = in.nextLine();
        
        System.out.print("Confirm password: ");
        confirmPass = in.nextLine();
        
        System.out.println(username + "\t" + nickName + "\t" + major + "\t" + email + "\t" + password + "\t" + confirmPass);
        
        while( !password.equals(confirmPass) ){
            System.out.println("Confirm password does not match password");
            System.out.print("Password: ");
            password = in.nextLine();
            System.out.print("Confirm password: ");
            confirmPass = in.nextLine();
        }
        users[User.numUser] = new User(username, nickName, email, major, password);
    } //end of signUp method
    
    public static int login(){
        String username, password, email, newPass;
        boolean login = false;
        int index = -1;
        byte forget;
        
        while(!login){
            System.out.print("Enter 1 if you forgot password: ");
            forget = in.nextByte();
            if(forget == 1){
                System.out.print("Enter the email: ");
                email = in.next();
                for(int i=0 ; i < User.numUser ; i++){
                    if(users[i].getEmail().equals(email)){
                        System.out.print("Enter new password: ");
                        in.nextLine();
                        newPass = in.nextLine();
                        users[i].setPassword(newPass);
                        break;
                    }
                }
            }
            else{
                System.out.print("Username: ");
                username = in.next();
                System.out.print("Password: ");
                in.nextLine();
                password = in.nextLine();
                
                for(int i=0 ; i < User.numUser ; i++){
                    if(users[i].username.equals(username) && users[i].getPassword().equals(password)){
                        login = true;
                        index = i;
                        break;
                    }
                }
                if(login){
                    System.out.println("Logged in successfully, welcome again " + users[index].nickName);
                    login = true;
                }
                else
                    System.out.println("Incorrect username/password");
            }
        }
        return index;
    } //end of login method
    
    public static void viewInfo(int index){
        byte change;
        String username, nickName, major, email;
        
        System.out.println(users[index].nickName + "'s Information");
        System.out.println("Username: " + users[index].username);
        System.out.println("Email: " + users[index].getEmail());
        System.out.println("Major: " + users[index].major);
        System.out.print("Change Information? 1. Yes  2. No");
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
    
} //end of Main class
