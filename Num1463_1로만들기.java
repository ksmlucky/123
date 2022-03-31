// 1463번 1로 만들기 [DP(동적계획법) - 1로 만들기 문제]
// https://www.acmicpc.net/problem/1463

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1463_1로만들기 {
    private static class Solution {

        // 탑 다운 방법
        private int solution1(int N) {
            int dp[] = new int[N + 2];

            if (N == 1) {
                return 0;
            }
            if (dp[N] > 0) {
                return dp[N];
            }
            dp[N] = solution1(N - 1) + 1;
            if (N % 6 == 0) {
                dp[N] = Math.min(solution1(N - 1), Math.min(solution1(N / 3), solution1(N / 2))) + 1;
            }
            if (N % 2 == 0) {
                dp[N] = Math.min(dp[N], solution1(N / 2) + 1);
            }
            if (N % 3 == 0) {
                dp[N] = Math.min(dp[N], solution1(N / 3) + 1);
            }

            return dp[N];
        }

        // 바텀 업 방법
        private int solution2(int N) {
            int dp[] = new int[N + 2];

            dp[1] = 0;
            for (int i = 2; i <= N; i++) {
                dp[i] = dp[i - 1] + 1;
                if (dp[i] % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                    dp[i] = dp[i / 2] + 1;
                }
                if (dp[i] % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                    dp[i] = dp[i / 3] + 1;
                }

            }
            return dp[N];
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Solution s = new Solution();
        System.out.println(s.solution1(N));
        System.out.println(s.solution2(N));
    }
}
