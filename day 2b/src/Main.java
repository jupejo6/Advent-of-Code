
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Main {

    /* This method calculates the score for the result.
    * X (win) = 6 point
    * Y (draw) = 3 point
    * Z (lose) = 0 point */

    static int winLoseDraw(String result) {
        return switch (result) {
            case "Y" -> 3;
            case "Z" -> 6;
            default -> 0;
        };

    }

    /* This method determines our hands strength
     * Rock = 1 point
     * Paper = 2 points
     * Scissor = 3 points
     * */
    static int handStrength(String handType)
    {
        return switch (handType) {
            case "A" -> 1;
            case "B" -> 2;
            default -> 3;

        };
    }

    static String handPicker(String oppHand, String result)
    {
        if(result.equals("Y")) // draw
            return oppHand; // A, B or C

        else if (result.equals("Z"))// win
        {
            return switch(oppHand) {
                case "A" -> "B";
                case "B" -> "C";
                default -> "A";
            };

        }
        else // lose
        {
            return switch(oppHand) {
                case "C" -> "B";
                case "A" -> "C";
                default -> "A";
            };


        }
    }


    static int calculateScore(String opponentsHand, String result) {

        /* Base score is the result. */
        int score = winLoseDraw(result);

        /* Additional score is the strength of the hand */
        score += handStrength(handPicker(opponentsHand, result));


        return score;
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:/Users/Asus/Desktop/rps.txt");
        Scanner scan = new Scanner(file);

        int sum = 0;
        String opponentHand;
        String result;

        while (scan.hasNextLine()) {
            opponentHand = scan.next();
            result = scan.next();
            sum += calculateScore(opponentHand, result);
        }

        scan.close();
        System.out.println("The answer is: " + sum);
    }
}