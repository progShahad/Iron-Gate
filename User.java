package main;
import java.util.*;

public class User {
    //Data fields
    public String username, nickName, major;
    private String password, email;
    public Date create;
    public Project[] projects;
    public static int numUser = 0;
    
    //Constructor
    User(String username, String nickName, String email, String major, String password){
        this.username = username;
        this.nickName = nickName;
        this.email = email;
        this.major = major;
        this.password = password;
        create = new Date();
        numUser++;
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
    public void editInformation(String username, String nickName, String email, String major){
        this.username = username;
        this.nickName = nickName;
        this.email = email;
        this.major = major;
    }
    
} //end of User class
