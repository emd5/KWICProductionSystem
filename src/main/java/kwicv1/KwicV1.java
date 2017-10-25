/* Liz Mahoney
 * KWIC Program - Assignment 7
 * 10/19/17
 * KwicV1.java
 *
 * This class is reads from an input_file, reads each line, moves the
 * first word to the end of each line, sorts in alphabetical order
 * and prints to new output file.
 */

package kwicv1;

import java.io.*;
import java.util.*;

/**
 * This class is reads from an input_file, reads each line, moves the
 * first word to the end of each line, sorts in alphabetical order
 * and prints to new output file.
 *
 * @author Liz Mahoney
 * @version 1.0
 */
public class KwicV1 {

    //global variables
    public static BufferedReader bufferedReader_in = null;
    public static PrintWriter writer = null;
    public static List<String> savedList;

    private static final String longList_file = "input.txt";
    private static final String shortList_file= "input2.txt";
    private static final String output_file = "output.txt";

    /**
     * This method is the entry point to run the KWIC program
     *
     * @param args
     * @throws IOException Signals that an I/O exception of
     * some sort has occurred.
     */
    public static void main(String[] args) throws IOException{

        //takes an input file and reads it
        readFile (shortList_file);
        writeToOutputFile (savedList);

    }

    /**
     * This method excepts a file, reads each line shifts the first
     * word to the end of the each line.
     *
     * @param file_name - the file to be read
     * @return a list of lines from the file_name
     *
     * @throws IOException Signals that an I/O exception of some
     * sort has occurred.
     */
    public static List<String> readFile(String file_name) throws  IOException{

        try {

            FileInputStream file_in = new FileInputStream (file_name);
            bufferedReader_in = new BufferedReader (new InputStreamReader (file_in));

            savedList = new ArrayList<>();
            circularShift ();

            Collections.sort(savedList);

            System.out.println ("File saved success!");

        }
        catch(FileNotFoundException e){

            System.out.println ("Input file not found");
        }
        finally {

            if(bufferedReader_in != null ){

                bufferedReader_in.close ();
            }
        }

        return savedList;
    }

    /**
     *This method excepts a List to move the first word from each line and shifts
     * to the end of each line.
     *
     * @return
     */
    private static void circularShift() throws IOException{

        String[] lineArray;
        String line;

        while ((line = bufferedReader_in.readLine ()) != null){

            lineArray = line.split ("\\s", 2);

            checkArray (lineArray);

        }

    }


    /**
     * This method checks each line if the length of the
     * sentence has one word.
     *
     * @param lineArray - each line of the list
     * @return
     */
    public static List<String> checkArray(String[] lineArray){

        String firstWord, entireLine, shiftedLine;

        firstWord= lineArray[0];

        if(lineArray.length <= 1){

            entireLine = lineArray[0];
            shiftedLine = entireLine;

        }
        else {

            entireLine = lineArray[1];
            shiftedLine = entireLine + " " + firstWord;
        }

        savedList.add (shiftedLine);

        return savedList;

    }

    /**
     * This method takes the input file list and writes
     * to new file.
     *
     * @param savedList - the input files content
     */
    private static void writeToOutputFile(List<String> savedList) throws IOException{

        try {
            writer = new PrintWriter (output_file);

            for(String line : savedList){
                writer.println (line);
            }

            System.out.println ("File printed to output success!");

        }
        catch(NullPointerException e){
            System.out.println ("File cannot be printed due to no file found");
        }
        finally {

            if(writer != null ){

                writer.close ();
            }
        }

    }




}













