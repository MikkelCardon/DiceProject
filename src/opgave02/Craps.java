package opgave02;
//test
import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Craps {
    public static int rollCount = 0;
    public static boolean stillPlaying = true;
    public static int points = 0;

    public static void main(String[] args) {
        System.out.println("VELKOMMEN TIL CRAPS");
        playCraps();
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

                }
                else if(sum == 2 || sum == 3 || sum == 12){
                    System.out.println("DU TABER");

                }
                else{
                    points = sum;
                    System.out.println("Dine points er nu " + sum);

                    while(stillPlaying) {
                        System.out.print("Rul igen? ('ja/nej') ");
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
        }
        else if(sum == points){
            System.out.println("Du har vundet");
            stillPlaying = false;
        }

    }
}