package com.example.demo.model.redis;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash(value = "CacheData", timeToLive = 60) // TTL = 60 секунд
public class CacheData implements Serializable {
    @Id
    private String key;
    private String value;
}