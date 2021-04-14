package ee.bcs.valiit.tests;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {

        System.out.println(onSelgevoiEiOleSelge(3));
        System.out.println(onSelgevoiEiOleSelge(21));
        int testArray[] = {6, 2, 7, 3, 1};
        //System.out.println(Arrays.toString(addToArray(testArray,2));
        System.out.println(Arrays.toString(addToArray(new int []{3,4,5},3)));
        //System.out.println(Arrays.toString(addToArray({},4)));
    }
//ÜL 1
//Tee funktsioon, mis tagastab boolean väärtuse ja võtab sisse ühe parameetri
//funktsioon peab tagastama
//true: kui sisend parameeter jagub 3 või 7 (aga ei jagu mõlema numbriga)
//false: kui sisend parameeter ei jagu 3 ega 7 või jagub mõlema numbriga

    public static boolean onSelgevoiEiOleSelge(int kasSeePeaksArvOlemaV){
        boolean jagubVoiEiJaguSellesOnKüsimus = true;
        if(kasSeePeaksArvOlemaV % 3 == 0 || kasSeePeaksArvOlemaV % 7 == 0) {
            if(kasSeePeaksArvOlemaV % 3 == 0 && kasSeePeaksArvOlemaV % 7 == 0){
                return false;
            }
            return true;
        }
        return false;
    }


    // ÜL2
    // lisa x igale array elemendile
    // Näiteks
    // sisend [1,2,3], 5
    // vastus [6,7,8]
    public static int[] addToArray(int[] array, int x){
        int arrayLenght = array.length;
        for(int i = 0; i < arrayLenght; i++){
            array[i] = array[i]+x;
        }
        return array;
    }

    public static int[] funktsioon(int[]votabSisse){
        //tagastab esimese väärtuse, mis on 0

        votabSisse[0] = 0;
        return votabSisse;
    }
}
