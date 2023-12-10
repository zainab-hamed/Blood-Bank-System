/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bloodbanksystem;

import java.util.Scanner;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author huda-
 */
 public class BloodBankSystem {
    
   static Patient [] patients ;
   static Scanner scanner= new Scanner (System.in);
   static List<User> users = new ArrayList<>();

 static Appointment appointmentDates = new Appointment();
    
   private static User getUserName(String username){
         for(User user: users){
             if(user.getUsername().equals(username))
                 return user;
         }
         return null;
     } 
     


     public static void mainMenu(){
        System.out.println("""
              \t           1.Admin     2.Donor     3.hospital    
                            """);
    }
     
     
    public static void main(String[] args) {
        patients=new Patient[100];
        int choice;
        // Adding the admin user
        Admin adminUser = new Admin("Admin", "Admin1");//creat object 
        users.add( adminUser);
        
        Hospital hospitalUser = new Hospital("Hospital", "Hospital0");
        users.add(hospitalUser);
//        Hospital hospitalInfo=new Hosptial()

              
           System.out.println("\t\t***Welcome To our Blood Bank System*** \n ");
           do{
            
            mainMenu();
            System.out.println("Choose an option:");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    donorOptions();
                    break;
                    
                case 3:
                    hospitalLogin();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
           
        }
         while(choice!=0);
    }
    
    
    
     //overloadin
      private static void System(Admin admin){
        int choice;
         System.out.println("\t*****Admin System*****");
        do{
            System.out.println("1.Delete donor\n"+"2.Add patient \n"+"3.update patient information \n"+"4.display patients \n"+"5.delete patient\n"+"0 to quit ");
            System.out.println("Enter your operation number: ");
            choice=scanner.nextInt();
            
            
            switch(choice){
                case 1: 
                    System.out.println("Enter donor username to delete ");
                    String usernameTodelete=scanner.next();
                    admin.deleteAccount(users, usernameTodelete);
                     break;
                     
                case 2: 
                    
                    addPatient();
                     break;
                case 3:
                    updatePatient();
                    break;
                    
                case 4:
                    displayPatient();
                    break;
                     
                case 5:
                    deletePatient();
                    break;
                     
                case 0: 
                    System.out.println("Admin logout");
            }
                    
        }
        
        
        
        while (choice!=0);
    }

    private static void adminLogin() {
        
        String enteredUsername =JOptionPane.showInputDialog("Admin Login\n"+ "Enter admin username: ");
        String enteredPassword =JOptionPane.showInputDialog("Enter admin password: ");

        User user=getUserName(enteredUsername); //creat object


        if (user instanceof Admin && user.authenticate(enteredUsername, enteredPassword)) {
            Admin admin =(Admin)user;
            System.out.println("Admin Login successful!");
            System(admin);
            
        } else {
            System.out.println("Admin Login failed. Invalid credentials.");
        }
    }
////////////////// Admin operation end////////////////////////////
    
    //overloadin
    private static void System(Donor donor){
        System.out.println("\t*****Donor System*****");
        int choice;
        scanner.nextLine();
        
        do{
            System.out.println("1.Update informatiom\n"+"2.Display account\n"+"3.Dontate\n"+"4. Donation appointment\n"+"0 to quit ");
            System.out.println("Enter your operation number: ");
            choice=scanner.nextInt();
            
            switch(choice){
          
            case 1: 
              
              updateDonorInfo();
                break;
        
            case 2: 
                donorDisplayInfo();
                break;
            case 3: 
                char choice1;
                String donorBloodType;
               
               if(donor.getAge()>= 18){ 
                System.out.println("Do you have chronic diseases or anemia? "+ "press y or n ");
                choice1=scanner.next().charAt(0);
               if(choice1 == 'n'|| choice1 == 'N' ){
                
                      System.out.println("Enter your  blood type: [A+,A-,B+,B-,AB+,AB-,O+,O-]");
                      donorBloodType=scanner.next();
                      donor.donate(donorBloodType);
                      scanner.nextLine();
                      appointmentDates.selectDonationDate();
                }
               
               else if (choice1 == 'y' || choice1==  'Y')
                   System.out.println("Sorry, you can't donate");
               
               else 
                   System.out.println("Invalid choice. ");
                   
               }
               else 
                   System.out.println("Sorry, you must be 18 years or over to donate ");
                  break;
            
            
            }} while(choice!=0);}
   
        

    private static void donorLogin() {

        String enteredUsername =JOptionPane.showInputDialog("Donor Login\n"+ "Enter username: ");

        String enteredPassword =JOptionPane.showInputDialog("Enter password: ");

        User user = getUserName(enteredUsername);

        if (user != null && user.authenticate(enteredUsername, enteredPassword)) {
        // Successful login
        if (user instanceof Donor) {
            Donor donor = (Donor) user;
            System(donor);
        } else {
            System.out.println("Invalid user type.");
        }
    } else {
        System.out.println("Invalid credentials or user not found.");}}
    

   
    
    private static void donorRegistration() {

          String newUsername  =JOptionPane.showInputDialog( "Enter username: ");
          String newPassword =JOptionPane.showInputDialog("Enter password: ");
        
          while (isUsernameTakenBefore(newUsername)) {
        System.out.println("Username already taken. Please choose a different one.");
        newUsername = JOptionPane.showInputDialog("Enter username: ");
    }

        Donor newUser = new Donor(newUsername, newPassword);
  
               
               System.out.println("\tEnter donor information:");
    
               System.out.println("Enter your id");
               String donorId = scanner.next();
   
               System.out.println("Enter your name");
               String donorName = scanner.next();
             
   
               System.out.println("Enter your address ");
               String donorAddress = scanner.next();
    
               System.out.println("Enter your age");
               int donorAge = scanner.nextInt();
               
               System.out.println("Enter your phone number");
               int donorContactNo = scanner.nextInt();

    
               newUser.setId(donorId);
   
               newUser.setName(donorName);
   
               newUser.setAddress(donorAddress);
  
               newUser.setAge(donorAge);
 
               newUser.setContactNo(donorContactNo);

  
               users.add(newUser);//add to the array

     
               System.out.println("Donor registration successful!");
    }
   
    
    
    private static void donorOptions() {
       
        System.out.println("Choose an option:");
        System.out.println("1. Login");
        System.out.println("2. Create New Account");

       
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

     
        switch (choice) {
            
            case 1:
                donorLogin();
                break;
                
            case 2:
                donorRegistration();
              

                donorLogin();
                
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    
    private static void donorDisplayInfo() {
   
         scanner.nextLine(); 
    
         System.out.print("Enter donor username to display information: ");
         String usernameToDisplay = scanner.nextLine().trim();

   
         User user = getUserName(usernameToDisplay);

   
         if (user instanceof Donor) {
             Donor donor = (Donor) user;
             donor.displayDonorInfo();}
    
         else {
        System.out.println("Invalid username or not a donor."); }}
     
      private static void updateDonorInfo() {
    scanner.nextLine(); 

    System.out.print("Enter donor ID to update information: ");
    String donorIdToUpdate = scanner.next();
    scanner.nextLine(); // Consume the newline

    boolean found = false;
    for (User user : users) {
        if (user instanceof Donor && ((Donor) user).getId().equals (donorIdToUpdate)) {
            found = true;
            Donor donor = (Donor) user;

            System.out.println("Enter new donor name:");
            String newName = scanner.nextLine();

            System.out.println("Enter new donor address:");
            String newAddress = scanner.nextLine();

            System.out.println("Enter new donor age:");
            int newAge = scanner.nextInt();

            System.out.println("Enter new donor phone number:");
            int newContactN = scanner.nextInt();

            donor.setName(newName);
            donor.setAddress(newAddress);
            donor.setAge(newAge);
            donor.setContactNo(newContactN);

            System.out.println("Donor information updated successfully.");
            break;
        }
    }

    if (!found) {
        System.out.println("Donor not found.");
    }
}
    private static boolean isUsernameTakenBefore(String username) {
            for (User user : users) {
                 if (user.getUsername().equals(username)) {
                  return true;
                }
         }
                  return false;}
    
  
      
/////////////////////Donor operation end/////////////////////////////////////////
    
      
    private static void System(){
        int choice;
        System.out.println("\t*****HOSPITSL SYSTEM*****");
       
do{
       System.out.println("1.Add patient\n"+"2.Update patient information\n"+"3.Display patients\n"+"4.Delete patient\n"+"5.Add appointments dates\n"+"0 to quit");
       System.out.println("Enter your operation number: ");
         choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addPatient();
                break;
            case 2:
                updatePatient();
                break;
            case 3:
                displayPatient();
                break;
            case 4:
                deletePatient();
                break;
            case 5:
                appointmentDates.appointment();
                break;
            case 0:
                System.out.println("Hospital logout");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }}
     while (choice != 0);}
   

        
    
    
    private static void hospitalLogin(){
        String enteredUsername =JOptionPane.showInputDialog("Hospital Login\n"+ "Enter username: ");
        String enteredPassword =JOptionPane.showInputDialog("Enter password: ");
          
          User user=getUserName(enteredUsername);
        
        if (user instanceof Hospital && user.authenticate(enteredUsername, enteredPassword)) {
            System.out.println("Hospital Login successful!");
             
           
            System();
            
        } else {
            System.out.println("Hospital Login failed. Invalid credentials.");
        }
    }
    
 
    private static void addPatient(){
       
        int patientContactNo;
        String ptatientId , patientName, patientAddress;
        String patientBloodType;
       
        scanner.nextLine();
      
        System.out.println("\t Add patient");
        
        System.out.println("Enter patient's id: ");
        ptatientId=scanner.next();
        
        System.out.println("Enter patient's name: ");
        patientName=scanner.next();
      
        System.out.println("Enter patient's blood type ");
        patientBloodType=scanner.next();
       
        System.out.println("Enter patient's address: ");
        patientAddress=scanner.next();
       
        System.out.println("Enter patient's phone number: ");
        patientContactNo=scanner.nextInt();
           
        patients [Patient.Ncounter]= new Patient(ptatientId, patientName,patientBloodType , patientAddress,patientContactNo ); 
          }
    private static void displayPatient() {
   
        System.out.println("\n--- Displaying Patients ---");
           if (Patient.Ncounter == 0) {
            System.out.println("No patients in the system.");
            return;
    }

    System.out.println("ID\tName\tBlood Type\tAddress\tContact No");
    for (int i = 0; i < Patient.Ncounter; i++) {
        Patient patient = patients[i];
        System.out.println(
            patient.getId() + "\t" +
            patient.getName() + "\t" +
            patient.getBloodType() + "\t" +
            patient.getAddress() + "\t\t" +
            patient.getContactNo()
           
        );
        System.out.println("--------------------------------------");
    }
}
    
     private static void updatePatient() {
        
    System.out.println("Enter patient's ID to update:");
    String patientIdToUpdate = scanner.next();
    scanner.nextLine(); 

    
    for (int i = 0; i < Patient.Ncounter; i++) {
        if (patients[i].getId().equals( patientIdToUpdate)) {
            
            System.out.println("Enter new patient's name:");
            String patientName = scanner.nextLine();

            System.out.println("Enter new patient's address:");
            String patientAddress = scanner.nextLine();

            System.out.println("Enter new patient's blood type:");
            String patientBloodType = scanner.next();

            System.out.println("Enter new patient's phone number:");
            int patientContactNo = scanner.nextInt();

            
            patients[i].setName(patientName);
            patients[i].setAddress(patientAddress);
            patients[i].setBloodType(patientBloodType);
            patients[i].setContactNo(patientContactNo);

            System.out.println("Patient information updated successfully.");
            return;
        }
    }}
    
    private static void deletePatient(){
        System.out.println("Enter patient's ID to delete:");
        String patientIdToUpdate = scanner.next();
         scanner.nextLine(); 

    
    for (int i = 0; i < Patient.Ncounter; i++) {
        if (patients[i].getId().equals( patientIdToUpdate))
            patients[i]=patients[i+1]; }
         Patient.Ncounter--;
         System.out.println("Paitent has been deleted successfully! ");
    }
    

   
    
 }
     


