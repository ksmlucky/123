// 1074번 Z
// https://www.acmicpc.net/problem/1074

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1074_Z {
    static int N, r, c;
    static int size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        size = (int) Math.pow(2, N);

        int answer = solution(0, 0, size);

        System.out.println(answer);
    }

    public static int solution(int nr, int nc, int size) {

        if (size == 1) {
            return 0;
        }

        if (r < nr + size / 2 && c < nc + size / 2)
            return solution(nr, nc, size / 2);

        else if (r < nr + size / 2 && c < nc + size)
            return solution(nr, nc + size / 2, size / 2) + (int) Math.pow(size / 2, 2);

        else if (r < nr + size && c < nc + size / 2)
            return solution(nr + size / 2, nc, size / 2) + (int) Math.pow(size / 2, 2) * 2;

        else
            return solution(nr + size / 2, nc + size / 2, size / 2) + (int) Math.pow(size / 2, 2) * 3;

    }
}
