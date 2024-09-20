package opgave02;

import java.util.Scanner;

public class Craps {
    public static int rollCount = 0;
    public static boolean stillPlaying = true;
    public static int points = 0;
    public static int[] WinAndLoss= {0, 0};

    public static void main(String[] args) {
        System.out.println("VELKOMMEN TIL CRAPS");

        playCraps();

        if (stillPlaying == false){
            System.out.println("Vundet: " + WinAndLoss[0] + " --- Tabt: " + WinAndLoss[1]);
        }
    }


    private static void playCraps() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul en terning? ('ja/nej') ");
        String answer = scanner.nextLine();

            //face skal være et array. for at få begge terninger i og i+1.
            int sum = rollDice();
            System.out.println("Du rullede: " + sum);
            System.out.println();
            if (rollCount == 0){
                if (sum == 7 || sum == 11){
                    System.out.println("DU VINDER");
                    WinAndLoss[0]++;
                    restartGame();
                }
                else if(sum == 2 || sum == 3 || sum == 12){
                    System.out.println("DU TABER");
                    WinAndLoss[1]++;
                    restartGame();
                }
                else{
                    points = sum;
                    System.out.println("Dine points er nu " + sum);

                    while(stillPlaying) {
                        System.out.print("Rul igen? ('ja) ");
                        answer = scanner.nextLine();
                        rollForPoints(rollDice());
                    }
                }
            }
        scanner.close();
    }


    public static int rollDice() {
        int[] dice = new int[1000];
        int sum = 0;

        dice[rollCount] =  (int) (Math.random() * 6 + 1);
        dice[rollCount+1] =  (int) (Math.random() * 6 + 1);

        return sum = dice[rollCount] + dice[rollCount+1];
    }


    public static void rollForPoints(int sum){
        System.out.println(" \n Du slog " + sum);
        if(sum == 7){
            System.out.println("Du har tabt");
            stillPlaying = false;
            WinAndLoss[1]++;
            restartGame();
        }
        else if(sum == points){
            System.out.println("Du har vundet");
            stillPlaying = false;
            WinAndLoss[0]++;
            restartGame();
        }

    }
    private static void restartGame() {
        Scanner input = new Scanner(System.in);

        System.out.print("Vil i spille igen? ('ja/nej') ");
        String answer = input.nextLine();
        if (!answer.equals("nej")) {
            points = 0;
            rollCount = 0;
            stillPlaying = true;

            System.out.println("----- NEW GAME -----");
            System.out.println("----- NEW GAME -----");
            System.out.println("----- NEW GAME -----");
            playCraps();
        }
    }
}