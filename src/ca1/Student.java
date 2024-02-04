/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.HashMap;

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

    private final int numOfClasses;
    private final StudentWorkload workload; // enum
    private boolean isValid;
    private final HashMap<String, String> invalidReasons;

    /**
     * Student constructor configures the student properties.
     *
     * We are readying the student information for further processing and
     * validating elsewhere.
     *
     * These objects will be written to a file called 'status.txt'.
     *
     * Invalid objects will be displayed in the terminal.
     *
     * @param firstName of the student
     * @param lastName of the student
     * @param studentID the identification number of the student
     * @param numOfClasses the student studies
     */
    public Student(
            String firstName,
            String lastName,
            String studentID,
            int numOfClasses
    ) {
        super(firstName, lastName, studentID);
        this.numOfClasses = numOfClasses;
        this.invalidReasons = new HashMap<>();
        this.workload = getThisStudentsWorkload(numOfClasses);
    }

    /**
     * Getter for retrieving the encapsulated workload description. The workload
     * is determined by the StudentWorkload enum, which maps a range of
     * descriptions to the number of classes they take.
     *
     * @return the description of student workload
     */
    public String getWorkloadDescription() {
        return workload.getDescription();
    }

    /**
     * getThisStudentsWorkload provides some validation for getting the correct
     * student workload.
     *
     * If the workload is invalid it makes this student object immediately
     * invalid by turning isValid = 'false'
     *
     * @param numOfClasses the student takes
     * @return the student workload object description
     */
    public StudentWorkload getThisStudentsWorkload(int numOfClasses) {
        StudentWorkload description;
        try {
            description = StudentWorkload.setWorkload(numOfClasses);
            isValid = true; // valid student so far
        } catch (IllegalArgumentException e) {
            description = StudentWorkload.INVALID;
            invalidReasons.put(
                    "workload", String.format(
                            "The workload is invalid: %d",
                            numOfClasses));
            isValid = false; // immediately invalid
        }
        return description;
    }
    
    /**
     * Gets the current validation status of a student object.
     * 
     * @return the Boolean representing the students validity
     */
    public Boolean isStudentValid(){
        return isValid;
    }
}
