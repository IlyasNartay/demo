package com.example.demo.repository.redis;

import com.example.demo.model.redis.CacheData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheRepository extends CrudRepository<CacheData, String> {
}