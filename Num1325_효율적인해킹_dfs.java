package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num1325_효율적인해킹_dfs {
    static int N, M;
    static ArrayList<Integer>[] arrayLists;
    static boolean[] visited;
    static int[] answerArr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[N];
        visited = new boolean[N];
        answerArr = new int[N];

        for (int i = 0; i < N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            arrayLists[start].add(end);
        }

        for (int i = 0; i < N; i++) {
            // 각 노드마다 dfs 실행하면서 count가 가장 큰애가 정답
            visited = new boolean[N];
            visited[i] = true;
            dfs(i);
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(max, answerArr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (answerArr[i] == max) {
                sb.append(i + 1).append(" ");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static void dfs(int node) {
        for (int temp : arrayLists[node]) {
            if (!visited[temp]) {
                // 정답체크
                answerArr[temp]++;
                visited[temp] = true;
                dfs(temp);
            }
        }
    }
}
