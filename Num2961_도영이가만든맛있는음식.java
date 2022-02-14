// 2961번 도영이가 만든 맛있는 음식
// https://www.acmicpc.net/problem/2961

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2961_도영이가만든맛있는음식 {
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(0);

        System.out.println(min);
    }

    public static void solution(int index) {
        if (index == arr.length) {
            int sour = 1;
            int bitter = 0;
            int count = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sour *= arr[i][0];
                    bitter += arr[i][1];
                    count++;
                }
            }

            if (count == 0) {
                return;
            }

            if (min > Math.abs(sour - bitter)) {
                min = Math.abs(sour - bitter);
            }

            return;
        }
        visited[index] = true;
        solution(index + 1);
        visited[index] = false;
        solution(index + 1);
    }
}


