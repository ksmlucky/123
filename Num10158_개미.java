// 10158번 개미
// https://www.acmicpc.net/problem/10158

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num10158_개미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        int c = (p + t) % (2 * w);
        int r = (q + t) % (2 * h);

        c = w - Math.abs(w - c);
        r = h - Math.abs(h - r);


        StringBuilder sb = new StringBuilder();
        sb.append(c).append(" ").append(r);
        System.out.println(sb);

//        System.out.println(c + " " + r);
    }
}
