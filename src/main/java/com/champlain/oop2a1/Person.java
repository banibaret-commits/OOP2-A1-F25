package com.champlain.oop2a1;
import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * Represents a person with a name, date of birth, and email address.
 * It also tracks if the person has a parking pass.
 */

 public class Person {
     // A pattern for validating email addresses.
     private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");

    // The full name of the person (first name + last name).
     private final String aName;

    // The date of birth of the person.
     private final LocalDate aDOB;

    // The email address of the person.
     private final String aEmailAddress;

    // True if a parking pass has been purchased, false otherwise.
     private boolean aHasParkingPass;

     public Person(String pName, LocalDate pDOB, String pEmailAddress) {
         if (pName == null || pName.trim().isEmpty()) {
             throw new IllegalArgumentException("Name cannot be null or empty.");
         }
         if (pDOB == null) {
             throw new IllegalArgumentException("Date of birth cannot be null.");
         }
         if (pEmailAddress == null || pEmailAddress.trim().isEmpty() || !EMAIL_PATTERN.matcher(pEmailAddress).matches()) {
             throw new IllegalArgumentException("Email address is invalid.");
         }
         this.aName = pName;
         this.aDOB = pDOB;
         this.aEmailAddress = pEmailAddress;
         this.aHasParkingPass = false;
     }

     public String getName() {
         return this.aName;
     }

     public LocalDate getDOB() {
         return this.aDOB;
     }

     public String getEmailAddress() {
         return this.aEmailAddress;
     }

     public boolean isPurchasedParkingPass() {
        return this.aHasParkingPass;
     }

     public boolean purchaseParkingPass() {
         if (this.aHasParkingPass) {
             return false;
         } else
             this.aHasParkingPass = true;
         return true;
     }

     @Override
     public String toString() {
         return "Name: " + this.aName + ", Local Date: " + this.aDOB + ", Email: " + this.aEmailAddress;
     }
 }