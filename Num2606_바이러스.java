// 2606번 바이러스
// https://www.acmicpc.net/problem/2606

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num2606_바이러스 {
    static boolean[] visited;
    static ArrayList<Integer>[] arrayLists;
    static int count = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        //인접리스트
        arrayLists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = false;
            arrayLists[i] = new ArrayList<Integer>();
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= M; i++) { // 해당 노드에 연결된 애들만 넣어줌
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayLists[a].add(b);
            arrayLists[b].add(a);
        }

        dfs(1); // 1번 컴퓨터부터 시작

        System.out.println(count);
    }

    static void dfs(int start) {
        visited[start] = true;
        for (int i = 0; i < arrayLists[start].size(); i++) {
            int next = arrayLists[start].get(i);
            if (!visited[next]) {  // 연결되어 있는 것들 중에 방문하지 않은 것 선별
                count++;
                dfs(next);
            }
        }
    }
}
