// 11000번 강의실 배정
// https://www.acmicpc.net/problem/11000

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int arr[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //자바16 이상은 가능
        // 1열은 시작시간, 2열은 끝나는 시간.
        // 시작시간 오름차순으로 정렬, 시작시간이 같은 경우 끝나는 시간 오름차순 정렬
        Arrays.sort(arr, (o1, o2) ->{   // (o1, o2): 오름차순으로 정렬한다
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[1], o2[1]);   // 1열의 원소가 같을 경우 2열의 원소를 비교하겠다
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

//        // 자바16 이상 아니면 이 방법으로
//        Arrays.sort(arr, (o1, o2) -> {
//            if (o1[0] == o2[0]) return o1[1] - o2[1]; //같은 시작시간일 경우 빨리 끝나는 순서로(끝나는시간오름차순)
//            else return o1[0] - o2[0]; //시작시간 순 정렬
//        });

        // 우선순위큐 사용
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < N; i++) {
            int start = arr[i][0], end = arr[i][1];

            // 현재 수업의 종료 시간이 다음 수업의 시작시간보다 작거나 같고,
            // 우선순위큐가 비어있지 않으면 poll()
            if (!pq.isEmpty() && pq.peek() <= start) {  // if문 안에서 조건식의 순서도 중요!

                pq.poll();
            }
            pq.add(end);
        }

        System.out.println(pq.size());

    }
}
