package ee.bcs.valiit.controller.lessons;

import ee.bcs.valiit.solution.SolutionLesson1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Lesson1Controller {

    //********************************************************************;
    //Lesson1;
    //Tagasta a ja b väikseim väärtus;

    //http://localhost:8080/min/1/5
    @GetMapping("min/{a}/{b}")
    public int min(@PathVariable("a")int a,
                   @PathVariable("b")int b){
        return SolutionLesson1.min(a, b);
    }
    //Tagasta a ja b suurem väärtus;

    //http://localhost:8080/max/1/5
    @GetMapping("max/{a}/{b}")
    public int max(@PathVariable("a")int a,
                   @PathVariable("b")int b) {
        return SolutionLesson1.max(a, b);
    }
    //Tagasta a absoluutarv

    //http://localhost:8080/abs/5
    @GetMapping("abs/{a}")
    public int abs(@PathVariable("a")int a) {
        return SolutionLesson1.abs(a);
    }
    //Tagasta isEven

    //http://localhost:8080/isEven/8
    @GetMapping("isEven/{a}")
    public boolean isEven(@PathVariable("a")int a) {
        return SolutionLesson1.isEven(a);
    }
    //Tagasta kolme arve min

    //http://localhost:8080/min3/1/5/20
    @GetMapping("min3/{a}/{b}/{c}")
    public int min3(@PathVariable("a")int a,
                    @PathVariable("b")int b,
                    @PathVariable("c")int c) {
        return SolutionLesson1.min3(a, b, c);
    }
    //Tagasta kolme arvu max

    //http://localhost:8080/max3/1/5/20
    @GetMapping("max3/{a}/{b}/{c}")
    public int max3(@PathVariable("a")int a,
                    @PathVariable("b")int b,
                    @PathVariable("c")int c) {
        return SolutionLesson1.max3(a, b, c);
    }



}
