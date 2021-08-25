// 2133번 타일 채우기
// https://www.acmicpc.net/problem/2133

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2133 {
    static int dp[] = new int[31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(tile(N));

    }

    public static int tile(int N) {
        if (N % 2 == 1) {
            return 0;
        } else if (N == 2) {
            return 3;
        } else if (N == 4) {
            return 11;
        } else if (dp[N] != 0) {
            return dp[N];
        } else {
            dp[2] = 3;
            dp[4] = 11;

            dp[N] = tile(N - 2) * 2 * N;
            return dp[N];
        }
    }
}
