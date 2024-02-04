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

    public StudentFileWriter(Writer writer, TerminalView menu, Runnable exitApp) {
        super(writer);
        this.menu = menu;
        this.students = new ArrayList<Student>();
        this.exitApp = exitApp;
    }

    public void handleManualWritingFlow() {
        menu.manualStudentInputHeader();
        menu.doesUserWantToCreateAnotherStudent();
        int userChoice = InputUtils.getUserChoice(3, 6, exitApp);
    }

}
