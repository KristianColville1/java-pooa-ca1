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
        String id = student.getIdentityNumber();

        // check minium length of id
        if (!checkMinStringLength(id, 6)) {
            return false;
        }

        // check minimum year
        String year = id.substring(0, 2);
        if (!checkMinInt(year, 20)) {
            return false;
        }

        // check if numbers after year is 2 or 3 letters
        Boolean hasTwoLetters;
        String letters = id.substring(2, 4);
        if (!checkForLettersOnly(id.substring(4, 5))) {
            letters += id.charAt(4);
            hasTwoLetters = false;
        } else {
            hasTwoLetters = true;
        }

        // perform check on letters after year if only letters return true
        if (!checkForLettersOnly(letters)) {
            return false;
        }

        String theRest;
        if (hasTwoLetters) {
            theRest = id.substring(4, -1);
        } else {
            theRest = id.substring(5, -1);
        }

        if (checkMinInt(theRest)) {
            return false;
        }
    }

    /**
     * Checks the minium length of a string and returns true or false.
     *
     * @param text string to examine
     * @param maxLength the minium length to check for
     * @return true or false
     */
    public Boolean checkMinStringLength(String text, int minLength) {
        return text.length() < minLength;
    }

    /**
     * Checks if a string after being converted to an integer is greater than or
     * equal to another integer.
     *
     * @param text the string representation of an integer
     * @param min the integer to check against
     */
    public Boolean checkMinInt(String text, int min) {
        int checker;
        try {
            checker = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return checker >= min;
    }

    /**
     * Checks a string after converting to an integer is between min and max
     * inclusively.
     *
     * @param text the string to convert to integer
     * @param min the minimum value to check for
     * @param max the maximum value to check for
     */
    public Boolean checkStringsIntRangeBetweenMinMax(
            String text, int min, int max) {
        try {
            int value = Integer.parseInt(text);
            // return the result of checking the range
            return min <= value && value <= max;
        } catch (NumberFormatException e) {
            // if parsing fails then return false;
            return false;
        }
    }

}
