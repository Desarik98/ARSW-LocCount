package edu.escuelaing.arsw.LocCount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocCount {
    public long numberOfLines(String fileName) {
        Pattern pat = Pattern.compile("^/");
        Pattern pat2 = Pattern.compile("^//");
        Path path = Paths.get(fileName);
        long numLines = 0;
        long total = 0;
        try(Stream<String> streams = Files.lines(path)){
            boolean flag = false;
            List<String> list = streams.collect(Collectors.toList());
            total = list.size();
            for(String i: list){
                Matcher mat = pat.matcher(i.trim());
                Matcher mat2 = pat2.matcher(i.trim());
                if(mat2.find() || i.length() == 0){
                    numLines++;
                }
                else if(mat.find()){
                    flag = true;
                }
                if (i.contains("*/") && i.length()<= 3){
                    numLines++;
                    flag = false;
                }
                if(flag){
                    numLines++;
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return total - numLines;
    }
}