import java.util.*;

class Solution {

    static int[][] dp = new int[501][501];
    static int[] sum = new int[501];

    static int f(int l, int r) {

        if (dp[l][r] != -1)
            return dp[l][r];

        int ans = 0;

        for (int m = l; m < r; m++) {

            int Lsum = sum[m + 1] - sum[l];
            int Rsum = sum[r + 1] - sum[m + 1];

            if (Lsum <= Rsum)
                ans = Math.max(ans, Lsum + f(l, m));

            if (Lsum >= Rsum)
                ans = Math.max(ans, Rsum + f(m + 1, r));

            // Pruning branch
            if (2 * Math.min(Lsum, Rsum) <= ans)
                break;
        }

        return dp[l][r] = ans;
    }

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        // Prefix Sum
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stoneValue[i];
        }

        // Initialize DP with -1
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(0, n - 1);
    }
}