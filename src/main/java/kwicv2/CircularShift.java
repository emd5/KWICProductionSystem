package kwicv2;


import java.util.Collections;


public class CircularShift {

    private static LineManager allLines = new LineManager ();
    private static String[] lineArray;


    public CircularShift(String line){

        for(int i=0 ;i< allLines.listSize ();i++){

            lineArray = line.split ("\\s", 2);

            checkArrayOnEachLine (lineArray);
        }

    }

    private static void checkArrayOnEachLine(String[] lineArray){

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

        allLines.addLine (shiftedLine);

    }

}
