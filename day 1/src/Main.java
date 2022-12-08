
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {


        File file = new File("C:/Users/Asus/Desktop/cal.txt");
        Scanner scan = new Scanner(file);

        int tempCal = 0;
        int top3 = 0;
        int elfNumber = 0;

        ArrayList<Integer> calRank = new ArrayList<>();


        while(scan.hasNextLine())
        {

            try{
                tempCal += Integer.parseInt(scan.nextLine());
            }
            catch(NumberFormatException e)
                {
                    calRank.add(tempCal);
                    tempCal = 0;
                    elfNumber++;
                }

        }

        Collections.sort(calRank);

        for(int i = 1; i <= 3; i++)
            top3 += calRank.get(elfNumber-i);

        System.out.println("Top 3 Calcium sum: " + top3);
        scan.close();

    }
}