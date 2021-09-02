// 11508번 2+1 세일
// https://www.acmicpc.net/problem/11508

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Num11508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer arr[] = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (i % 3 != 2) {
                sum += arr[i];
            }
        }

        System.out.println(sum);

    }

}
