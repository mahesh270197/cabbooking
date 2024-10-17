package com.practice.cabbooking.controllers;

import com.practice.cabbooking.dtos.RideDto;
import com.practice.cabbooking.services.CurrencyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class demoController {
    private final CurrencyService currencyService;

    public demoController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/convert")
    public Map<String, Double> convertCurrency(
            @RequestParam String fromCurrency,
            @RequestParam double amount,
            @RequestParam String[] toCurrencies) {

        return currencyService.convertCurrency(fromCurrency, amount, toCurrencies);
    }
}
