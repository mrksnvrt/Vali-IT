package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class Lesson2Controller {

    //****************************************************************
    //LESSON2
    //reverseArray

    //http://localhost:8080/reverseArray/1,2,3,4
    @GetMapping("reverseArray/{array}")
    public int [] reverseArray(@PathVariable("array")int [] array){

        return Lesson2.reverseArray(array);
    }

    //EvenNumbers

    //http://localhost:8080/evenNumbers/5
    @GetMapping("evenNumbers/{n}")
    public int [] evenNumbers(@PathVariable("n")int n){

        return Lesson2.evenNumbers(n);
    }


    //MIN
    //http://localhost:8080/min
    @GetMapping("min/{array}")
    public int min(@PathVariable("array")int [] array){

        return Lesson2.min(array);
    }

    //MAX
    //http://localhost:8080/max
    @GetMapping("max/{array}")
    public int max(@PathVariable("array")int [] array){

        return Lesson2.max(array);
    }

    //SUM
    //http://localhost:8080/sum
    @GetMapping("sum/{array}")
    public int sum(@PathVariable("array")int [] array){

        return Lesson2.sum(array);
    }


    //fibonacci
    //http://localhost:8080/fibonacci/20
    @GetMapping("fibonacci/{n}")
    public int fibonacci(@PathVariable("n")int n){
        return Lesson2.fibonacci(n);
    }


    //s3quence
    //http://localhost:8080/sequence3n/10/20
    @GetMapping("sequence3n/{x}/{y}")
    public int sequence3n(@PathVariable("x")int x,
                          @PathVariable("y")int y){
        return Lesson2.sequence3n(x,y);
    }

    //multiplyTable
    //http://localhost:8080/multiplyTable/3/3
    @GetMapping("multiplyTable/{x}/{y}")
    public void multiplyTable(@PathVariable("x")int x,
                              @PathVariable("y")int y){
    }



}
