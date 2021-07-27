// 16234번 인구 이동
// https://www.acmicpc.net/problem/16234

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num16234 {
    static int N,L,R, A[][], answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new  StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer =0;

        while (true) {
            //바꾸는 h집합
            ArrayList<ArrayList> al = new ArrayList<ArrayList>();
            // 바꾸는 걸 찾기 위함
            // 방문한건 visitied[]로
            boolean[] visitied = new boolean[N * N];
            for (int n = 0; n < N * N; n++) {

                if (visitied[n]) {
                    continue;
                }
                ArrayList<Integer> h = new ArrayList<Integer>();
                h.add(n);
                visitied[n] = true;
                int i = 0;
                int sum = A[n / N][n % N];
                while (i < h.size()) {
                    int nn = h.get(i);
                    int r = nn / N;
                    int c = nn % N;
                    if (r > 0 && !visitied[nn - N]) {
                        int d = Math.abs(A[r][c] - A[r - 1][c]);
                        if (d >= L && d <= R) {
                            h.add(nn - N);
                            visitied[nn - N] = true;
                            sum += A[r - 1][c];
                        }
                    }
                    if (c > 0 && !visitied[nn - 1]) {
                        int d = Math.abs(A[r][c] - A[r][c - 1]);
                        if (d >= L && d <= R) {
                            h.add(nn - 1);
                            visitied[nn - 1] = true;
                            sum += A[r][c - 1];
                        }
                    }
                    if (r < N - 1 && !visitied[nn + N]) {
                        int d = Math.abs(A[r][c] - A[r + 1][c]);
                        if (d >= L && d <= R) {
                            h.add(nn + N);
                            visitied[nn + N] = true;
                            sum += A[r + 1][c];
                        }
                    }
                    if (c < N - 1 && !visitied[nn + 1]) {
                        int d = Math.abs(A[r][c] - A[r][c + 1]);
                        if (d >= L && d <= R) {
                            h.add(nn + 1);
                            visitied[nn + 1] = true;
                            sum += A[r][c + 1];
                        }
                    }
                    i++;
                }
                if (h.size() > 1) {
                    h.add(sum / h.size());
                    al.add(h);
                }
            }


            //hs 집합이 비어있으면 break;
            if (al.isEmpty()) break;
            for (ArrayList<Integer> h : al) {
                int s = h.size();
                for (int j = 0; j < s - 1; j++) {
                    int nn = h.get(j);
                    int r = nn / N;
                    int c = nn % N;
                    A[r][c] = h.get(s - 1);
                    ;
                }
            }
            // 아니면 answer+=1;
            answer++;
        }
        System.out.println(answer);
    }
}