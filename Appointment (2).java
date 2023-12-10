/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloodbanksystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Appointment {
    
  
   private static List<String> appointmentDates = new ArrayList<>();

    
 private static Scanner scanner = new Scanner(System.in);

    public void appointment() {
        int choice;
      
        do {
 
            System.out.println("1. Add appointment date\n2. Display appointment dates\n0. Quit");
            System.out.println("Enter your operation number: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addAppointment();
                    break;
                case 2:
                    displayAppointmentDates();
                    break;
                case 0:
                    System.out.println("Exiting appointment menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void addAppointment() {
       
        System.out.println("Enter appointment date (e.g., DD/MM/YYYY): ");
         scanner.nextLine();
        String date=scanner.nextLine().trim();
        
   
        appointmentDates.add(date);
        System.out.println("Appointment date added successfully.");
    }

    private static void displayAppointmentDates() {
       
        if (appointmentDates.isEmpty()) {
            System.out.println("No appointment dates available.");
        } else {
            System.out.println("Appointment Dates:");
            for (String appointmentDate : appointmentDates) {
                System.out.println(appointmentDate);
            }
        }
    }

    
    
       public static List<String> getAvailableDates() {
        return new ArrayList<>(appointmentDates);
    }

    public static boolean isValidAppointmentDate(String selectedDate) {
        return appointmentDates.contains(selectedDate);
    }
 
   

    public static void selectDonationDate() {
      
         displayAppointmentDates();

        System.out.println("Enter the date you want to donate (DD/MM/YYYY): ");
        String selectedDate = scanner.nextLine();

        if (isValidAppointmentDate(selectedDate)) {
            System.out.println("You have selected " + selectedDate + " date for donation.");

        } else {
            System.out.println("Invalid date. Please choose a valid date.");
        }
    }
  
    }
