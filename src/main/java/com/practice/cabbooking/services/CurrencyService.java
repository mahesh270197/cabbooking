package com.practice.cabbooking.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
@Service
public class CurrencyService {
    private static final String API_URL = "https://api.freecurrencyapi.com/v1/latest";
    private static final String API_KEY = "fca_live_La5eZi7cnten3493rtniC1LFTjPq0eP7mAd9o5P2"; // Replace with your API key

    private final RestTemplate restTemplate;

    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Double> getExchangeRates(String fromCurrency, String[] toCurrencies) {
        String targetCurrencies = String.join(",", toCurrencies);
        String url = UriComponentsBuilder.fromHttpUrl(API_URL)
                .queryParam("apikey", API_KEY)
                .queryParam("base_currency", fromCurrency)
                .queryParam("currencies", targetCurrencies)
                .toUriString();

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        Map<String, Double> rates = (Map<String, Double>) response.get("data");
        return rates;
    }

    public Map<String, Double> convertCurrency(String fromCurrency, double amount, String[] toCurrencies) {
        Map<String, Double> rates = getExchangeRates(fromCurrency, toCurrencies);
        Map<String, Double> convertedAmounts = new HashMap<>();

        for (String currency : toCurrencies) {
            double rate = rates.get(currency);
            convertedAmounts.put(currency, amount * rate);
        }

        return convertedAmounts;
    }
}
