// 2563번 색종이
// https://www.acmicpc.net/problem/2563

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[101][101];
        int[][] arr = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            int y = arr[i][0];
            int x = arr[i][1];
            for (int j = y; j < y + 10; j++) {
                for (int k = x; k < x + 10; k++) {
                    map[j][k] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }


        System.out.println(count);
    }
}
