package ee.bcs.valiit.tasks;

import ee.bcs.valiit.solution.SolutionLesson1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit

@RestController
public class Lesson1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Numbrifunktsioonide test \n" +
                "0 - tagasta kahest arvust väiksem; \n" +
                "1 - tagasta kahest arvust max; \n" +
                "2 - tagasta absoluutväärtus \n" +
                "3 - tagasta ainult paaris arv \n" +
                "4 - tagasta kolmest arvust väikseim \n" +
                "5 - tagasta kolmest arvust suurim \n");
        int num = scanner.nextInt();
        scanner.nextLine();
        switch (num){
            case 0:
                System.out.println("Sisesta esimene täisarv:");
                int a = scanner.nextInt();
                System.out.println("Sisesta teine täisarv");
                int b = scanner.nextInt();
                System.out.println("väiksem arv on: " + min(a,b));
                break;

            case 1:
                System.out.println("Sisesta esimene täisarv:");
                int amx = scanner.nextInt();
                System.out.println("Sisesta teine täisarv:");
                int bmx = scanner.nextInt();
                System.out.println("Suurem täisarv on: " + max(amx,bmx));
                break;

            case 2:
                System.out.println("Sisesta täisarv");
                int aabs = scanner.nextInt();
                System.out.println(abs(aabs));
                break;
            case 3:
                System.out.println("Sisesta täisarv");
                int aIsE = scanner.nextInt();
                if(isEven(aIsE)) {
                    System.out.println("Jah" + isEven(aIsE));
                } else {
                    System.out.println("Ei");
                }
                break;
            case 4:
                System.out.println("Sisesta esimene täisarv");
                int mina = scanner.nextInt();
                System.out.println("Sisesta teine täisarv");
                int minb = scanner.nextInt();
                System.out.println("Sisesta kolmas täisarv");
                int minc = scanner.nextInt();
                System.out.println("Nendest kolmest arvust oli kõige väiksem " + min3(mina, minb, minc));
                break;
            case 5:
                System.out.println("Sisesta esimene täisarv");
                int maxa = scanner.nextInt();
                System.out.println("Sisesta teine täisarv");
                int maxb = scanner.nextInt();
                System.out.println("Sisesta kolmas täisarv");
                int maxc = scanner.nextInt();
                System.out.println("Nendest kolmest arvust oli kõige suurem " + min3(maxa, maxb, maxc));
                break;


        }



    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }


    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        }
        return false;
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if(a <= b && a <= c){
            return a;
        } else if(b <= a && b <= c){
            return b;
        } else {
            return c;
        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        return max(max(a, b), c);
    }
}
