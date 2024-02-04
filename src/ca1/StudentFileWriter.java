/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.io.BufferedWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Final class StudentFileWriter extends built in BufferedWriter.
 *
 * Handles manual writing to file for user.
 *
 * @author kristian
 */
public final class StudentFileWriter extends BufferedWriter {

    private final TerminalView menu;
    private final List<Student> students;
    private final Runnable exitApp;
    private Boolean isAddingStudents;
    private final StudentRepository studentRepository;

    public StudentFileWriter(Writer writer, TerminalView menu, Runnable exitApp, List<Student> students, StudentRepository studentRepository) {
        super(writer);
        this.menu = menu;
        this.students = students;
        this.exitApp = exitApp;
        this.isAddingStudents = true;
        this.studentRepository = studentRepository;
    }

    /**
     * Handles collecting student data to write to the file. Queries the user
     * repeatably with a while loop to collect another students data.
     *
     * When the user is finished it writes the data collected to the file and
     * outputs the invalid data in the terminal for them to see why it failed to
     * validate.
     */
    public void handleManualWritingFlow() {
        menu.manualStudentInputHeader();

        while (isAddingStudents) {
            menu.doesUserWantToEnterAnotherStudent();
            int userChoice = InputUtils.getUserChoice(3, 6, exitApp);
            switch (userChoice) {
                case 1:
                    collectAnotherStudentsData();
                case 2:
                    stopCollectingStudentDataAndValidate();
                    isAddingStudents = false;
                default:
                    exitApp.run();
                    isAddingStudents = false;
            }
        }

    }

    /**
     * Collects the students data and adds the student to the students list.
     * Gets the firstName, lastName, studentID & numOfClasses.
     */
    public void collectAnotherStudentsData() {
        Boolean isAlreadyInvalid = false;
        HashMap<String, String> invalidReasons = new HashMap<String, String>();

        menu.enterStudentsFirstName();
        String firstName = InputUtils.getNextLine();

        menu.enterStudentsLastName();
        String lastName = InputUtils.getNextLine();

        menu.enterStudentsNumberOfClasses();
        int numOfClasses;
        try {
            numOfClasses = InputUtils.getNextInt();
        } catch (Exception e) {
            numOfClasses = 0;
            invalidReasons.put("Number of classes",
                    "You did not enter integer when"
                    + " adding the numbe of classes");
        }

        menu.enterStudentsID();
        String studentID = InputUtils.getNextLine();

        Student student = new Student(firstName, lastName, studentID, numOfClasses);
        students.add(student);
    }

    public void stopCollectingStudentDataAndValidate() {
        StudentValidator validator = new StudentValidator();
        validator.performValidationChecksOnStudentData(students);
    }
}
