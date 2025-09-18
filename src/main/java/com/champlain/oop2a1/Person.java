package com.champlain.oop2a1;
import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * Represents a person with a name, date of birth, and email address.
 * It also tracks if the person has a parking pass.
 */

 public class Person {

    /**
     * A pattern to check if an email address is valid.
     */
     private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");

    /**
     * The person's full name.
     */
     private final String aName;

    /**
     * The person's date of birth.
     */
     private final LocalDate aDOB;

    /**
     * The person's email address.
     */
     private final String aEmailAddress;

    /**
     * True if the person has a parking pass, and false otherwise.
     */
     private boolean aHasParkingPass;

    /**
     * Creates a new Person object.
     *
     * @param pName The person's name.
     * @param pDOB The person's date of birth.
     * @param pEmailAddress The person's email.
     * @throws IllegalArgumentException if the name, date of birth, or email are invalid.
     */
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

    /**
     * Gets the person's name.
     *
     * @return The name.
     */
     public String getName() {
         return this.aName;
     }

    /**
     * Gets the person's date of birth.
     *
     * @return The date of birth.
     */
     public LocalDate getDOB() {
         return this.aDOB;
     }

    /**
     * Gets the person's email address.
     *
     * @return The email address.
     */
     public String getEmailAddress() {
         return this.aEmailAddress;
     }

    /**
     * Checks if the person has a parking pass.
     *
     * @return True if they have one, false otherwise.
     */
     public boolean isPurchasedParkingPass() {
        return this.aHasParkingPass;
     }

    /**
     * Tries to get a parking pass for the person.
     *
     * @return True if it worked, false if they already have a pass.
     * */
     public boolean purchaseParkingPass() {
         if (this.aHasParkingPass) {
             return false;
         } else
             this.aHasParkingPass = true;
         return true;
     }

    /**
     * Gives a basic text summary of the person.
     *
     * @return A string with the person's info.
     */
     @Override
     public String toString() {
         return "Name: " + this.aName + ", Local Date: " + this.aDOB + ", Email: " + this.aEmailAddress;
     }
 }