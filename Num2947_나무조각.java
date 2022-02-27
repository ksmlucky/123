// 2947번 나무 조각
// https://www.acmicpc.net/problem/2947

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2947_나무조각 {
    static int[] arr = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        String answer = "1 2 3 4 5";

        while (true) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (solution(i, i + 1)) {
                    System.out.println(print());
                }
            }
            if (answer.equals(print())) {
                break;
            }
        }
    }

    public static boolean solution(int i, int j) {
        int temp;
        if (arr[i] > arr[j]) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            return true;
        } else {
            return false;
        }
    }

    public static String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
