package project0;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class FirstOption {
    //sorting the given list
    private ArrayList<File> files;
    public FirstOption(ArrayList<File> files){
        this.files = files;
        Collections.sort(files);
    }
    public FirstOption(){
        this(null);
    }

    public void getAllSortedValues(){
        System.out.println("------      ------      ------      ------      ------");
        for(File i : files)
        System.out.println(i.getName());
    }
}
