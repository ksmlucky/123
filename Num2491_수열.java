// 2491번 수열
// https://www.acmicpc.net/problem/2491

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2491_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int asc = 1;
        int ascMax = 1;
        int des = 1;
        int desMax = 1;

        for (int i = 0; i < N - 1; i++) {
            // 증가
            if (arr[i] <= arr[i + 1]) {
                asc++;
                ascMax = Math.max(ascMax, asc);
            } else {
                asc = 1;
            }

            // 감소
            if (arr[i] >= arr[i + 1]) {
                des++;
                desMax = Math.max(desMax, des);
            } else {
                des = 1;
            }
        }

        System.out.println(Math.max(desMax, ascMax));
    }
}
