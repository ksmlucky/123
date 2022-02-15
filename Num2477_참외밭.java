// 2477번 참외밭
// https://www.acmicpc.net/problem/2477

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2477_참외밭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList12 = new ArrayList<>();
        ArrayList<Integer> arrayList34 = new ArrayList<>();
//        int[] arr12 = new int[3]; // 1번 2번은 동, 서
//        int[] arr34 = new int[3]; // 3번 4번은 남, 북
        int[] arr = new int[6];

        StringTokenizer st;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
//            if (temp == 1 || temp == 2) {
//                arrayList12.add(Integer.parseInt(st.nextToken()));
//            } else {
//                arrayList34.add(Integer.parseInt(st.nextToken()));
//            }
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int bigHeight = 0, bigWidth = 0;
        int smallHeight = 0, smallWidth = 0;

        for (int i = 0; i < 6; i++) {
            if (i % 2 != 0) {
                bigHeight = Math.max(bigHeight, arr[i]);
            } else {
                bigWidth = Math.max(bigWidth, arr[i]);
            }
        }

        for (int i = 0; i < 6; i++) {
            // 제일 큰애(높이)가 본인(넓이)의 앞뒤(높이들)를 더한거랑 같을 때 본인이 제일 작은애(넓이)
            if (i % 2 != 0) {
                if (bigWidth == arr[(i + 5) % 6] + arr[(i + 1) % 6]) {
                    smallHeight = arr[i];
                }
            } else {
                if (bigHeight == arr[(i + 5) % 6] + arr[(i + 1) % 6]) {
                    smallWidth = arr[i];
                }
            }
        }

        int answer = ((bigWidth * bigHeight) - (smallWidth * smallHeight)) * K;
//        for (int i = 0; i < arr12.length; i++) {
//            arr12[i] = arrayList12.get(i);
//            arr34[i] = arrayList34.get(i);
//        }
//        Arrays.sort(arr12);
//        Arrays.sort(arr34);
//        int max12 = arr12[arr12.length - 1];
//        int max34 = arr34[arr34.length - 1];
//        int min12 = arr12[0];
//        int min34 = arr34[0];
//
//        int answer = ((max12 * max34) - (min12 * min34)) * K;

        System.out.println(answer);
    }
}
