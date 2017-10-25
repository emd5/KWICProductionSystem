package kwicv2;

import java.io.IOException;
import java.util.Collections;

public class Kwicv2 {

    public static void main(String[] args) throws IOException {

        LineManager manager = new LineManager ();
        FileIO file = new FileIO (manager);


        file.readLines ();

        Collections.sort (manager.getShiftedLines ());


        file.writeLines ();



    }

}
