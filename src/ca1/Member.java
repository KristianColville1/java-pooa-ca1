/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author kristian
 *
 * Abstract class that extends Person to include membership-specific
 * information.
 *
 * This class demonstrates the use of inheritance to create a more specific
 * abstraction from the Person class. Adds new properties and behaviours that
 * are common among members.
 */
public abstract class Member extends Person {

    private final String identityNumber;

    /**
     * Constructs a new Member with specified first name, last name, and
     * identity number. Inherits first and last name properties from the Person
     * class.
     *
     * @param firstName The first name of the member.
     * @param lastName The last name of the member.
     * @param identityNumber The identity number of the member.
     */
    public Member(String firstName, String lastName, String identityNumber) {
        super(firstName, lastName); // Initializes first and last name from the Person class
        this.identityNumber = identityNumber; // Sets the identityNumber specific to the Member class
    }

    /**
     * Gets the members identityNumber.
     *
     * @return the identityNumber
     */
    public String getIdentityNumber() {
        return this.identityNumber;
    }

    /**
     * Retrieves detailed information about a Member. Overrides the getDetails
     * method from the Person class to include the identity number. This is
     * polymorphism.
     *
     * @return string containing the first name, last name, and identity number
     * of the member.
     */
    @Override
    public String getDetails() {
        return String.format("%s %s %s", getFirstName(), getLastName(), identityNumber);
    }

}
