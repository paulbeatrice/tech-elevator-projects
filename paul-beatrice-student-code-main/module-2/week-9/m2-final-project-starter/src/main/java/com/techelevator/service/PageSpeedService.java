package com.techelevator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class PageSpeedService {

    private static final String PAGESPEED_API_URL = "https://www.googleapis.com/pagespeedonline/v5/runPagespeed";

    @Value("${google.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public PageSpeedService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> analyzePageSpeed(String url) {
        String requestUrl = UriComponentsBuilder.fromHttpUrl(PAGESPEED_API_URL)
                .queryParam("url", url)
                .queryParam("key", apiKey) // allows us to dynamically load the API Key
                .toUriString();

        //Call Google API

        Map<String, Object> response = restTemplate.getForObject(requestUrl, Map.class);

        //Extracting Only Key Metrics from the response because it's a HUGE one.
        Map<String, Object> extractedData = new HashMap<>();
        Map<String, Object> lighthouseResult = (Map<String, Object>) response.get("lighthouseResult");
        if (lighthouseResult != null) {
            Map<String, Object> categories = (Map<String, Object>) lighthouseResult.get("categories");
            if (categories != null) {
                Map<String, Object> performance = (Map<String, Object>) categories.get("performance");
                extractedData.put("performance_score", performance.get("score"));
            }

            Map<String, Object> audits = (Map<String, Object>) lighthouseResult.get("audits");
            if (audits != null) {
                extractedData.put("first_contentful_paint", ((Map<String, Object>) audits.get("first-contentful-paint")).get("displayValue"));
                extractedData.put("largest_contentful_paint", ((Map<String, Object>) audits.get("largest-contentful-paint")).get("displayValue"));
                extractedData.put("cumulative_layout_shift", ((Map<String, Object>) audits.get("cumulative-layout-shift")).get("displayValue"));
            }
        }
        return extractedData;
    }
}
