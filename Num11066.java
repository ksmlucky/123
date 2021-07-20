// 11066번 파일 합치기
// https://www.acmicpc.net/problem/11066


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11066 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            int[] arr = new int[K + 1];
            int[] sum = new int[K + 1];
            int[][] dp = new int[500][500];

            for (int j = 1; j <= K; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j - 1] + arr[j];
            }

            for (int j = 2; j <= K; j++) {
                for (int k = j - 1; k > 0; k--) {
                    dp[k][j] = 10000;
                    for (int l = k; l <= j; l++) {
                        dp[k][j] = Math.min(dp[k][j], dp[k][l] + dp[l + 1][j]);
                    }
                    dp[k][j] += sum[j] - sum[k - 1];    //마지막에 전체합을 해줌
                }
            }

            System.out.println(dp[1][K]);


            T--;
        }
    }
}
