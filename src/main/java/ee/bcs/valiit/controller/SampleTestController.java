package ee.bcs.valiit.controller;

import ee.bcs.valiit.solution.SolutionLesson1;
import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson2b;
import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SampleTestController {

    @GetMapping("hello-world/{nameInUrl}")
    public String helloWorld(@PathVariable("nameInUrl")String name,
                             @RequestParam("action") String a,
                             @RequestParam("action2") String b){
        return a + " " + name + " " + b;
    }












    ////reverseString
    //    //http://localhost:8080/reverseString/nimi
    //    @GetMapping("reverseString/{nimi}")
    //    public String reverseString(@PathVariable("nimi")String name){
    //        return Lesson3.reverseString(name);
    //    }


















































}
