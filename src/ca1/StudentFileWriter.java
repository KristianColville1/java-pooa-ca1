/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.io.BufferedWriter;
import java.io.Writer;

/**
 * Final class StudentFileWriter extends built in BufferedWriter.
 *
 * Handles manual writing to file for user.
 *
 * @author kristian
 */
public final class StudentFileWriter extends BufferedWriter
        implements IUserInput {

    public StudentFileWriter(Writer writer) {
        super(writer);
    }

    @Override
    public void queryUser() {
    }

    @Override
    public void confirmUserSelection() {
    }

    @Override
    public void writeUsersSelectionToFile() {
    }

}
