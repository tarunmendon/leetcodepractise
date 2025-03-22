package src.random;

import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket {
    private final long capacity;     // Maximum tokens in bucket
    private final long refillRate;   // Tokens added per second
    private AtomicLong tokens;       // Available tokens
    private AtomicLong lastRefillTimestamp; // Last refill time

    public TokenBucket(long capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = new AtomicLong(capacity);
        this.lastRefillTimestamp = new AtomicLong(System.nanoTime());
    }

    // Refill tokens based on elapsed time
    private synchronized void refill() {
        long now = System.nanoTime();
        long elapsedTime = now - lastRefillTimestamp.get();
        long tokensToAdd = (elapsedTime * refillRate) / 1_000_000_000; // Convert nanoseconds to seconds

        if (tokensToAdd > 0) {
            tokens.set(Math.min(capacity, tokens.get() + tokensToAdd));
            lastRefillTimestamp.set(now);
        }
    }

    // Try to consume a token
    public synchronized boolean tryConsume() {
        refill();
        if (tokens.get() > 0) {
            tokens.decrementAndGet();
            return true; // Allow request
        }
        return false; // Reject request
    }

    public static void main(String[] args)
    {
        TokenBucket tokenBucket=new TokenBucket(5,5);
        for(int i=0;i<10;i++){
            System.out.println("Received token for "+i+" iteration:"+ tokenBucket.tryConsume());
        }
    }
}
