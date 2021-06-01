package edu.escuelaing.arsw.LocCount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
/*
hola
hola
hola
hola
 */

//hola

/**
 * hola
 * hola
 * hola
 * hola
 */
public class PhyCount {
    public long numberOfLines(String fileName){
        Path path = Paths.get(fileName);
        long numLines = 0;
        try(Stream<String> stream = Files.lines(path)){
             numLines = stream.count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numLines;
    }
}
