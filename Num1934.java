// 1934번 최소공배수
// https://www.acmicpc.net/problem/1934

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1934 {
    public static int GCD(int a, int b) {
        while (b != 0) {
            int r = a % b; // 나머지를 구해준다.

            // GCD(a, b) = GCD(b, r)이므로 변환한다.
            a = b;
            b = r;
        }

        return a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int arr[][] = new int[T][2];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        // a * b / 최대공약수 = 최소공배수
        for (int i = 0; i < T; i++) {
            sb.append(arr[i][0] * arr[i][1] / GCD(arr[i][0], arr[i][1])).append('\n');
        }

        System.out.println(sb);
    }
}
