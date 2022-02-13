package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2669_직사각형네개의합집합면적구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[101][101];
        int count = 0;

        for (int t = 0; t < 4; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int xx = Integer.parseInt(st.nextToken());
            int yy = Integer.parseInt(st.nextToken());

            for (int i = y; i < yy; i++) {
                for (int j = x; j < xx; j++) {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
