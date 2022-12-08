import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    // This method creates a chain numbers and separation dots as one String. We start with a dot
    // to mark the start of the String, avoiding single digit errors.

    static String makeString(String first, String last) {
        StringBuilder answer = new StringBuilder();
        answer.append(".");
        for (int i = parseInt(first); i <= parseInt(last); i++) {
            answer.append(i).append(".");
        }

        return answer.toString();

    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("PUZZLE INPUT.txt");
        Scanner scan = new Scanner(file);

        int solution = 0;
        String[] numbersInLine;
        ArrayList<String> twoSection = new ArrayList<>(2);

        while (scan.hasNextLine()) {

            numbersInLine = scan.nextLine().split("[,-]");
            twoSection.add(0, makeString(numbersInLine[0], numbersInLine[1]));
            twoSection.add(1, makeString(numbersInLine[2], numbersInLine[3]));

            if (twoSection.get(0).contains(twoSection.get(1))) {
                solution++;
            } else if (twoSection.get(1).contains(twoSection.get(0))) {
                solution++;
            }
        }


        System.out.println("The final result is: " + solution);
        scan.close();

    }
}