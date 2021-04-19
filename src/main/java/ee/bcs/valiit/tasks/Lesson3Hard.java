package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void main(String[] args) {
        int randomNumber = (int) (Math.random() * 100) + 1;
        boolean hasWon = false;
        System.out.println("Lets play a game.. valisin numbri 1 ja 100 vahel. " + randomNumber + " See kindlasti ei ole");
        System.out.println("Arva 2ra!!!!!");
        Scanner scanner = new Scanner(System.in);
        for (int i = 10; i > 0; i--) {
            if (i==5){
                System.out.println("Ei taha nagu pinget peale panna, aga tundub, et siit ei tule");
            }
            System.out.println("Sul on jäänud veel " + i + " korda pakkuda");
            int guess = scanner.nextInt();

            if (randomNumber < guess) {
                System.out.println("Vale vastus. Õige vastus on väiksem, kui " + guess);
            } else if (randomNumber > guess) {
                System.out.println("Vale vastus. Õige vastus on suurem, kui " + guess);
            } else {
                hasWon = true;
                break;
            }
        }
        if (hasWon == true) {
            System.out.println("Whoaaaaa out of million, sa oled legend!!!");
        } else {
            System.out.println("Sry meees, pole midagi teha, gg.");
            System.out.println("Õige vastus oli " + randomNumber);
        }
    }
}

