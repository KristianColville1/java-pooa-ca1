/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Abstract class representing a generic file handler. This class is designed to
 * be sub classed with a specific type parameter T, indicating the type of data
 * that will be read from a file. Subclasses must implement the methods to
 * define how data is read, processed and validated.
 *
 * @param <T> The type of data that this reader will process and return.
 * @author kristian
 */
public abstract class FileHandler<T> {

    // A protected variable that subclasses can access and manipulate
    protected List fileContentsList;

    /**
     * Constructor for CustomFileReader abstract class.
     *
     * Initializes the fileContentsList when called by sub classes.
     */
    public FileHandler() {
        this.fileContentsList = new ArrayList();
    }

    /**
     * Reads data from a file in the required location and converts it into a
     * list of objects of type T.
     *
     * This method must be implemented by subclasses to define how to read the
     * file contents in the desired format.
     *
     * @param filePath to locate and read.
     */
    public abstract void readData(String filePath);

    /**
     * Processes a list of objects of type T in a custom way.
     *
     * This method must be implemented by subclasses for how to process the
     * data.
     *
     * @param dataList for processing.
     */
    public abstract void processData(List<String> dataList);

    /**
     * Validates a single data item of type T.
     *
     * This method must be implemented by subclasses to validate the data.
     *
     * @param dataItem the data list to validate.
     */
    public abstract void validateData(List<T> dataItem);

    
    /**
     * Writes the data to a file in a specific format unique to the subclasses.
     * 
     * @param fileName the name of the file to write to.
     */
    public abstract void writeDataToFile(String fileName);
    
    
    /**
     * Overloaded abstract method for manual writing to file.
     * @param fileName the name of the file to write to.
     * @param manual Boolean for if manual writing required.
     */
    public abstract void writeDataToFile(String fileName, Boolean manual);
}
