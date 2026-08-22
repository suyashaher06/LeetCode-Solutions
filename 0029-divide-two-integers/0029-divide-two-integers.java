class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == divisor) return 1;

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        if (divisor == 1) return dividend;

        if (dividend == -1) return 1;

        int sign = 1;

        if ((dividend < 0) ^ (divisor < 0))
            sign = -1;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long ans = 0;

        while (n >= d) {
            int p = 0;

            while (n >= (d << p)) {
                p++;
            }

            p--;

            n -= (d << p);
            ans += (1L << p);
        }

        if (sign == 1) {
            if (ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            return (int) ans;
        } else {
            if (ans > 2147483648L)
                return Integer.MIN_VALUE;

            return (int) -ans;
        }
    }
}