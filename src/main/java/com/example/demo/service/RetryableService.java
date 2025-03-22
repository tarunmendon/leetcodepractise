package com.example.demo.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryableService {
    private int attempt = 1;

    @Retryable(retryFor = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public void performTask() {
        System.out.println("Attempt: " + attempt);
        attempt++;
        if (attempt <= 3) {
            throw new RuntimeException("Simulated failure");
        }
        System.out.println("Task completed successfully");
    }
}
