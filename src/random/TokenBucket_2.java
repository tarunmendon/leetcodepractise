package src.random;

public class TokenBucket_2 {
    private int maxBucketSize, numberOfRequests, numberOfTokensAvailable, windowSizeFoRateLimitInMilliSec;
    private long nextRefillTime, lastRefillTime;

    TokenBucket_2(int maxBucketSize, int numberOfRequest) {
        this.maxBucketSize = maxBucketSize;
        this.numberOfRequests = numberOfRequest;
        this.windowSizeFoRateLimitInMilliSec = TokenBucketConstants.windowSizeFoRateLimitInMilliSec;
    }

    public synchronized void refill() {

        if (System.currentTimeMillis() < nextRefillTime) {
            return;
        }
        this.lastRefillTime = System.currentTimeMillis();
        this.nextRefillTime = this.lastRefillTime + this.windowSizeFoRateLimitInMilliSec;
        this.numberOfTokensAvailable = Math.min(maxBucketSize, this.numberOfTokensAvailable + this.numberOfRequests);
    }

    public synchronized boolean tryConsume() {
        refill();
        if (this.numberOfTokensAvailable > 0) {
            this.numberOfTokensAvailable--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TokenBucket_2 tokenBucket_2 = new TokenBucket_2(TokenBucketConstants.maxBucketSize, TokenBucketConstants.numberOfRequest);
        long startTime = System.currentTimeMillis();
        int numberOfConsumed = 0;
        boolean consumed = false;
        while ((System.currentTimeMillis() - startTime) < 10 * 1000) {
            consumed = tokenBucket_2.tryConsume();
            System.out.println("try consume=" + consumed);
            if (consumed)
                numberOfConsumed++;
        }
        System.out.println("Number of consumed request:" + numberOfConsumed);

    }
}
