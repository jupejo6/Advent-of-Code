import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    /* This method checks in a String contains a specific character. */
    static boolean isInIt(String line, char c) {
        for (int i = 0; i < line.length(); i++) {
            if (line.toCharArray()[i] == c)
                return true;
        }
        return false;

    }

    /* This method take the 3 Strings (lines) as an array, if one of the first lines character
     *  is both in the second and the third line, it returns with that character.*/
    static char badgeLetter(ArrayList<String> threeLine) {
        char answer = 'a';
        for (int i = 0; i < threeLine.get(0).length(); i++) {
            if (isInIt(threeLine.get(1), threeLine.get(0).charAt(i))
                    && isInIt(threeLine.get(2), threeLine.get(0).charAt(i)))
                answer = threeLine.get(0).charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {

        //File file = new File("C:/Users/Asus/Desktop/test.txt");
        File file = new File("C:/Users/Asus/Desktop/day3a.txt");
        Scanner scan = new Scanner(file);

        /* Create a HashMap to connect the value to each letter of the Alphabet,
         * first the lowercase, then the uppercase ones. */

        HashMap<Character, Integer> valueOfLetters = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            valueOfLetters.put(i, i - 96);
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            valueOfLetters.put(i, i - 38);
        }

        // We fill the Arraylist with the next 3 lines as Strings, then we add the Badge value to it.
        // We do this until the EOF.
        int sum = 0;
        ArrayList<String> threeLine = new ArrayList<>();
        while (scan.hasNextLine()) {
            for (int i = 0; i < 3; i++)
                threeLine.add(scan.next());

            sum += valueOfLetters.get(badgeLetter(threeLine));
            threeLine.clear();
        }


        System.out.println("Final Result: " + sum);
        scan.close();

    }
}