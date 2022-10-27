// 11724번 연결 요소의 개수
// https://www.acmicpc.net/problem/11724

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11724_연결요소의개수 {
    static int N, M;
    static int[][] map;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            map[start][end] = 1;
            map[end][start] = 1;
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int number) {
        visited[number] = true;

        for (int i = 0; i < N; i++) {
            if (map[number][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
