// 1920번 수 찾기
// https://www.acmicpc.net/problem/1920

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arrN[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arrN.length; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int arrM[] = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arrM.length; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN);

        for (int i = 0; i < arrM.length; i++) {
            System.out.println(binarySearch(arrN, arrM[i]));
        }
    }

    static int binarySearch(int arrN[], int val) {
        int left = 0;
        int right = arrN.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arrN[mid] == val) {
                return 1;
            } else if (arrN[mid] > val) {
                right = mid - 1;
            } else if (arrN[mid] < val) {
                left = mid + 1;
            }
        }

        return 0;
    }
}
