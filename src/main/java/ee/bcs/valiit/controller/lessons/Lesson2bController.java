package ee.bcs.valiit.controller.lessons;

import ee.bcs.valiit.tasks.Lesson2b;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Lesson2bController {



    //***************************************************************
    //Lesson 2b

    //Trüki välja n arvu exercise1
    //http://localhost:8080/exercise1/4
    @GetMapping("exercise1/{n}")
    public int [] exercise1(@PathVariable("n")int n){

        return Lesson2b.exercise1(n);
    }

    //sampleArray
    //http://localhost:8080/sampleArray/
    @GetMapping("sampleArray/")
    public int [] sampleArray(){
        return Lesson2b.sampleArray();
    }


    //generateArray
    //http://localhost:8080/generateArray/n
    @GetMapping("generateArray/{n}")
    public int [] generateArray(@PathVariable("n")int n){
        return Lesson2b.generateArray(n);
    }




    //decreasingArray
    //http://localhost:8080/decreasingArray/n
    @GetMapping("decreasingArray/{n}")
    public int [] decreasingArray(@PathVariable("n")int n){
        return Lesson2b.decreasingArray(n);
    }


    //yl3
    //http://localhost:8080/yl3/n
    @GetMapping("yl3/{n}")
    public int [] yl3(@PathVariable("n")int n){
        return Lesson2b.yl3(n);
    }




}
