/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 * The Student class is a concrete class that extends from the abstract Member
 * class, representing a student with specific characteristics and behaviors.
 *
 * This class is final. As a final class in the inheritance chain, Student
 * inherits properties from Person and Member and it is here that abstract
 * methods are given implementation.
 *
 * @author kristian
 */
public final class Student extends Member {

    private int numOfClasses;
    private String workload;

    /**
     * 
     * @param firstName of the student
     * @param lastName of the student
     * @param studentID the identification number of the student
     * @param numOfClasses 
     */
    public Student(
            String firstName,
            String lastName,
            String studentID,
            int numOfClasses
    ) {
        super(firstName, lastName, studentID);
        this.numOfClasses = numOfClasses;
    }

}
