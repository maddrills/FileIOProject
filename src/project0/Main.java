package project0;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("------------------------------------------------------");
        System.out.println("Application Developer : Mathew Francis");
        System.out.println("File related Application");
        System.out.println("------------------------------------------------------");
        SecondOption sob;


        String path = "";
        Scanner input = new Scanner(System.in);

/*        default path object uncomment if needed
        sob = new SecondOption();
        my use
        //sob = new SecondOption("H:\\src\\Project");*/

        //mt custom path
        while(true){
            System.out.println("Enter the explicit path");
            path = input.nextLine();

            File location = new File(path);
            if(!location.isDirectory()){
                System.out.println("Invalid path");
                continue;
            }
            sob = new SecondOption(path);
            break;
        }

        //dev name
        Scanner sc = new Scanner(System.in);
        int option = 0;

        while(true){
            System.out.println("------------------------------------------------------");
            System.out.println("Select a number as an option");
            System.out.println();
            System.out.println("1: Display the Current File names");
            System.out.println("2: Display the user interface");
            System.out.println("3: Exit");
            System.out.println("------------------------------------------------------");

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
                    System.out.println("first option");
                    sob.getFirstOptionOj().getAllSortedValues();
                    continue;
                case 2:
                    System.out.println("Second option");
                    sob.option();
                    continue;
                case 3:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid input");
                    continue;
            }
            break;
        }
    }
}
