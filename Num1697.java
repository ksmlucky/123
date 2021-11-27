// 1697번 숨바꼭질
// https://www.acmicpc.net/problem/1697

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        } else {
            System.out.println(bfs(N, K));
        }
    }

    static int bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] visited = new int[100001];

        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int i=0; i<3; i++) {
                int nextN = 0;

                if (i == 0) {
                    nextN = now - 1;
                } else if (i == 1) {
                    nextN = now + 1;
                } else if (i == 2) {
                    nextN = now * 2;
                }

                if (nextN == K) {
                    return visited[now];
                }

                if (0 <= nextN && nextN <= 100000) {
                    if (visited[nextN] == 0) {
                        queue.add(nextN);
                        visited[nextN] = visited[now] + 1;
                    }
                }
            }
        }

        return 0;
    }
}
