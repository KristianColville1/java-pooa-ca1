/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Final class StudentFileReader is the last inheritance of FileReader.
 * StudentFileReader must not be extended.
 * 
 * This class reads a specific type of file called 'students.txt'.
 * 
 * The main responsibility of this class is to read that file, parse it correctly
 * and place the information gathered into student objects.
 * @author kristian
 */
public final class StudentFileReader extends CustomFileReader{

    @Override
    public List<Student> readData(String filePath) {

    }

    @Override
    public boolean validateData(Object dataItem, Object validator) {
        
    }

    @Override
    public List processData(List dataList) {

    }
    
    
}
