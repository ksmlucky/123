// 10159번 저울
// https://www.acmicpc.net/problem/10159

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num10159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i][i] = 1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());

            arr[a1][a2] = 1; // a1 > a2;
            arr[a2][a1] = -1; // a2 > a1;
        }

        // 플로이드 와샬
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    if (arr[j][i] == 1 && arr[i][k] == 1) {
                        arr[j][k] = 1;
                    }

                    if (arr[j][i] == -1 && arr[i][k] == -1) {
                        arr[j][k] = -1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            int count = 0;
            for (int j = 1; j < N + 1; j++) {
                if (arr[i][j] != 0) {
                    count++;
                }
            }
            sb.append((N - count) + "\n");
        }

        System.out.println(sb.toString());
    }
}
