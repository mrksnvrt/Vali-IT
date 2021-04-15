package ee.bcs.valiit.controller;

import ee.bcs.valiit.dto.Cars;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class DtoCarsController {

    public static List<Cars> listOfCars = new ArrayList<>();

    //http://localhost:8080/cars
    @GetMapping("cars")
    public List<Cars> getCar(){

        return listOfCars;
    }

    @GetMapping("cars/{numberMitmesAutoListis}")
    public Cars getCar(@PathVariable("numberMitmesAutoListis")int numberMitmesAutoListis){
        Cars tagastus = listOfCars.get(numberMitmesAutoListis);
        return tagastus;
    }

    @PostMapping("cars")
    public void postCar(@RequestBody Cars autoAndmed){
        listOfCars.add(autoAndmed);
    }

    @PutMapping("cars/{numberMitmesAutoListis}")
    public void putCar(@RequestBody Cars autoAndmed, @PathVariable ("numberMitmesAutoListis")int numberMitmesAutoListis){
        listOfCars.set(numberMitmesAutoListis,autoAndmed);
    }

    @DeleteMapping("cars/{numberMitmesAutoListis}")
    public void deleteCar(@PathVariable ("numberMitmesAutoListis")int numberMitmesAutoListis){
        listOfCars.remove(numberMitmesAutoListis);
    }


}
