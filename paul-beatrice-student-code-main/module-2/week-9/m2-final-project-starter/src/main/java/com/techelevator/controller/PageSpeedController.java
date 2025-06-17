package com.techelevator.controller;

import com.techelevator.service.PageSpeedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/api/pagespeed")
public class PageSpeedController {

    private final PageSpeedService pageSpeedService;

    public PageSpeedController(PageSpeedService pageSpeedService) {
        this.pageSpeedService = pageSpeedService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getPageSpeed(@RequestParam String url) {
        Map<String, Object> response = pageSpeedService.analyzePageSpeed(url);
        return ResponseEntity.ok(response);
    }
}
