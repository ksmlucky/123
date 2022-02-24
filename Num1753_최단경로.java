// 1753번 최단경로
// https://www.acmicpc.net/problem/1753

package BAEKJOON;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Num1753_최단경로 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int v,e,k;
    static List<Node>[] list;
    static int[] dist;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        dist = new int[v + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 1; i <= v; i++){
            list[i] = new ArrayList<>();
        }
        // 리스트에 그래프 정보를 초기화
        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // start에서 end로 가는 weight 가중치
            list[start].add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();
        // 다익스트라 알고리즘
        dijkstra(k);
        // 출력 부분
        for(int i = 1; i <= v; i++){
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i] + "\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        boolean[] check = new boolean[v + 1];
        pQueue.add(new Node(start, 0));
        dist[start] = 0;

        while(!pQueue.isEmpty()){
            Node curNode = pQueue.poll();
            int current = curNode.end;

            if (check[current] == true) {
                continue;
            }
            check[current] = true;

            for(Node node : list[current]){
                if(dist[node.end] > dist[current] + node.weight){
                    dist[node.end] = dist[current] + node.weight;
                    pQueue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}