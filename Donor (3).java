/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloodbanksystem;
public class Donor extends User {
   private int age;
   public String bloodType;
   public int ContactNo;
   
   
    
    public Donor(String username, String password) {
        super(username, password);
       
    }
    public Donor(String id, String name, String address, int age, int contactNo) {
        super(id, name, address);
        this.age = age;
        this.ContactNo = contactNo;
    }
    
   

    public void donorOperation() {
        System.out.println("Donor operation performed.");
        
        
    }
    
    
    
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    
    public int getContactNo(){
        return ContactNo;
    }
    
    public void setContactNo(int ContactNo){
    this.ContactNo=ContactNo;
    }
    
    
    public void setBloodType(String bloodType){
         this.bloodType=bloodType;
    }
   
    
    public String getBloodType(){
        return bloodType;
    }
    
     
    public void donate(String bloodType){
        
            setBloodType(bloodType);
            System.out.println("Donor donate successfully.");
            
        }
         
        
    
    public void displayDonorInfo() {
        System.out.println("Donor Information:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Age: " + age);
        System.out.println("Contact Number: " + ContactNo);
    }
            

        

}