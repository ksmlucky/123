// 18352번 특정 거리의 도시 찾기
// https://www.acmicpc.net/problem/18352

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num18352 {
    static class Node implements Comparable<Node> {
        private int start, distance;

        public Node(int start, int distance) {
            this.start = start;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return distance - node.distance;
        }
    }

    static int N, M, K, X;
    static int distance[];
    static ArrayList<ArrayList<Node>> adjacent = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        for (int i = 0; i < distance.length; i++) {
            adjacent.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjacent.get(start).add(new Node(end, 1));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);

        dijkstra(X);

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            if (K == distance[i]) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        pQueue.add(new Node(start, 0));
        distance[start] = 0;
        while (!pQueue.isEmpty()) {
            Node currentNode = pQueue.poll();
            if (distance[currentNode.start] < currentNode.distance) {
                continue;
            }

            for (int i = 0; i < adjacent.get(currentNode.start).size(); i++) {
                int weight = distance[currentNode.start] + adjacent.get(currentNode.start).get(i).distance;
                if (weight < distance[adjacent.get(currentNode.start).get(i).start]) {
                    distance[adjacent.get(currentNode.start).get(i).start] = weight;
                    pQueue.add(new Node(adjacent.get(currentNode.start).get(i).start, weight));
                }
            }
        }
    }
}
