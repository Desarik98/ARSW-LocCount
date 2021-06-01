package edu.escuelaing.arsw;

import edu.escuelaing.arsw.LocCount.PhyCount;

import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        String typeOfCount= args[0];
        String fileName = args[1];
        if(typeOfCount.equals("phy")){
            PhyCount phyCount = new PhyCount();
            System.out.println(phyCount.numberOfLines(fileName));
        }
    }
}
