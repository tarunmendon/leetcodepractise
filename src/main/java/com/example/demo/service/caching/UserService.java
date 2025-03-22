package com.example.demo.service.caching;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<Integer, String> userDatabase = new HashMap<>();

    @Cacheable(value = "users", key = "#id")
    public String getUserById(int id) {
        System.out.println("Fetching user from database...");
        return userDatabase.get(id);
    }

    @Caching(
            put = { @CachePut(value = "users", key = "#id") },
            evict = { @CacheEvict(value = "allUsers", allEntries = true) }
    )
    public String addUser(int id, String name) {
        System.out.println("Adding user to database...");
        userDatabase.put(id, name);
        return name;
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "users", key = "#id"),
                    @CacheEvict(value = "allUsers", allEntries = true)
            }
    )
    public void deleteUser(int id) {
        System.out.println("Removing user from database...");
        userDatabase.remove(id);
    }
}
