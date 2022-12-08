import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    // Checking if the given ranges overlapping.
    // If both the two range border pairs (firth top - second bottom/ first bottom - second top)
    // overlapping, we return with a true;
    static boolean isOverlap(String[] actualNumbers)
    {
        return Integer.parseInt(actualNumbers[0]) <= Integer.parseInt(actualNumbers[3])
                && Integer.parseInt(actualNumbers[2]) <= Integer.parseInt(actualNumbers[1]);
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("PUZZLE INPUT.txt");
        Scanner scan = new Scanner(file);

        int solution = 0;
        String[] numbersInLine;

        while(scan.hasNextLine())
        {
            numbersInLine = scan.nextLine().split("[,-]");
            if(isOverlap(numbersInLine))
                solution++;
        }

        System.out.println("The final result is: " + solution);
        scan.close();

    }
}