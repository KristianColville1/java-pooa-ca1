/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.io.BufferedWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Final class StudentFileWriter extends built in BufferedWriter.
 *
 * Handles manual writing to file for user.
 *
 * @author kristian
 */
public final class StudentFileWriter extends BufferedWriter {

    private final TerminalView menu;
    private final List students;
    private final Runnable exitApp;
    private Boolean isAddingStudents;
    private final StudentRepository studentRepository;

    public StudentFileWriter(Writer writer, TerminalView menu, Runnable exitApp) {
        super(writer);
        this.menu = menu;
        this.students = new ArrayList<Student>();
        this.exitApp = exitApp;
        this.isAddingStudents = true;
        this.studentRepository = new StudentRepository();
    }

    /**
     * Handles collecting student data to write to the file. Queries the user
     * repeatably with a while loop to collect another students data.
     * 
     * When the user is finished it writes the data collected to the file and
     * outputs the invalid data in the terminal for them to see why it failed
     * to validate.
     */
    public void handleManualWritingFlow() {
        menu.manualStudentInputHeader();

        while (isAddingStudents) {
            menu.doesUserWantToEnterAnotherStudent();
            int userChoice = InputUtils.getUserChoice(3, 6, exitApp);
            switch (userChoice){
                case 1:
                    collectAnotherStudentsData();
                case 2:
                    stopCollectingStudentDataAndValidate();
                default:
                    exitApp.run();
            }
        }

    }

    public void collectAnotherStudentsData(){
        menu.enterStudentsFirstName();
        String firstName = InputUtils.getString();
    }
    
    public void stopCollectingStudentDataAndValidate(){
        
    }
}
