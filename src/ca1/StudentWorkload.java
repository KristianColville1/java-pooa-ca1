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
     * Constructor StudentWorkload
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
     * @return the associated description for the number of classes for a
     * particular constant.
     */
    public String getDescription() {
        return description;
    }
}
