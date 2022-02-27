// 3060번 욕심쟁이 돼지
// https://www.acmicpc.net/problem/3060

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num3060_욕심쟁이돼지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int total = Integer.parseInt(br.readLine());
            int day = 0;
            int[] arr = new int[6];
            int[] tempArr = new int[6];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                tempArr[i] = arr[i];
            }

            while (true) {
                int tempTotal = minus(total, arr);
                day++;
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = tempArr[i] + tempArr[(i + 1) % 6] + tempArr[(i + 5) % 6] + tempArr[(i + 3) % 6];
                }
                for (int i = 0; i < arr.length; i++) {
                    tempArr[i] = arr[i];
                }
                if (tempTotal < 0) {
                    break;
                }
            }

            sb.append(day).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static int minus(int total, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            total -= arr[i];
        }
        return total;
    }
}
