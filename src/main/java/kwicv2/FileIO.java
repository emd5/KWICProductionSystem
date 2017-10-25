package kwicv2;

/*Liz Mahoney
 * 11/4/16
 * FileIO.java
 * FileIO I/O code provided by Josh Archer to print onto
 * the console
 */

import java.io.*;


/**
 * Helper class for reading a file and writing to a new file.
 * @author Liz Mahoney
 * @version 1.0
 */
public class FileIO {

    private static final String input_file = "input2.txt";
    private static final String output_file = "outputv2.txt";


    private static LineManager manager;

    public FileIO(LineManager manager) throws IOException{

        this.manager = manager;

    }


    public void readLines() throws IOException{

        String line;

        FileInputStream file = new FileInputStream (input_file);
        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (file));

        while((line = bufferedReader.readLine ()) != null){

            manager.addLine (line);

        }

        bufferedReader.close ();
    }


    public void writeLines() throws FileNotFoundException{

         PrintWriter writer = new PrintWriter (output_file);

        for(int i =0; i<manager.listSize () ; i++){

           writer.println (manager.getLine (i));
        }

        writer.close ();
    }

}



