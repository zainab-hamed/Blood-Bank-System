/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloodbanksystem;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
   
    public Admin(String username, String password) {
        super(username, password);
    }

    public void adminOperation() {
        System.out.println("Admin operation performed.");
    }
    
    
  public void deleteAccount(List<User> users, String username) {
     for(User user : users ){
            if(user.getUsername().equals(username)){
                users.remove(user);
            System.out.println("Donor deleted");
            return;
            
        }
            
    }
        System.out.println("User not found. ");
}

    
    
    
}


    
    


