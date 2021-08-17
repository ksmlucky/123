// 1783번 병든 나이트
// https://www.acmicpc.net/problem/1783

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1783 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(solution());
    }

    static int solution() {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return Math.min(4, (M + 1) / 2);
        } else if (M < 7) {
            return Math.min(4, M);
        }
        // M이 7보다 크면 한방향 한번씩 하고 최대 칸 수가 나올 수 있는 방향만 반복
        return M - 2;
    }

}
