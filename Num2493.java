// 2493번 탑
// https://www.acmicpc.net/problem/2493

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();

//        for (int i = 0; i < N; i++) {
//            arrayList.add(Integer.parseInt(st.nextToken()));
//        }

        int[] arr = new int[N];
        int[] answer = new int[N];
        answer[0] = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        for (int i = (arrayList.size() - 1); i < 0; i--) {
//            if (arrayList.get(i) >= arrayList.get(i - 1)) {
//
//            }
//        }

        for (int i = (arr.length - 1); i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]);
            if (i != answer.length - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }
}
