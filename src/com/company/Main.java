package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("==========Aufgabe1 =============");
        //1.1
        int[] noten = {29,40, 38, 56, 68};
        int[] schlechteNoten = schlechteNoten(noten);
        System.out.println("Die schlechte Noten sind: ");
        for (int i = 0; i < schlechteNoten.length; i++){
            System.out.println(schlechteNoten[i]);
        }
        //1.2
        System.out.println("Die Medien ist: " + average(noten));
        //1.3
        System.out.println("Die abgerundete Noten sind: " );
        for (int j = 0; j < abgerNoten(noten).length; j++){
            System.out.println(abgerNoten(noten)[j]);
        }
        //1.4
        System.out.println("Die maximale Note ist: " + maximaleAbgNote(noten));
        System.out.println("==========Aufgabe2 =============");
        //2.1
        System.out.println("Die maximale Zahl ist: " + maxZahl(noten));
        //2.2
        System.out.println("Die minimale Zahl ist: " + minZahl(noten));
        //2.3
        System.out.println("Die maximale Summe ist: " + maxSumme(noten));
        //2.4
        System.out.println("Die minimale Summe ist: " + minSumme(noten));
        System.out.println("==========Aufgabe3 =============");
        //3.1
        System.out.println("Summe: " + summe(noten, noten));
        //3.2
        System.out.println("Differenz: " + differenz(noten, noten));
        //3.3
        System.out.println("Multiplikation: " + mul(new int[]{2,5,0,0}, 2));
        //3.4
        System.out.println("Division: " + div(new int[]{2,5,0,0}, 2));
        System.out.println("==========Aufgabe4 =============");
        int[] tastatur = {40, 35, 70, 15, 45};
        int[] usb = {20, 15, 40};
        //4.1
        System.out.println("Die billigste Tastatur ist: " + billigsteTastatur(tastatur));
        //4.2
        System.out.println("Die teuerste Gegenstand ist: " + teuerstenGegenstand(tastatur, usb));
        //4.3
        System.out.println("Die teuerste USB ist: " + budget(usb, 25));
        //4.4
        System.out.println("Die maximale Geldbetrag ist: " + geldbetrag(tastatur, usb, 60));



    }
    //Aufgabe1

    /**
     *
     * @param noten notele din array
     * @return notele care nu sunt de trecere
     */
    public static int[] schlechteNoten(int[] noten){
        List<Integer> endeNoten = new ArrayList<>(); //cream o lista goala
        for(int i=0; i < noten.length; i++){
            if (noten[i] < 38){
                endeNoten.add(noten[i]);
            }
        }
        int[] endeNotenArray = new int[endeNoten.size()];
        for(int j = 0; j < endeNoten.size(); j++){
            endeNotenArray[j] = endeNoten.get(j);
        }
        return endeNotenArray;
    }

    /**
     *
     * @param noten notele din array
     * @return media aritmetica a notelor
     */
    public static double average(int[] noten){
        int total = 0;
        for ( int i=0; i < noten.length; i++){
            total += noten[i];
        }
        return total / noten.length;
    }

    /**
     *
     * @param noten arrayul cu note
     * @return notele finale dupa rotunjire
     */
    public static int[] abgerNoten(int[] noten){
        List<Integer> endeNotenList = new ArrayList<>(); //cream o lista goala
        for(int i=0; i < noten.length; i++) {
            if(noten[i] < 38){ //verificam daca notele sunt mai mici de 38 pentru a nu le rotunji
                endeNotenList.add(noten[i]);
            }
            if (noten[i] >= 38 && (noten[i] % 5) > 2){
                int result = noten[i]-(noten[i] % 5) + 5; //rotunjim notele peste 38 si care au restul mai mare decat 2
                endeNotenList.add(result);
            }
            if (noten[i] >= 38 && (noten[i] % 5) < 3){
                endeNotenList.add(noten[i]);
            }
        }
        int[] endeNotenArray = new int[endeNotenList.size()];
        for(int j = 0; j < endeNotenList.size(); j++){
            endeNotenArray[j] = endeNotenList.get(j);
        }
        return endeNotenArray;
    }


    /**
     *
     * @param noten notele din array
     * @return cea mai mare nota dupa rotunjire
     */
    public static int maximaleAbgNote(int[] noten) {
        List<Integer> endeNotenList = new ArrayList<>(); //cream o lista goala
        for (int i = 0; i < noten.length; i++) {
            if (noten[i] >= 38 && (noten[i] % 5) > 2) {
                int result = noten[i] - (noten[i] % 5) + 5;
                endeNotenList.add(result);
            }
        }
        return Collections.max(endeNotenList);
    }


    //Aufgabe2

    /**
     *
     * @param zahlen numerele din array
     * @return cel mai mare numar
     */
    public static int maxZahl(int[] zahlen){
        int max = zahlen[0]; // elementul de pe pozitia [0] a arrayului zahlen
        for(int i = 0; i < zahlen.length; i++){
            if(max < zahlen[i]){
                max = zahlen[i];
            }
        }
        return max;

    }


    /**
     *
     * @param zahlen numerele din array
     * @return cel mai mic numar
     */
    public static int minZahl(int[] zahlen){
        int min = zahlen[0]; // elementul de pe pozitia [0] a arrayului zahlen
        for(int i = 0; i < zahlen.length; i++){
            if(min > zahlen[i]){
                min = zahlen[i];
            }
        }
        return min;
    }


    /**
     *
     * @param zahlen numerele din array
     * @return suma dintre cele mai mari n-1 numere din array
     */
    public static int maxSumme(int[] zahlen){
        Arrays.sort(zahlen); //sortam in ordine crescatoare
        int maxSumme = 0;
        for(int i = 1; i < zahlen.length; i++){
            maxSumme += zahlen[i];
        }
        return maxSumme;
    }


    /**
     *
     * @param zahlen numerele din array
     * @return suma dintre cele mai mici n-1 numere din array
     */
    public static int minSumme(int[] zahlen){
        Arrays.sort(zahlen); //sortam in ordine crescatoare
        int minSumme = 0;
        for(int i = 0; i < zahlen.length-1; i++){
            minSumme += zahlen[i];
        }
        return minSumme;
    }



    //Aufgabe3

    /**
     *
     * @param a primul array cu cifre
     * @param b al doilea array cu cifre
     * @return suma dintre cele doua array uri care va fi un numar, nu un array
     */
    public static long summe(int[] a, int[] b){
        String aa = "";
        String bb = "";
        for(int i = 0; i < a.length; i++){
            aa += a[i];
        }
        for(int j = 0; j < b.length; j++){
            bb += b[j];
        }
        return Long.parseLong(aa) + Long.parseLong(bb);
    }


    public static long differenz(int[] a, int[] b){
        String aa = "";
        String bb = "";
        for(int i = 0; i < a.length; i++){
            aa += a[i];
        }
        for(int j = 0; j < b.length; j++){
            bb += b[j];
        }
        return Long.parseLong(aa) - Long.parseLong(bb);
    }


    /**
     *
     * @param a array cu cifre
     * @param b cifra
     * @return rezultatul inmultirii dintre array si cifra
     */
    public static long mul(int[] a, int b){
        String aa = "";
        for(int i = 0; i < a.length; i++){
            aa += a[i];
        }
        return Long.parseLong(aa) * b;
    }


    public static int div(int[] a, int b){
        String aa = "";
        for(int i = 0; i < a.length; i++){
            aa += a[i];
        }

        return Integer.parseInt(aa) / b;
    }




    //Aufgabe4

    /**
     *
     * @param preis array ul de preturi ale tastaturilor
     * @return valoarea celei mai ieftine tastaturi
     */

    public static int billigsteTastatur(int[] preis){
        int min = preis[0];
        for(int i = 0; i < preis.length; i++){
            if (min > preis[i])
                min = preis[i];
        }
        return min;
    }


    /**
     *
     * @param tastatur array ul cu preturile tastaturilor
     * @param usb arrayul cu preturile usb urilor
     * @return cel mai scump aparat
     */
    public static int teuerstenGegenstand(int[] tastatur, int[] usb){
        int maxT = tastatur[0];
        int maxU = usb[0];
        for (int i = 0; i < tastatur.length; i++){ //aflam care e cea mai scumpa tastatura
            if (maxT < tastatur[i])
                maxT = tastatur[i];
        }
        for (int j = 1; j < usb.length; j++) { //aflam care e cel mai scump usb
            if (maxU < usb[j])
                maxU = usb[j];
        }
        if (maxT > maxU) //aflam cel mai scump aparat dintre cea mai scumpa tastatura si cel mai scump usb
            return maxT;
        else
            return maxU;

    }


    /**
     *
     * @param a lista cu preturile usb urilor
     * @param b bugetul alocat
     * @return cel mai scump usb care se incadreaza in buget sau -1 daca nu se incadreaza
     */
    public static int budget(int[] a, int b){
        Arrays.sort(a);
        for (int i = a.length - 1; i >= 0; i--)
            if (a[i] <= b)
                return a[i];
            return -1;
    }


    /**
     *
     * @param tastaturen lista de preturi a tastaturilor
     * @param usb lista de preturi a usb urilor
     * @param budget bugetul alocat
     * @return suma cea mai mare dintre o tastatura si un usb
     */
    public static int geldbetrag(int[] tastaturen, int[] usb, int budget){
        List<Integer> summe = new ArrayList<>();
        //luam pe rand fiecare tastatura cu fiecare usb pentru a vedea daca se incadreaza in buget
        for (int i = 0; i < tastaturen.length; i++){
            int tastaturenPreis = tastaturen[i];
            for (int j = 0; j < usb.length; j++){
                int total = tastaturenPreis + usb[j];
                if(total <= budget){
                    summe.add(total);
                }
            }
        }
        if (summe.size() > 0)
            return Collections.max(summe);
        return -1;

    }





}

