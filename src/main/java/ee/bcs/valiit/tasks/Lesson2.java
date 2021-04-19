package ee.bcs.valiit.tasks;

import java.util.Arrays;

import java.util.Scanner;

public class Lesson2 {



    /*
    //TESTIKS KASUTATAVA JADA JA elementideArv funktsioonid
    public static int elementideArv() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Sisesta täisarv, kui mitu elementi sa soovid,et massiivis oleks.");
        //Selleks, et sisestataks numbri, on Gestapo, kes kontrollib
        while (!scan.hasNextInt()) {
            System.out.println("Ei, nalja teed v, täisarv plz");
            scan.nextLine();
        }
        //Sisestatav number, mis pärast tagastatakse funktsiooni elementideArv
        int number = scan.nextInt();
        return number;
    }
    public static int[] jada(int number) {
        Scanner scanner = new Scanner(System.in);
        //jada input määrab, kui palju numbreid on selles
        int[] array = new int[number];
        //Sõltuvalt inputist, mille töötlesin ümber array.lengthiks palume kasutajal sisestada numbreid
        for (int i = 0; i < array.length; i++) {
            System.out.println("Sisesta täisarv.");
            while (!scanner.hasNextInt()) {
                System.out.println("CMON SIMMO, täisarv");
                scanner.nextLine();
            }
            array[i] = scanner.nextInt();
        }
        //tagastab funktsiooni numbrid, mille kasutaja sisestas massiivi.
        return array;
    }


     */

    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks

        //System.out.println(sequence3n(1, 1));
        //System.out.println(fibonacci(11));

        //************************************************************************************************************************************************************************************************
        //Testiks ise sisse trükitav ARRAY
        //int number = elementideArv();
        //int[] x = jada(number);
        //System.out.println(Arrays.toString(x));
        //************************************************************************************************************************************************************************************************
        //Valmis tehtud ARRAY, mida vajadusel kasutada testis:
        //int testArray[] = {6, 3, 4, 7, 9};
        //System.out.println(Arrays.toString(testArray));
        //System.out.println((min(testArray)));
        //*************************************************************************************************************************************************************************************************
        //ReverseArray test. Input on testArray
        //uus massiiv mille lõin panen reverseArray sisendiks, mis funktsioonis võrdub inputArrayga
        //System.out.println(Arrays.toString(reverseArray(testArray)));
        //System.out.println("tere");
        //*************************************************************************************************************************************************************************************************
        //Paaritute numbrite test. input on paaritute numbrite arv, mida kuvatakse.
        // Näide: Sisend 5 -> Väljund 2 4 6 8 10
        System.out.println(Arrays.toString(evenNumbers(5)));
        //*************************************************************************************************************************************************************************************************
        //min numbri test.
        //System.out.println(min(x));
        //***************************************************************************************************************************************************************************************************
        //max numbri test.
        //System.out.println(max(x));
        //***************************************************************************************************************************************************************************************************
        //summmma test
        //System.out.println(sum(x));
    }

    //*******************************************************************************************************************************************************************************************************
    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    public static int[] reverseArray(int[] inputArray) {
        //defineerin üleval loodud massiivi pikkuse, mis sisestasin inputi läbi testArray
        int arrayLenght = inputArray.length;
        //sain pikkuseks 4 alustades nullist.
        int[] newArray = new int[arrayLenght];
        //alustan massiivi loendust eelmise lõpust ning panen vastavusse inputi viimase
        for (int i = arrayLenght; i > 0; i--) {
            newArray[i - 1] = inputArray[arrayLenght - i];
            //kui i= 5 siis  newArray 5-1   4  ja siis inputarray on 5-5 0
        }
        return newArray;
    }

    //*********************************************************************************************************************************************************************************************************
    // TODO EVENNUMBERSEVENNUMBERSEVENNUMBERSEVENNUMBERSEVENNUMBERSEVENNUMBERSEVENNUMBERSEVENNUMBERSEVENNUMBERSEVENNUMBERSEVENNUMBERSEVENNUMBERSEVENNUMBERSEVENNUMBERS
    //tagasta massiiv mis sisaldab n esimest paaris arvu
    public static int[] evenNumbers(int n) {
        int[] returnArray = new int[n];
        for (int i = 0; i < n; i++) {
            returnArray[i] = (i + 1) * 2;
        }
        return returnArray;
    }

    //***********************************************************************************************************************************************************************************************************
    //TODO MINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMINMIN
    //leia massiivi kõige väiksem element
    //loon funktsiooni leidmaks väikseim element
    public static int min(int[] x) {
        int minElement = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] < minElement) {
                minElement = x[i];
            }
        }
        return minElement;
    }

    //**********************************************************************************************************************************************************************************************************
    // TODO MAXMAXMAXMAXMAXMAXMAXMAXMAXMAXMAMXAMMXAMXMAMXAMXMAMXAMXMAMXAMMXMAXMMAMXAMXMAMXAMXAMMXMAMXAMXMAMXAMXAMAMXAMMXMAXMMAMXAMXMAMXAMXAMMXMAMXAMXMAMXAMXA
    //leia massiivi kõige suurem element
    public static int max(int[] x) {
        int maxElement = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] > maxElement) {
                maxElement = x[i];
            }
        }
        return maxElement;
    }

    //**********************************************************************************************************************************************************************************************************
    // TODO SUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUMSUM
    //leia massiivi kõigi elementide summa
    public static int sum(int[] x) {
        int sumSumSum = x[0];
        int elements = x.length;
        for (int i = 1; i < elements; i++) {
            sumSumSum = sumSumSum + x[i];
        }
        return sumSumSum;
    }

    //**************************************************************************************************************************************************************************************************************
    // TODO KORRUTUSTABELKORRUTUSTABELKORRUTUSTABELKORRUTUSTABELKORRUTUSTABELKORRUTUSTABELKORRUTUSTABELKORRUTUSTABELKORRUTUSTABELKORRUTUSTABELKORRUTUSTABELKORRUTUSTABELKORRUTUSTABEL
    //trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    //näiteks x = 3 y = 3
    //väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    //TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x);
    //TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println;
    //TODO 3 trüki seda sama rida y korda;
    //TODO 4 Kuskile võiks kirjutada System.out.println(),et saada taebli kuju;
    //TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel mis on ja mis võiks olla;
    public static void multiplyTable(int x, int y) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                System.out.print(i + "*" + j + " ");
            }
            System.out.println();
        }
    }

    //**************************************************************************************************************************************************************************************************************
    // TODO FIBONACIFIBONACIFIBONACIFIBONACIFIBONACIFIBONACIFIBONACIFIBONACIFIBONACIFIBONACIFIBONACIFIBONACIFIBONACIBONACIFIBONACIFIBONACIFIBONACIFIBONACIFIBONACIFIBONACI
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static int fibonacci(int n) {
        int a = 0;
        int b = 1;
        int mitmesElement = 0;
        if (n == 1 || n == 2) {
            mitmesElement = 1;
            return mitmesElement;
        }
        for (int i = 1; i < n; i++) {
            mitmesElement = a + b;
            a = b;
            b = mitmesElement;
            System.out.println("Fibonacci jada asukohas= " + i + " on väärtus = " + mitmesElement);
        }
        return mitmesElement;
    }
    //****************************************************************************************************************************************************************************************************************
    // TODO SEQUENCESEQUENCESEQUENCESEQUENCESEQUENCESEQUENCESEQUENCESEQUENCESEQUENCESEQUENCESEQUENCESEQUENCESEQUENCEQUENCESEQUENCESEQUENCESEQUENCEQUENCESEQUENCESEQUENCESEQUENCE
    // Kujutame ette numbrite jada, kus juhul kui number on paaris arv siis me jagame selle 2-ga
    // Kui number on paaritu arv siis me korrutame selle 3-ga ja liidame 1. (3n+1)
    // Seda tegevust teeme me niikaua kuni me saame vastuseks 1
    // Näiteks kui sisend arv on 22, siis kogu jada oleks:
    // 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // Sellise jada pikkus on 16
    // Kirjutada programm, mis peab leidma kõige pikema jada pikkuse mis jääb kahe täis arvu vahele
    // Näiteks:
    // Sisend 10 20
    // Siis tuleb vaadata, kui pikk jada tuleb kui esimene numbr on 10. Järgmisen tuleb arvutada number 11 jada pikkus.
    // jne. kuni numbrini 20
    // Tagastada tuleb kõige pikem number
    // Näiteks sisendi 10 ja 20 puhul on vastus 20
    public static int sequence3n(int x, int y) {

        int koguJadaPikkus = 0;
        int yheNumbriJadaPikkus = 1;
        int suurimJadaPikkus = 0;
        for (int i = x; i <= y; i++) {
            int result = i;
            System.out.println(" ");
            System.out.println("Nüüd võtame ette järgmise arvu, milleks on:" + result);
            koguJadaPikkus++;
            yheNumbriJadaPikkus++;
            while (result > 1) {
                if(result % 2 == 0){
                    System.out.println("Arvutus= " + result + "/2");
                    result = result /2;
                    if(result==1){
                        System.out.println("vastus= " + result + " See ring toimus toiminguid = " + yheNumbriJadaPikkus);
                        if(yheNumbriJadaPikkus>suurimJadaPikkus){
                            suurimJadaPikkus = yheNumbriJadaPikkus;
                            yheNumbriJadaPikkus = 0;
                        } else{
                            yheNumbriJadaPikkus = 0;
                        }
                        break;
                    }
                } else if (result % 2 == 1){
                    System.out.println("Arvutus= " + result + "*3+1");
                    result = result *3 +1;
                }
                yheNumbriJadaPikkus++;
                koguJadaPikkus++;
                System.out.println("vastus= "+ result + " count= " + koguJadaPikkus);
                System.out.println(" ");
            }
        }
        System.out.println("Suurim toimingute arv = " + suurimJadaPikkus);
        return suurimJadaPikkus+1;
    }


        /*//Kõigepealt vaja luua funktsioon, mis võtab numbri ette ning tuvastab mitu korda ja salvestab selle väärtuse;
        for (int i = x; i>=y; i++) {
            int result = i;
            numberOfActions = 0;
            while (result > 1) {
                if (result % 2 == 0) {
                    result = result / 2;
                    System.out.println(result + " hei");
                    numberOfActions++;
                }
                if (result % 2 != 0) {
                    result = (3 * result) + 1;
                    numberOfActions++;
                }
            }

        }
        System.out.println(numberOfActions + "test");
        //System.out.println("End! For sqeuence 3n x= " + x + " y= " + y + "looped times " + count + " found max nr " + max);
        return numberOfActions;*/
}


//                while (x != 1) {
//                    if (x%2==0){
//                        System.out.println("doing=" + x + "/2");
//                        x = x/2;
//                    }else {
//                        System.out.println("Doing = 3*" + x + "+1" );
//                        x= (3*x+1);
//                    }
//                    System.out.println(", now x =" + x);
//                    System.out.println("loop = "+ count);
//                    if (max < x ) {
//                        max = x;
//                    }
//                    count++;
//                }



    /*Scanner scanner = new Scanner(System.in);
        int leadNumber = 0;
        int count = 0;
        int greatestSubsequent = 0;
        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            if (array[i]>leadNumber) {
                leadNumber = array[i];
                count++;}
            else {
                leadNumber = array[i];
                if(greatestSubsequent<count) { greatestSubsequent = count; }
                count = 1;
            }
        }
        greatestSubsequent = (greatestSubsequent>count) ? greatestSubsequent : count;
        scanner.close();
        System.out.println(greatestSubsequent);

        return greatestSubsequent;


    }

}

     */







/*int numberOfActions = 0;
        int[] arrayOfActions = new int[y-x];
        for (int i = x; i <= y; i++);{
            int result = int i;
            while (result >= 1) {
                if (result % 2 == 0) {
                    result = result / 2;
                    numberOfActions++;
                }
                if (!result % 2 == 0) {
                    result = (3 * result) + 1;
                    numberOfActions++;
                }
            }
            return numberOfActions;

            int arrayIndex = 0;
            arrayOfActions[arrayIndex] = numberOfActions;

            int arrayIndex = 0;
            arrayOfActions[arrayIndex] = numberOfActions;
            arrayIndex++;
        }
return max(arrayOfActions); */