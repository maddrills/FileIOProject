package project0;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/*the following class needs to hold the following
* needs four options
* 1: add a file to the existing dir
* 2: delete a file chosen by the user from directory
* 3: Search a user specified file from the dir
* 4: return to main context
* */
public class SecondOption{

    String path;
    private int option;
    private Scanner sc;
    //holds the directory path
    private File files;
    private File fob;
    private ArrayList<File> listOfFileNames;

    //composition
    private FirstOption firstOptionOj;



    //holds all the file locations
    public SecondOption(String dirInfo){
        this.path = dirInfo + "\\Documents\\TextFiles\\";
        //custom if need be
        this.files = new File(this.path);
        //returns a boolean so you can check
        files.mkdirs();

        this.option = 0;

        this.sc = new Scanner(System.in);
        this.listOfFileNames = new ArrayList<>();

        //not a good practice to call a method in a constructor
        arrayOfFiles();
        firstOptionOj = new FirstOption(listOfFileNames);
    }
    public SecondOption(){
        //default directory on any computer
        this(System.getProperty("user.home"));
    }




    //array list of all files
    private void arrayOfFiles(){
        File[] fileList = files.listFiles();
        for(File i : fileList){
            if(i.getName().endsWith(".txt")) {
                listOfFileNames.add(i);
            }
        }
    }





    //checks if your input is of .txt format
    private String inputStringValidity(){
        System.out.println("Enter the file name");
        sc.nextLine();
        String fileName = sc.nextLine();
        //checks if the string is empty
        if (fileName != null) {
            fileName = fileName.replaceAll(" ", "");
            //valid format
            if(fileName.endsWith(".txt")){
                //sanity check if there is only .txt as a name
                if((fileName.length() == 4)){return null;}
                return fileName;
            }
            //forces a valid format
            else {
                if(fileName == ""){return null;}
                else {return fileName = fileName + ".txt";}
            }
        }
        return null;
    }




    //add a file
    private boolean inputFileSanityCheck(String fileName) throws IOException {
        //input sanity check
        if(fileName != null) {
            fob = new File(path + fileName);
            if (fob.createNewFile()) {
                return true;
            }
            return false;
        }
        return false;
    }




    //delete a file
    private boolean deleteAfile(String fileName){
        try{
            if(Files.deleteIfExists(Path.of(path+fileName))){
                return true;
            }
            return false;
        }catch (IOException e){
            return false;
        }
    }



    //search for a file
    private void userInDirectory(String fileName){
        boolean flag = true;
        for(File i: listOfFileNames){
            if(i.getName().equals(fileName)){
                System.out.println("File by the name "+ fileName + " Found !");
                flag = false;
            }
        }
        if(flag){
            System.out.println("File by the name "+ fileName + " NOT Found !");
        }
    }



    //returns the first case object pointer
    public FirstOption getFirstOptionOj() {
        return firstOptionOj;
    }


    public void option() throws IOException {

        //cycling option
        while(true){
            System.out.println("------      ------      ------      ------      ------");
            System.out.println();
            System.out.println("Select a number as an option");
            System.out.println("1: Add a file to the existing directory list");
            System.out.println("2: Delete a user specified file from the existing directory list");
            System.out.println("3: Search a user specified file from the main directory");
            System.out.println("4: Option to navigate back to the main context");
            System.out.println("------      ------      ------      ------      ------");
            //used to update the array on every call
            listOfFileNames.clear();
            arrayOfFiles();
            //System.out.println(listOfFileNames);

            //validate input
            try {option = sc.nextInt();}
            catch (Exception e){
                sc.next();
                e.printStackTrace();
                continue;
            }

            //options
            switch (option){
                case 1:
                    System.out.println("Add a file to the existing directory list");
                    if(inputFileSanityCheck(inputStringValidity())){
                        System.out.println(" File added");
                        continue;
                        }
                        System.out.println(" File cant be added");
                        continue;
                case 2:
                    System.out.println("Delete a user specified file from the existing directory list");
                    if(deleteAfile(inputStringValidity())){
                        System.out.println("File Deleted");
                        continue;
                    }
                    System.out.println("File Not found or cant be deleted");
                    continue;
                case 3:
                    System.out.println("Search a user specified file from the main directory");
                    userInDirectory((inputStringValidity()));
                    continue;
                case 4:
                    System.out.println("Option to navigate back to the main context");
                    break;
                default:
                    System.out.println("Invalid input");
                    System.out.println("Try again");
                    continue;
            }
            break;
        }
    }
}
