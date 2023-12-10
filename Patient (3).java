/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloodbanksystem;

public class Patient{
    private String id;
    private String name;
    private String address;
    private String bloodType;
    private int ContactNo;
    static int Ncounter=0;
     Patient ( String id ,String name,String bloodType, String address , int ContactNo ) {
    this.id=id;
    this.name=name;
    this.bloodType=bloodType;
    this.address=address;
    this.ContactNo=ContactNo;
    
    Ncounter++;
    
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String BloodType) {
        this.bloodType = BloodType;
    }

    public int getContactNo() {
        return ContactNo;
    }

    public void setContactNo(int ContactNo) {
        this.ContactNo = ContactNo;
    }

    public static int getNcounter() {
        return Ncounter;
    }

    public static void setNcounter(int Ncounter) {
        Patient.Ncounter = Ncounter;
    }
    
    
} 
 