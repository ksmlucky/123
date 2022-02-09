// 2309번 일곱 난쟁이
// https://www.acmicpc.net/problem/2309

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int sum100 = sum - 100;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (sum100 == arr[i] + arr[j]) {
                    for (int k = 0; k < arr.length; k++) {

                        if (k != i && k != j) {
                            System.out.println(arr[k]);
                        }

                    }
                }
            }
        }

    }
}
