I har misforstået opgaven lidt, det var ikke meningen at I skulle huske alle terningeslagene. Hvilket har kompliseret koden for jer.

---

Følgende linjers kode

        for (int i = rollCount; i < rollCount + 2; i++) {
            for (int j = 0; j < eyeCount.length; j++) {
                if (face[i] == eyePossibilities[j]) {
                    eyeCount[j]++;
                }
            }
        }

kan reduceres til

    eyeCount[face[rollCount] - 1]++;
    eyeCount[face[rollCount + 1] - 1]++;

---

Dette

    for (int i = 0; i < eyeCount.length; i++) {
        System.out.println("Antal " + eyePossibilities[i] + "'ere = " + eyeCount[i]);
    }

kan reduceres til

    for (int i = 0; i < eyeCount.length; i++) {
        System.out.println("Antal " + (i + 1) + "'ere = " + eyeCount[i]);
    }

og så behøver I ikke 

    private static int[] eyePossibilities = {1, 2, 3, 4, 5, 6};
