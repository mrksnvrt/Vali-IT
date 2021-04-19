package ee.bcs.valiit.tasks;

import java.lang.*;
import java.io.*;
import java.util.*;

public class Lesson3 {

    public static void main(String[] args) {
        //System.out.println(factorial(5));
        //System.out.println(reverseString("tere"));
        //System.out.println(isPrime(2));
        //System.out.println(evenFibonacci(50));
        System.out.println(morseCode("sos"));


        //int testArray[] = {6, 2, 7, 3, 1};
        //System.out.println(Arrays.toString(testArray));
        //System.out.println(Arrays.toString(sort(testArray)));

    }

    //******************************************************************************************
    // TODO SUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUM
    //  tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) {
        int sum = 1;
        for (int i = x; i > 0; i--) {
            sum *= i;
        }
        return sum;
    }

    //***************************************************************************************************************
    // TODO tagasta string tagurpidi
    public static String reverseString(String a) {
        char[] letters = new char[a.length()];
        int letterInIndex = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            letters[letterInIndex] = a.charAt(i);
            letterInIndex++;
        }
        String reverse = "";
        for (int i = 0; i < a.length(); i++) {
            reverse = reverse + letters[i];
        }
        return reverse;
    }

    //***************************************************************************************************************
    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                System.out.println("arv " + x + " jagub " + i + " -ga, seega ei sobi");
                return false;
            }
        }
        return true;
    }

    //****************************************************************************************************************
    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    public static int[] sort(int[] a) {
        //defineerin massiivi pikkuse, mis sisestatakse inputi
        int arrayLenght = a.length - 1;
        for (int i = 0; i < arrayLenght; i ++){
            for (int j = 0; j < arrayLenght; j ++){
                if (a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j +1 ];
                    a[j+1] = temp;
                }
            }
        }
        return a;



//        /*int[] massiivMidaSorteerin = new int[arrayLenght];
//        int minElement = a[0];
//        //alustan massiivi loendust. Pikkus on arraylenght.
//        for (int i = 0; i > arrayLenght; i++) {
//            if (a[i] <= minElement) {
//                minElement = a[i];
//            }
//
//
//            //Nüüd ma soovin võrrelda massiivi erinevaid väärtusi, ning tagastada alates väikseimast
//            //while (massiivMidaSorteerin[i] < massiivMidaSorteerin[i+1]{
//
//        }
//        return massiivMidaSorteerin;*/
//
//
//        //massiivMidaSorteerin[i - 1] = a.length[arrayLenght - i];
//        //kui i= 5 siis  massiivMidaSorteerin 5-1   4  ja siis inputarray on 5-5 0
    }



    //***************************************************************************************************************************
    // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
    public static int evenFibonacci(int x) {
        int esimeneArv = 0;
        int teineArv = 1;
        int paarisArvudeKoguSumma = 0;
        for (int i = 2; i <= x; i++) {
            int järgmineArv = esimeneArv + teineArv;
            esimeneArv = teineArv;
            teineArv = järgmineArv;
            if (järgmineArv > x) {
                System.out.println("Kogu Fibonacci rea paarisarvude summa on " + paarisArvudeKoguSumma);
                return paarisArvudeKoguSumma;
            }
            if (teineArv % 2 == 0) {
                System.out.println("Fibonacci reas kuni arvuni=  " + x + " on üks paarisarv= " + teineArv);
                if (teineArv > paarisArvudeKoguSumma) {
                    paarisArvudeKoguSumma = paarisArvudeKoguSumma + teineArv;
                }
            }
        }
        return paarisArvudeKoguSumma;
    }
    //************************************************************************************************************************
    // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
    // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga

    public static String morseCode(String text) {

        //Sissetulev tekst
        System.out.println(text);
        //Loon Mapi, mille esimene tulp on char ja teine rida string
        Map<Character, String> morse = new HashMap<>();
        morse.put('e', ".");
        morse.put('h', "....");
        morse.put('l', ".-..");
        morse.put('o', "---");
        morse.put('s', "...");
        //Selleks, et sissetuleva teksti igale tähele morse tähis saada, converdin ta char andmetüüpi arrays.
        char [] array = text.toCharArray();
        //Loon tühja Stringi, kuhu hakkan sisendlause iga tähele vastavaid sümboleid välja trükkima
        String sisestatudLause = "";
        //Array algab nullist, seega esimene sisestatud täht [0] ja iga järgnev +1 kuni array.lenght - 1
        int lauseAlgus = 0;
        int lauseLõpp = array.length;
        while (lauseLõpp > lauseAlgus) {
            //morse.get võtab mapist väärtuse kus on igal charil enda
            System.out.println(array[lauseAlgus] + " = " + morse.get(array[lauseAlgus]) + " ");
            sisestatudLause = sisestatudLause + morse.get(array[lauseAlgus]) + " ";
            lauseAlgus++;
        }
        return sisestatudLause.trim();
    }
}
