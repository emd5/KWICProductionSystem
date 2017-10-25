package kwicv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LineManager {

    private static List<String>  allLines;
    private static List<String> shiftedList = new ArrayList<> ();
    private static List<String> sortList;
    private static String shiftedLine;


    public LineManager(){

        allLines = new ArrayList<> ();

    }

    public static String lineCircularShift(int line){

        String firstWord, entireLine;

        String splitLine = allLines.get(line);

        //String shiftedLine = null;

        for(int i=0 ; i < allLines.size() ; i++) {

            String[] lineArray = splitLine.split ("\\s", 2);


            firstWord= lineArray[0];

            if(lineArray.length <= 1){

                entireLine = lineArray[0];
                shiftedLine = entireLine;

            }
            else {

                entireLine = lineArray[1];
                shiftedLine = entireLine + " " + firstWord;
            }
        }
       // allLines.add (shiftedLine);
        return shiftedLine;
    }


    public static List<String> getShiftedLines(){

       // shiftedList = new ArrayList<> ();

        for(int i=0 ; i <allLines.size (); i++){

            String newLine = lineCircularShift (i);
            shiftedList.add (newLine);
        }

        return shiftedList;

    }



    public static void addLine(String line){

        allLines.add (line);

    }

    public static String getLine(int line){
            
        return shiftedList.get (line);

    }

    public static int listSize(){

        return allLines.size ();
    }

    public static List<String> sortList(){
        System.out.println (shiftedList);
        Collections.sort (shiftedList);

        return shiftedList;
    }



}
