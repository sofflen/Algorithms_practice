import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 100;
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);

        System.out.println(fibNaiveMemoization(n, memo));
        System.out.println(fibEffective(n));
    }

    //поиск 100 элемента может занимать 50_000 лет
    private static long fibNaive(int n) {
        if (n <= 1)
            return n;

        return fibNaive(n - 1) + fibNaive(n - 2);

    }

    //memoization
    private static long fibNaiveMemoization(int n, long[] memo) {
        if (n <= 1)
            return n;

        if (memo[n] != -1)
            return memo[n];

        long result = fibNaiveMemoization(n - 1, memo) + fibNaiveMemoization(n - 2, memo);
        memo[n] = result;
        return result;
    }

    //brute force
    private static long fibEffective(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++)
            arr[i] = arr[i - 1] + arr[i - 2];

        return arr[n];
    }
}
