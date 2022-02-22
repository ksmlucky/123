// 2628번 종이자르기
// https://www.acmicpc.net/problem/2628

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num2628_종이자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrayList0 = new ArrayList<>(); // 세로
        ArrayList<Integer> arrayList1 = new ArrayList<>(); // 가로

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {
                arrayList0.add(Integer.parseInt(st.nextToken()));
            } else {
                arrayList1.add(Integer.parseInt(st.nextToken()));
            }
        }
        arrayList0.add(0);
        arrayList1.add(0);
        arrayList0.add(y);
        arrayList1.add(x);

        Collections.sort(arrayList0); // 세로
        Collections.sort(arrayList1); // 가로

        int[] arr0 = new int[arrayList0.size() - 1];
        int[] arr1 = new int[arrayList1.size() - 1];

        for (int i = 0; i < arrayList0.size() - 1; i++) {
            arr0[i] = arrayList0.get(i + 1) - arrayList0.get(i);
        }
        for (int i = 0; i < arrayList1.size() - 1; i++) {
            arr1[i] = arrayList1.get(i + 1) - arrayList1.get(i);
        }

        Arrays.sort(arr0);
        Arrays.sort(arr1);

        int answer = arr0[arr0.length - 1] * arr1[arr1.length - 1];

        System.out.println(answer);
    }
}
