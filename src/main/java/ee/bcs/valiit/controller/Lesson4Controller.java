package ee.bcs.valiit.controller;


import ee.bcs.valiit.dto.CreateAccountRequest;
import ee.bcs.valiit.tasks.Lesson4;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4Controller {

    private static Map<String, Double> accountBalanceMap = new HashMap<>();


    @GetMapping("createAccount")
    public void createAccount(@RequestParam("accountNumber") String accountNumber, @RequestParam("amount") Double amount) {
        accountBalanceMap.put(accountNumber,amount);
    }

    @PostMapping ("createAccount1")
    public void createAccount1(@RequestBody CreateAccountRequest request){
        accountBalanceMap.put(request.getAccountNumber(), request.getAmount());
    }



}








