package opgave03;
//test
import java.util.Scanner;

public class Pigs {
    public static String[] player = new String[2];
    public static int rollCount = 0;
    public static String answer;

    //When whichTurn is even = player1 -- uneven = player2
    public static int whichTurn = 0;
    public static int[] totalPlayer = {0 ,0};
    public static int limit;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("Velkommen til PIG.");
        System.out.println("------------------");
        System.out.print("Indtast player1 navn: ");
        player[0] = input.next();

        System.out.print("Indtast player2 navn: ");
        player[1] = input.next();

        System.out.print("Hvad vil i spille til? ");
        limit = input.nextInt();
        System.out.println("");

        while (totalPlayer[0] < limit || totalPlayer[1] < limit) {
            playPig();
        }

    }

    private static void playPig() {
        System.out.println(player[whichTurn] + "'s tur:     " + totalPlayer[whichTurn] + " point");

        System.out.print("Rul en terning? ('ja/nej') ");

        Scanner input = new Scanner(System.in);
        answer = input.nextLine();

        int sum = 0;
        while (!answer.equals("nej")) {

            int face = rollDie();
            System.out.println("Du rullede: " + face);
            System.out.println();
            if (face != 1){
                sum += face;

                System.out.print("Rul en terning? ('ja/nej') ");
                answer = input.nextLine();
                if(answer.equals("nej")){
                    totalPlayer[whichTurn] += sum;
                    System.out.println(player[whichTurn]+ " har " + totalPlayer[whichTurn] + " point \n ------- \n -------");

                    if (totalPlayer[whichTurn] >= limit){
                        System.out.println("Tillykke " + player[whichTurn] + ", du har vundet");

                        System.out.print("Vil i spille igen? ('ja/nej') ");
                        answer = input.nextLine();
                        if (answer.equals("ja")) {
                            restartGame();
                        }
                    }
                }

            }
            else {
                System.out.println("Du mistede dine point :( \n ------- \n -------");
                answer = "nej";
            }
        }
        updateStatistics();
        updateTurn();
    }

    private static int rollDie(){
        return (int) (Math.random() * 6 + 1);
    }

    private static void updateStatistics() {
        rollCount++;
    }

    private static void updateTurn() {
        //which turn kan kun være 0 eller 1.
        //0 er player1 og 1 er player2
        whichTurn++;
        whichTurn = whichTurn % 2;
    }

    private static void restartGame() {
        rollCount = -1;
        whichTurn = -1;
        totalPlayer[0] = 0;
        totalPlayer[1] = 0;
        answer = "nej";
        System.out.println("----- NEW GAME -----");
        System.out.println("----- NEW GAME -----");
        System.out.println("----- NEW GAME -----");
    }


}
