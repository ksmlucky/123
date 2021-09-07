// 16198번 에너지 모으기
// https://www.acmicpc.net/problem/16198

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num16198 {

    static int n;
    static int[] arr;
    static int[] re_arr;
    static int ans = Integer.MIN_VALUE;

    static void go(int[] arr, int sum) {

        int ss = 0;
        if (arr.length == 2) {
            if (ans < sum)
                ans = sum;
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == arr.length - 1)
                continue;
            ss = arr[i - 1] * arr[i + 1];

            int new_len = arr.length - 1;
            re_arr = new int[new_len];

            int k = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    k = j;
                    break;
                }
                re_arr[j] = arr[j];
            }
            for (int j = k + 1; j < arr.length; j++) {
                re_arr[j - 1] = arr[j];
            }
            go(re_arr, sum + ss);

        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        re_arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // end of for loop

        go(arr, 0);

        System.out.println(ans);
    }

}