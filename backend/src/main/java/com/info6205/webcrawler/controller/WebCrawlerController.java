package com.info6205.webcrawler.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.info6205.webcrawler.service.Neo4jService;
import com.info6205.webcrawler.service.WebCrawlerService;

@RestController
@RequestMapping("/api/crawler")
public class WebCrawlerController {

    private final WebCrawlerService crawlerService;
    private final Neo4jService neo4jService;

    public WebCrawlerController(WebCrawlerService crawlerService, Neo4jService neo4jService) {
        this.crawlerService = crawlerService;
        this.neo4jService = neo4jService;
    }

    @PostMapping("/start")
    public ResponseEntity<Map<String, Object>> startCrawl(@RequestParam String startUrl) {
        try {
            Map<String, Object> result = crawlerService.startCrawl(startUrl);
            System.out.println(result);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
