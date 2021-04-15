package ee.bcs.valiit.controller;

import ee.bcs.valiit.dto.Cars;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DtoCarsController {

    public static List<Cars> listOfCars = new ArrayList<>();

    //Kuvab terve listi
    //http://localhost:8080/cars/listfull
    @GetMapping("cars/listfull")
    public List<Cars> getCar(){
        return listOfCars;
    }
    //Kuvab sellenda elemendi listist, mille määrad
    //http://localhost:8080/cars/list/1
    @GetMapping("cars/list/{numberMitmesAutoListis}")
    public Cars getCar(@PathVariable("numberMitmesAutoListis")
                                   int numberMitmesAutoListis){
        return listOfCars.get(numberMitmesAutoListis);
    }

    //Sellelt aadressilt saab lisada listi elemendi
    //http://localhost:8080/cars/add
    @PostMapping("cars/add")
    public void postCar(@RequestBody Cars autoAndmed){
        listOfCars.add(autoAndmed);
    }

    //Sellelt aadressilt saab muuta mingit kindlat autot listis
    //http://localhost:8080/cars/change/1
    @PutMapping("cars/change/{numberMitmesAutoListis}")
    public void putCar(@RequestBody Cars autoAndmed,
                       @PathVariable ("numberMitmesAutoListis") int numberMitmesAutoListis){
        listOfCars.set(numberMitmesAutoListis,autoAndmed);
    }

    //Sellelt aadressilt saab kustutada elemendi listist
    //http://localhost:8080/cars/delete/1

    @DeleteMapping("cars/delete/{numberMitmesAutoListis}")
    public void deleteCar(@PathVariable ("numberMitmesAutoListis")int numberMitmesAutoListis){
        listOfCars.remove(numberMitmesAutoListis);
    }
}
