package edu.escuelaing.arsw;

import edu.escuelaing.arsw.LocCount.LocCount;
import edu.escuelaing.arsw.LocCount.PhyCount;
import org.junit.Assert;
import org.junit.Test;



public class AppTest 
{
    public static final String path1 = "/home/daniel/Escritorio/ARSW/LocCount/src/main/java/edu/escuelaing/arsw/LocCount/LocCount.java";
    public static final String path2 = "/home/daniel/Escritorio/ARSW/LocCount/src/main/java/edu/escuelaing/arsw/LocCount/PhyCount.java";

    @Test
    public void deberiaContarLineasPhyCountFile(){
        PhyCount phyCount = new PhyCount();
        long numLines = phyCount.numberOfLines(path1);
        Assert.assertEquals(46,numLines);
        numLines = phyCount.numberOfLines(path2);
        Assert.assertEquals(20,numLines);
    }

    @Test
    public void deberiaContarLineasLocCountFile(){
        LocCount locCount = new LocCount();
        long numLines = locCount.numberOfLines(path1);
        Assert.assertEquals(44,numLines);
        numLines = locCount.numberOfLines(path2);
        Assert.assertEquals(18,numLines);
    }

}
