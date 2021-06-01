package edu.escuelaing.arsw;

import edu.escuelaing.arsw.LocCount.LocCount;
import edu.escuelaing.arsw.LocCount.PhyCount;

public class App 
{
    public static void main( String[] args ) {
        String typeOfCount= args[0];
        String fileName = args[1];
        if(typeOfCount.equals("phy")){
            PhyCount phyCount = new PhyCount();
            System.out.println(phyCount.numberOfLines(fileName));
        }
        else{
            LocCount locCount = new LocCount();
            System.out.println(locCount.numberOfLines(fileName));
        }
    }
}
