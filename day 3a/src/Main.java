import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

import java.util.HashMap;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        //File file = new File("C:/Users/Asus/Desktop/test.txt");
        File file = new File("C:/Users/Asus/Desktop/day3a.txt");
        Scanner scan = new Scanner(file);

        HashMap<Character, Integer> valueOfLetters = new HashMap<>();
        int sum = 0;
        String line;
        boolean lineNotDone = true;

        for(char i = 'a'; i <= 'z'; i++)
        {
            valueOfLetters.put(i, i - 96);
        }
        for(char i = 'A'; i <= 'Z'; i++)
        {
            valueOfLetters.put(i, i - 38);
        }

        while(scan.hasNextLine()) {
            line = scan.next();
            for (int i = 0; i < line.length() / 2; i++)
                for (int j = line.length() / 2; j < line.length(); j++) {
                    if (line.charAt(j) == line.charAt(i) && lineNotDone) {
                        sum += valueOfLetters.get(line.charAt(i));
                        lineNotDone = false;
                    }
                }
            lineNotDone = true;
        }

        System.out.println("Final Result: " + sum);
        scan.close();
    }
}