package src.leetcode.easy;

/*
https://leetcode.com/problems/water-bottles/description/
 */
public class WaterBottles {
    public static void main(String[] args) {
        WaterBottles obj = new WaterBottles();
        System.out.println(obj.numWaterBottles(12, 4));
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        int emptyBottle=0;
        while (numBottles >= numExchange) {
            emptyBottle=numBottles % numExchange;
            numBottles = numBottles / numExchange;
            sum += numBottles;
            numBottles+=emptyBottle;
        }
        return sum;
    }
}
