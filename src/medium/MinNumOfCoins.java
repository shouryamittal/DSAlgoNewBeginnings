package medium;

/**
 * Given an amount and array of coins, calculate the minimum number of coins required to sum up to amount.
 * We have unlimited coins of each denomination
 */
public class MinNumOfCoins {
    public int minNumOfCoins(int[] denom, int amount, int n) {
        if(n == 0) {
            return Integer.MAX_VALUE - 1;
        }
        if(amount == 0) {
            return 0;
        }
        else if(denom[n-1] <= amount) {
            return Math.min(1 + minNumOfCoins(denom, amount - denom[n-1], n), minNumOfCoins(denom, amount, n -1));
        }
        else {
            return minNumOfCoins(denom, amount, n-1);
        }
    }

    public static void main(String[] args) {
        MinNumOfCoins m = new MinNumOfCoins();
        int amt = 30;
        int []coins = {1,2,4};
        System.out.println("Minimum number of coins required: " + m.minNumOfCoins(coins, amt, coins.length));
    }
}