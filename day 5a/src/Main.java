import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {



        File file = new File("C:/Users/Asus/Desktop/test.txt");
        //File file = new File("C:/Users/Asus/Desktop/day5.txt");
        Scanner scan = new Scanner(file);


        System.out.println("The final answer is: ");
        scan.close();
    }
}