Jeres `playPig()` metode er blevet ret stor og dermed svær at læse. Forsøg at bryde den ned i mindre metoder.

---

I lægger ikke `tempValue` til `totalPlayer` så selv om man siger nej til at spille igen, kan man ikke komme ud af følgende løkke.

        while (totalPlayer[0] < limit || totalPlayer[1] < limit) {
            playPig();
        }

---
