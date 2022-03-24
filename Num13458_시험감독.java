// 13458번 시험 감독
// https://www.acmicpc.net/problem/13458

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num13458_시험감독 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(solution(arr, B, C));
    }

    private static long solution(int[] arr, int B, int C) {
        long count = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] -= B;
            count++;

            if (arr[i] > 0) {
                count += arr[i] / C;
                if (arr[i] % C != 0) {
                    count++;
                }
            }
        }

        return count;
    }


}