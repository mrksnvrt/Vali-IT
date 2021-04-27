package ee.bcs.valiit.controller.lessons;

import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class Lesson3Controller {

    //***********************************************************'
    //Lesson3



    //factorial
    //http://localhost:8080/factorial/6
    @GetMapping("factorial/{x}")
    public int factorial(@PathVariable("x")int x){
        return Lesson3.factorial(x);
    }


    //reverseString
    //http://localhost:8080/reverseString/nimi
    @GetMapping("reverseString/{nimi}")
    public String reverseString(@PathVariable("nimi")String name){
        return Lesson3.reverseString(name);
    }



    //isPrime
    //http://localhost:8080/isPrime/8
    @GetMapping("isPrime/{n}")
    public boolean isPrime(@PathVariable("n")int n){
        return Lesson3.isPrime(n);
    }


    //sort
    //http://localhost:8080/sort/2,3,4,5,6
    @GetMapping("sort/{array}")
    public int[] sort(@PathVariable("array")int [] array){
        return Lesson3.sort(array);
    }

    //evenFibonacci
    //http://localhost:8080/evenFibonacci/9
    @GetMapping("evenFibonacci/{x}")
    public int evenFibonacci(@PathVariable("x")int x){
        return Lesson3.evenFibonacci(x);
    }


    //morseCode
    //http://localhost:8080/morseCode/tekst
    @GetMapping("morseCode/{tekst}")
    public String morseCode(@PathVariable("tekst")String tekst){
        return Lesson3.morseCode(tekst);
    }


}
