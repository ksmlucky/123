// 1504번 특정한 최단 경로
// https://www.acmicpc.net/problem/1504

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1504 {
    static class Node implements Comparable<Node> {
        private int start;
        private int distance;

        public Node(int start, int distance) {
            this.start = start;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return distance - node.distance;
        }
    }

    static int N, E;
    static int distance[];
    static ArrayList<ArrayList<Node>> list; // 인접리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        distance = new int[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(br.readLine());
        }
    }
}
