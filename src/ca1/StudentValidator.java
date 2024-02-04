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

    public Boolean checkForLettersOnly(String data) {
        return false;
    }

    public Boolean checkForLettersAndNumbers(String data) {
        return false;
    }

    public Boolean validateTheStudentID(Student student) {
        return false;
    }
}
