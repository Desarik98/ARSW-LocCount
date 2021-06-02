package edu.escuelaing.arsw;

import edu.escuelaing.arsw.LocCount.LocCount;
import edu.escuelaing.arsw.LocCount.PhyCount;
import java.io.IOException;
import java.nio.file.*;


public class App 
{
    public static void main( String[] args ) throws IOException {
        String typeOfCount= args[0];
        String fileName = args[1];
        int index = fileName.indexOf("*");
        if(index > 0){
            LocDir(fileName,index,typeOfCount);
        } else {
            System.out.println(LocFile(fileName,typeOfCount));
        }
    }

    public static void LocDir(String fileName,int index,String typeOfCount) throws IOException {
        String path = fileName.substring(0,index);
        String glob = fileName.substring(index+2);
        Path dir = FileSystems.getDefault().getPath(path);
        DirectoryStream<Path> stream = Files.newDirectoryStream(dir,"*.{"+glob+"}");
        for (Path i:stream){
            if(typeOfCount.equals("phy")){
                PhyCount phyCount = new PhyCount();
                System.out.println(phyCount.numberOfLines(dir+"/"+i.getFileName().toString()));
            }
            else{
                LocCount locCount = new LocCount();
                System.out.println(locCount.numberOfLines(dir+"/"+i.getFileName().toString()));
            }
        }
        stream.close();
    }

    public static long LocFile(String fileName,String typeOfCount){
        long numLines;
        if(typeOfCount.equals("phy")){
            PhyCount phyCount = new PhyCount();
            numLines = phyCount.numberOfLines(fileName);
        }
        else{
            LocCount locCount = new LocCount();
            numLines = locCount.numberOfLines(fileName);
        }
        return numLines;
    }
}
