/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author kristian
 *
 * StudentWorkload enum used for storing the constant data about the number of
 * student classes and the corresponding workload.
 */
public enum StudentWorkload {
    VERY_LIGHT(1, "Very Light"),
    LIGHT(2, "Light"),
    PART_TIME(3, "Part Time"),
    FULL_TIME(6, "Full TIME");

    private final int classes;
    private final String description;

    /**
     * Constructor StudentWorkload sets up constants.
     *
     * @param classes represents the number of classes associated with a
     * workload.
     * @param description provides information about the workload.
     */
    StudentWorkload(int classes, String description) {
        this.classes = classes;
        this.description = description;
    }

    /**
     * Gets the description for a number of classes.
     *
     * @return the associated description for the number of classes for a
     * particular constant.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Determines and sets the workload based on the number of classes.
     *
     * @param numOfClasses the number of classes a student is taking.
     * @return associated description
     * @throws IllegalArgumentException if numOfClasses is less than 1 or higher
     * than 8.
     */
    public StudentWorkload setWorkload(int numOfClasses) {
        if (numOfClasses < 1 || numOfClasses > 8) {
            throw new IllegalArgumentException(
                    "Number of classes must be greater"
                    + " than 0 and less than 8 inclusively.");
        }
        switch (numOfClasses) {
            case 1:
                return VERY_LIGHT; // covers 1 class
            case 2:
                return LIGHT; // covers 2 classes
            case 3:
            case 4:
            case 5:
                return PART_TIME; // covers 3, 4 & 5 classes
            default:
                return FULL_TIME; // covers 6 classes or higher
        }
    }
}
