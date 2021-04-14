package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2b {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(exercise1(5)));
        System.out.println(Arrays.toString(sampleArray()));
        System.out.println(Arrays.toString(generateArray(5)));
        System.out.println(Arrays.toString(decreasingArray(-4)));
        System.out.println(Arrays.toString(yl3(5)));



    }
    //******************************************************************************************************************
    // TODO EXERCISE1EXERCISE1EXERCISE1EXERCISE1EXERCISE1EXERCISE1EXERCISE1EXERCISE1EXERCISE1EXERCISE1EXERCISE1EXERCISE1
    //trüki välja n arvu
    // näiteks
    // sisend: 5
    // trüki välja: 1 2 3 4 5
    public static int[] exercise1(int n){
        int [] nArvuValja = new int[n];
        for (int i=0; i < n; i++){
            nArvuValja[i] = i + 1;
        }
        return nArvuValja;
    }
    //********************************************************************************************************************
    // TODO sampleArraysampleArraysampleArraysampleArraysampleArraysampleArraysampleArraysampleArraysampleArraysampleArray
    //tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray(){
        int[] viisArvuValja = new int [5];
        for (int i=0; i < viisArvuValja.length; i++){
            viisArvuValja[i] = i+1;
        }
        return viisArvuValja;
    }
    //***************************************************************************************************************************
    // TODO generateArraygenerateArraygenerateArraygenerateArraygenerateArraygenerateArraygenerateArraygenerateArraygenerateArray
    //loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}

    public static int[] generateArray(int n){
        int [] genereerinMassiivi = new int [n];
        for (int i=0; i < n; i++){
            genereerinMassiivi[i] = i+1;
        }
        return genereerinMassiivi;
    }
    //*****************************************************************************************************************************
    // TODO decreasingArraydecreasingArraydecreasingArraydecreasingArraydecreasingArraydecreasingArraydecreasingArraydecreasingArray
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n){
        if(n>0) {
            int[] massiiv = new int [n+1];
            for(int i=0; i < n; i++){
            massiiv[i] = n-i;
        }
        return massiiv;
        } else {
            int[] massiiv = new int [-n+1];
            for(int i=0; i<-n; i++){
                massiiv[i] = n+i;
            }
            return massiiv;
        }
    }
    //*************************************************************************************************************************
    // TODO yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3yl3
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n){
        int [] miksKoikKolmed =  new int [n];
        for(int i=0; i < n; i++){
            miksKoikKolmed[i]=3;
        }
        return miksKoikKolmed;
    }
}
