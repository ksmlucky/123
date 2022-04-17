// 14719번 빗물
// https://www.acmicpc.net/problem/14719

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14719_빗물 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        arr = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            if (getLeftTop(i) == arr[i] || getRightTop(i) == arr[i]) {
                continue;
            }
            int leftTop = getLeftTop(i);
            int rightTop = getRightTop(i);

            int standard = Math.min(leftTop, rightTop);

            answer += standard - arr[i];
        }

        System.out.println(answer);
    }

    // 현재 인덱스 기준 왼쪽
    private static int getLeftTop(int index) {
        int leftTop = arr[index];

        for (int i = index - 1; i >= 0; i--) {
            if (arr[i] > leftTop) {
                leftTop = arr[i];
            }
        }

        return leftTop;
    }

    private static int getRightTop(int index) {
        int rightTop = arr[index];

        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] > rightTop) {
                rightTop = arr[i];
            }
        }

        return rightTop;
    }
}
