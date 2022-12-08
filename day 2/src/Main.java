
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Main {

    /* this decoder translates the A/B/C or X/Y/Z codes to game elements. */
    static String decoder(String code)
    {
        if(code.equals("A") || code.equals("X"))
            return "rock";
        else if(code.equals("B") || code.equals("Y"))
            return "paper";
        else
            return "scissor";
    }
    /* This method determines if we win, we lose, or it's a draw, then it return with the score we got.*/
    static int winLoseDraw(String enemy, String player){

        /* draw, we got 3 points */
        if(decoder(enemy).equals(decoder(player)))
            return 3;

        /* lose, we got 0 point */
        if(decoder(enemy).equals("rock") && decoder(player).equals("scissor"))
            return 0;
        if(decoder(enemy).equals("scissor") && decoder(player).equals("paper"))
            return 0;
        if(decoder(enemy).equals("paper") && decoder(player).equals("rock"))
            return 0;

        /* win, we got 6 points */
        return 6;
    }

    /* this method gives the additional score for the played hand */
    static int handStrength(String hand)
    {
        if(decoder(hand).equals("rock"))
            return 1;
        else if(decoder(hand).equals("paper"))
            return 2;
        else if(decoder(hand).equals("scissor"))
            return 3;

        return 0;
    }

    static int calculateScore(String enemy, String player){

        /* Base score is the result*/
        int score = winLoseDraw(enemy, player);

        /*  Additional score is the played hand */
        score += handStrength(player);

        return score;
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:/Users/Asus/Desktop/rps.txt");
        Scanner scan = new Scanner(file);

        int sum = 0;
        String enemy;
        String player;

        while(scan.hasNextLine()) {
            enemy = scan.next();
            player = scan.next();
            sum += calculateScore(enemy,player);
        }

        scan.close();
        System.out.println("The answer is: " + sum);
    }
}