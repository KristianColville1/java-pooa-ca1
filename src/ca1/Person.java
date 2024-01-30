/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author kristian
 * 
 * Abstract class Person representing a person with basic personal information.
 * 
 * Inheritance is used here to allow for a common base that can be extended to 
 * more specific types of people.
 * 
 * Allows for specialised subclasses.
 */
public abstract class Person {
    private String firstName;
    private String lastName;
    
    /**
     * Person constructor sets up the person objects.
     * @param firstName of a person
     * @param lastName of a person
     */
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * Gets the persons first name.
     * @return firstName of person
     */
    public String getFirstName(){
        return this.firstName;
    }
    
    
    /**
     * Gets the persons last name.
     * @return lastName of person
     */
    public String getLastName(){
        return this.lastName;
    }
}
