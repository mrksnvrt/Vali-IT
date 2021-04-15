package ee.bcs.valiit.controller;

import ee.bcs.valiit.dto.Cars;
import ee.bcs.valiit.dto.Drinks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DrinksController {

    public static List<Drinks> listOfDrinks = new ArrayList<>();

    //http://localhost:8080/drinks
    @GetMapping("drinks")
    public List<Drinks> getDrink() {

        return listOfDrinks;
    }

    ////http://localhost:8080/postDrinks
    @PostMapping("postDrink")
    public void postDrink(@RequestBody Drinks joogiAndmed) {

        listOfDrinks.add(joogiAndmed);


    }

}
