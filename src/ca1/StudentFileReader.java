/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
    private List<Student> allStudents;
    
    public StudentFileReader(){
        this.allStudents = new ArrayList<Student>();
    }
    
    /**
     * Reads the data from the file.
     * 
     * @param filePath The location of the file being read.
     */
    @Override
    public void readData(String filePath) {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            
        } catch (IOException e){
            System.out.println(e);
        }
    }

    @Override
    public boolean validateData(Object dataItem, Object validator) {
        
    }

    @Override
    public List processData(List dataList) {

    }
    
    
}
