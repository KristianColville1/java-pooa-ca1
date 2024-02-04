/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.List;

/**
 * StudentValidator is responsible for handling validation logic of student
 * objects.
 *
 * @author kristian
 */
public class StudentValidator {

    /**
     * Performs validation checks on student data and sets the valid status of
     * these objects.
     *
     * @param data the list of student objects.
     */
    public void performValidationChecksOnStudentData(List<Student> data) {
        // validate
        for (Student student : data) {
            /**
             * if the students last name is blank if the first name contains
             * only letters if the last name contains letters/numbers
             */
            if ("".equals(student.getLastName())
                    || checkForLettersOnly(student.getFirstName())
                    || checkForLettersAndNumbers(student.getLastName())) {
                student.setValidStatus(false);
                student.isInvalidBecause(
                        "Student Name",
                        "first and/or last name is invalid");
            }

            // validates the student ID
            if (!validateTheStudentID(student)) {
                student.setValidStatus(false);
                student.isInvalidBecause(
                        "Student ID",
                        String.format(
                                "student ID is invalid: %s",
                                student.getIdentityNumber()));
            }
        }
    }

    /**
     * Checks if the provided string contains only letters.
     *
     * @param data The string to be checked.
     * @return true if the string contains only letters otherwise false
     */
    public Boolean checkForLettersOnly(String data) {
        String regex = "^[a-zA-Z]+$";
        return data.matches(regex);
    }

    /**
     * Checks if the provided string contains only letters and/or numbers.
     *
     * @param data The string to be checked.
     * @return true if contains letters and/or numbers
     */
    public Boolean checkForLettersAndNumbers(String data) {
        String regex = "^[a-zA-Z0-9]+$";
        return data.matches(regex);
    }

    public Boolean validateTheStudentID(Student student) {
        return false;
    }
}
