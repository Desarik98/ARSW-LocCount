package edu.escuelaing.arsw;

import edu.escuelaing.arsw.LocCount.LocCount;
import edu.escuelaing.arsw.LocCount.PhyCount;
import java.io.IOException;
import java.nio.file.*;


public class App 
{
    /**
     * @param args primer argumento phy o loc, segundo argumento archivo
     * @throws IOException si no encuentra el archivo
     */
    public static void main( String[] args ) throws IOException {
        String typeOfCount= args[0];
        String fileName = args[1];
        int index = fileName.indexOf("*");
        if(index > 0){
            locDir(fileName,index,typeOfCount);
        } else {
            System.out.println(locFile(fileName,typeOfCount));
        }
    }

    /**
     * Metodo que permite la lectura de todos los archivos de una carpeta de una misma extencion por ejemplo
     * *.java
     * @param fileName nombre del archivo
     * @param index indice donde se encuentra el * en el archivo
     * @param typeOfCount tipo de conteo de lineas phy o loc
     * @throws IOException
     */
    public static void locDir(String fileName,int index,String typeOfCount) throws IOException {
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

    /**
     * Metodo que cuenta las lineas de codigo de un archivo segun su tipo
     * @param fileName nombre del archivo
     * @param typeOfCount tipo de conteo phy o loc
     * @return el numero de lineas de codigo de un archivo
     */
    public static long locFile(String fileName,String typeOfCount){
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