// 10163번 색종이
// https://www.acmicpc.net/problem/10163

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num10163_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[1001][1001];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int garo = Integer.parseInt(st.nextToken());
            int sero = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + garo; j++) {
                for (int k = y; k < y + sero; k++) {
                    arr[j][k] = i;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 0; j < 1001; j++) {
                for (int k = 0; k < 1001; k++) {
                    if (arr[j][k] == i) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        sb.setLength(sb.length() - 1);

        System.out.println(sb);

    }
}
