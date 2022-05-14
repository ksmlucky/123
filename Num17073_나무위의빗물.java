// 17073번 나무 위의 빗물
// https://www.acmicpc.net/problem/17073

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num17073_나무위의빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arrayLists = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            arrayLists[num1].add(num2);
            arrayLists[num2].add(num1);
        }

        int answer = 0;
        for (int i = 2; i < N + 1; i++) {
            if (arrayLists[i].size() == 1) {
                answer++;
            }
        }
        System.out.println(String.format("%.10f", (double) W / answer));
    }
}
