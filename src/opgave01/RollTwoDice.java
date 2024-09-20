package opgave01;
//test
import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int rollTotal = 0;
    private static int rollSame = 0;
    private static int rollBiggestTotal = 0;
    private static int[] eyePossibilities = {1, 2, 3, 4, 5, 6};
    private static int[] eyeCount = new int[6];

    public static void main(String[] args) {
        System.out.println("Velkommen til spillet, rul en terning.");
        printRules();
        System.out.println();

        playTwoDice();

        System.out.println();
        System.out.println("Tak for at spille, rul en terning.");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for rul en terning");
        System.out.println("Spilleren ruller en terning, så længde man lyster.");
        System.out.println("=====================================================");
    }

    private static void playTwoDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul en terning? ('ja/nej') ");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {

            //face skal være et array. for at få begge terninger i og i+1.
            int[] face = rollDice();
            System.out.println("Du rullede: " + face[rollCount] + " og " + face[rollCount+1]);
            System.out.println();

            updateStatistics(face);

            System.out.print("Rul en terning? ('ja/nej') ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    public static int[] rollDice() {
        int[] dice = new int[1000];

        dice[rollCount] =  (int) (Math.random() * 6 + 1);
        dice[rollCount+1] =  (int) (Math.random() * 6 + 1);

        return dice;
    }

    private static void updateStatistics(int[] face) {
        if(face[rollCount] == face[rollCount+1]){
            rollSame++;
        }
        if(face[rollCount]+face[rollCount+1] > rollBiggestTotal){
            rollBiggestTotal = face[rollCount]+face[rollCount+1];
        }

            for (int i = rollCount; i < rollCount+2; i++) {
                for (int j = 0; j < eyeCount.length; j++) {
                    if (face[i] == eyePossibilities[j]){
                        eyeCount[j]++;
                    }
                }
            }

        rollTotal += face[rollCount]+face[rollCount+1];
        rollCount ++;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Antal rul:", rollCount);
        System.out.printf("%17s %4d\n", "Total sum:", rollTotal);
        System.out.printf("%17s %4d\n", "Antal to ens:", rollSame);
        System.out.printf("%17s %4d\n", "Største sum:", rollBiggestTotal);

        for (int i = 0; i < eyeCount.length; i++) {
            System.out.println("Antal " + eyePossibilities[i] + "'ere = " + eyeCount[i]);
        }
    }

}
