// 2605번 줄 세우기
// https://www.acmicpc.net/problem/2605

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int i = 1; i <= arr.length; i++) {
//            arrayList.add(arr[i - 1], i);
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < N; i++) {
//            sb.append(arrayList.get(i)).append(" ");
//        }
//        sb.setLength(sb.length() - 1);
//        sb.reverse();
//        System.out.println(sb);
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                arrayList.add(i + 1);
            } else {
                arrayList.add(arrayList.size() - arr[i], i + 1);
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i) + " ");
        }
    }
}
