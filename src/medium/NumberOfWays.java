package medium;

/**
 * Q: Given an amount A and an array of available denominations of coins. Calculate number of ways we can change A using coins.
 * Coins have unlimited supply.
 */
public class NumberOfWays {
    //method: Recursive. This is unbounded knapsack problem.
    public int numberOfWays(int denom[], int amount, int n, int arr[][]) {
        if(amount == 0) {
            return 1;
        }
        if(n == 0) {
            return 0;
        }
        if(arr[n-1][amount] != 0) {
            return arr[n-1][amount];
        }
        if(amount >= denom[n-1]) {
            return arr[n-1][amount] =  numberOfWays(denom, amount - denom[n-1], n, arr) +
                    numberOfWays(denom, amount, n-1, arr);
        }
        else {
            return arr[n-1][amount] = numberOfWays(denom, amount, n-1, arr);
        }
    }
    //method:
    public int noOfWays(int denom[], int amt) {
        int ways[] = new int [amt+1];
        ways[0] = 1;
        for(int i = 0; i < denom.length; i++) {
            for(int j = 1 ;j <= amt; j++) {
                if(j >= denom[i]) {
                    ways[j] = ways[j] + ways[j - denom[i]];
                }
            }
        }
        return ways[amt];
    }

    public static void main(String[] args) {
        NumberOfWays w = new NumberOfWays();
        int arr[] = {1,5,100,24};
        int amt = 10;
        int array[][] = new int[arr.length + 1][amt + 1];
        System.out.println("Number of ways are: " + w.numberOfWays(arr, amt, arr.length, array));
    }
}




