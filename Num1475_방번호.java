// 1475번 방 번호
// https://www.acmicpc.net/problem/1475

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] arr = new int[10];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - '0']++;
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }

        // 6이나 9가 아니면 그냥 max를 출력하면 됨
        if (maxIndex != 6 && maxIndex != 9) {
            System.out.println(max);
        } else { // 6이나 9면 둘을 합해서 2로 나눠줘야함
            max = Integer.MIN_VALUE;
            int temp = arr[6] + arr[9];

            // 최댓값으로 인식되기 때문에 0으로 만들어줌
            arr[6] = 0;
            arr[9] = 0;

            temp = temp / 2 + temp % 2;

            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }

            max = Math.max(max, temp);
            System.out.println(max);
        }

    }
}
