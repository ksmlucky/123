// 2578번 빙고
// https://www.acmicpc.net/problem/2578

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2578_빙고 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] arr = new int[26];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 25; i++) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int b = 1; b <= 25; b++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] == arr[b]) {
                        map[i][j] = 0;
                    }
                }
            }
            if (check(map)) {
                System.out.println(b);
                break;
            }
        }
    }


    public static boolean check(int[][] map) {
        int bingoCount = 0;
        for (int i = 0; i < map.length; i++) {
            int count = 0;
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
            if (count == 5) {
                bingoCount++;
            }
        }
        for (int i = 0; i < map.length; i++) {
            int count = 0;
            for (int j = 0; j < map[i].length; j++) {
                if (map[j][i] == 0) {
                    count++;
                }
            }
            if (count == 5) {
                bingoCount++;
            }
        }
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            count = 0;
            if (map[i][i] == 0) {
                count++;
            }
            if (count == 5) {
                bingoCount++;
            }
        }

        count = 0;
        for (int i = 0; i < map.length; i++) {

            if (map[map.length - 1 - i][i] == 0) {
                count++;
            }
            if (count == 5) {
                bingoCount++;
            }
        }

        if (bingoCount >= 3) {
            return true;
        } else {
            return false;
        }
    }
}
