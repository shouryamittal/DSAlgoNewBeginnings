package medium;

/**
 * Q: Given 2 strings, find minimum no of operations to convert s1 to s2.
 * There are 3 operations allowed, insetion, deletion and replace.
 */

public class LevenshtienDistance {

    /*
    * Method: For two given strings traverse both from start to end
    * 1. if ith and jth characters of both the strings are same, this means we dont need any extra operation, just the count of operatiosn of i-1 and j-1 will work.
    * 2. if both are different, then either we will delete ith char from str s1, or delete char from s2, or delete from both. Will have to take minimum of three.
    *  Time : O(nm) | space: O(nm)
    *
    * */



    public int minimumNumOfOpr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(m == 0) {
            return  n;
        }
        if(n ==0) {
            return m;
        }
        int dp[][] = new int[n+1][m+1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = 0;
                }
                else if(i == 0){
                    dp[i][j] = 1 + dp[i][j-1];
                }
                else if(j == 0) {
                    dp[i][j] = 1 + dp[i-1][j];
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        LevenshtienDistance l = new LevenshtienDistance();
        System.out.println("Minimum number of operations " + l.minimumNumOfOpr("abc", "yac"));
    }

}
