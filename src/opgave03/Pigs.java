package opgave03;
import java.util.Scanner;

public class Pigs {
    public static String[] player = new String[2];
    public static int[] rollCount = new int[2];
    public static String answer;

    //When whichTurn is even = player1 -- uneven = player2
    public static int whichTurn = 0;
    public static int[] totalPlayer = {0 ,0};
    public static int limit;
    public static int[] turns = {1, 1};
    public  static int tempValue = 0;


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
        tempValue = totalPlayer[whichTurn];

        System.out.print("Rul en terning? ('ja/nej') ");

        Scanner input = new Scanner(System.in);
        answer = input.nextLine();

        int sum = 0;
        while (!answer.equals("nej")) {


            int[] face = rollDice();
            tempValue += face[0]+face[1];

            System.out.println("Du rullede: " + face[0] + " og " + face[1]);

            if (face[0] == 1 && face[1] == 1) {
                System.out.println("DU MISTEDE ALLE DINE POINT!!!! \n ------- \n -------");
                answer = "nej";
                totalPlayer[whichTurn] = 0;
                updateStatistics();
            }
            else if (face[0] == 1 || face[1] == 1){
                System.out.println("Du mistede dine point :( \n ------- \n -------");
                answer = "nej";
                updateStatistics();
            }
            else if (tempValue < limit){
                sum += face[0] + face[1];

                System.out.print("Rul en terning? ('ja/nej') ");
                answer = input.nextLine();
                updateStatistics();

                if(answer.equals("nej")){
                    totalPlayer[whichTurn] += sum;
                    System.out.println(player[whichTurn]+ " har " + totalPlayer[whichTurn] + " point \n ------- \n -------");

                    if (totalPlayer[whichTurn] >= limit){
                        System.out.println("---------------");
                        System.out.println("Tillykke " + player[whichTurn] + ", du har vundet" + totalPlayer[whichTurn]);


                        System.out.print("Vil i spille igen? ('ja/nej') ");
                        answer = input.nextLine();
                        if (answer.equals("ja")) {
                            restartGame();
                        }
                        else if(answer.equals("nej")){
                            printStatistics();
                        }
                    }
                }

            }
            else if(tempValue >= limit) {
                System.out.println("---------------");
                System.out.println("Tillykke " + player[whichTurn] + ", du har vundet med " + tempValue);


                System.out.print("Vil i spille igen? ('ja/nej') ");
                answer = input.nextLine();
                if (answer.equals("ja")) {
                    restartGame();
                }
                else if(answer.equals("nej")){
                    printStatistics();
                }
            }
        }
        turns[whichTurn]++;
        updateTurn();
    }

    private static int[] rollDice(){
        int[] dice = new int[2];
        dice[0] = (int) (Math.random() * 6 + 1);
        dice[1] = (int) (Math.random() * 6 + 1);

        return dice;
    }

    private static void updateStatistics() {
        rollCount[whichTurn]++;
    }

    private static void printStatistics() {
        System.out.println("Stats fra runden: ");
        System.out.println(player[0] + "'s gennesnit " + 1.0 * rollCount[0] / turns[0]);
        System.out.println(player[1] + "'s gennesnit " + 1.0 * rollCount[1] / turns[1]);
    }

    private static void updateTurn() {
        //which turn kan kun være 0 eller 1.
        //0 er player1 og 1 er player2
        whichTurn++;
        whichTurn = whichTurn % 2;
    }

    private static void restartGame() {
        whichTurn = 0;
        totalPlayer[0] = 0;
        totalPlayer[1] = 0;
        tempValue = 0;
        answer = "nej";
        System.out.println("----- NEW GAME -----");
        System.out.println("----- NEW GAME -----");
        System.out.println("----- NEW GAME -----");
    }


}
