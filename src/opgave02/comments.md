Variabler skal starte med lille forbogstav

    public static int[] WinAndLoss= {0, 0};

og jeg ville fortrække at I bruge to variabler.

    public static int wins = 0;
    public static int losses = 0;

---

I jeres `restartGame()` metode laver I en ny Scanner hver gang metoden bliver kaldt.

        Scanner input = new Scanner(System.in);

Det kan føre til problemer, sørg for at lukke den igen i slutningen af metoden med 

        input.close();

eller lav en felt variabel og genbrug samme Scanner i hele programmet. 

---

        if (stillPlaying == false)

kan reduceres til

        if (stillPlaying)

---

I `playCraps()` metoden spørger I om man skal rulle en terning

        System.out.print("Rul en terning? ('ja/nej') ");
        String answer = scanner.nextLine();

men I bruger ikke svaret!

---

        return sum = dice[rollCount] + dice[rollCount+1];

er det samme som

        return dice[rollCount] + dice[rollCount+1];