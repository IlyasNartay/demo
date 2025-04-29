package com.example.demo.controller;

import com.example.demo.model.redis.CacheData;
import com.example.demo.repository.redis.CacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cache")
public class CacheController {

    @Autowired
    private CacheRepository cacheRepository;

    @GetMapping("/{key}")
    public CacheData getByKey(@PathVariable String key) {
        return cacheRepository.findById(key).orElse(null);
    }

    @PostMapping
    public CacheData saveToCache(@RequestBody CacheData cacheData) {
        return cacheRepository.save(cacheData);
    }

    @DeleteMapping("/{key}")
    public void deleteFromCache(@PathVariable String key) {
        cacheRepository.deleteById(key);
    }
}