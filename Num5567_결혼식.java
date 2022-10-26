// 5567번 결혼식
// https://www.acmicpc.net/problem/5567

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num5567_결혼식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arrayLists = new ArrayList[n]; // 인접리스트 배열로 그래프 구현

        for (int i = 0; i < n; i++) {
            arrayLists[i] = new ArrayList<>(); // 인접리스트 배열 초기화
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            // 연결관계 표시
            arrayLists[start].add(end);
            arrayLists[end].add(start);
        }

        boolean[] check = new boolean[n]; // 상근이의 친구들 표시하기 위한 배열 check
        check[0] = true; // 처음 시작 -> 상근이 true

        // 상근이의 친구들 true로
        for (int temp : arrayLists[0]) {
            check[temp] = true;
        }

        check[0] = false; // 상근이는 다시 false로

        boolean[] realCheck = new boolean[n]; // 상근이의 친구의 친구를 표시하기 위한 배열 realCheck

        // 상근이의 친구의 친구들 true로
        for (int i = 0; i < n; i++) {
            if (check[i]) {
                for (int temp : arrayLists[i]) {
                    realCheck[temp] = true;
                }
            }
        }

        realCheck[0] = false; // 상근이가 다시 체크되었을 수도 있으니까 다시 false로

        int answer = 0;

        for (int i = 0; i < check.length; i++) {
            if (realCheck[i] || check[i]) { // true인 애들 만큼 ++
                answer++;
            }
        }

        System.out.println(answer);
    }
}
