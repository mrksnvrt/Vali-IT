package ee.bcs.valiit.controller;

import java.util.Random;
import java.util.Scanner;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Lesson3HardController {


    Random random = new Random();

    int randomNumber = random.nextInt(100);

    //http://localhost:8080/numberGame/

    @GetMapping("numberGame/{enterNumber}")
    public String numberGame(@PathVariable("enterNumber") int enterNumber) {
        System.out.println("0-99 lessgo");

        if (enterNumber == randomNumber) {
            return "õige number";
        } else if (enterNumber < randomNumber) {
            return "liiga väike";
        } else {
            return "liiga suur";
        }
    }


}
