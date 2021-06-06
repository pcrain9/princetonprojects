import java.io.File;
import java.util.Scanner;
import java.util.*;

public class BST {

    public static void main(String args[])throws Exception{
    
    Set<String> list = new TreeSet<>();
    
    //check for if a file exists in command line argument
    if(args[0] == null){
        System.out.println("No file to read");
        System.exit(1);
    }

    File file = new File(args[0]);
    Scanner scan = new Scanner(file);

    //store the info from file in BST
    while(scan.hasNextLine()){
        list.add(scan.nextLine());
    }
    scan.close();

    //print out the names from list in order
    for(String value : list){
        System.out.println("" + value);
    }
    }
    
}
