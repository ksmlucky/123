// 1931번 회의실 배정
// https://www.acmicpc.net/problem/1931

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 2차원 배열의 2열의 원소들을 기준으로 오름차순 정렬
        Arrays.sort(arr, (o1, o2) ->{   // (o1, o2): 오름차순으로 정렬한다
            if (o1[1] == o2[1]) {   // 1열이 아닌 2열의 원소를 기준으로 정렬한다
                return Integer.compare(o1[0], o2[0]);   // 2열의 원소가 같을 경우 1열의 원소를 비교하겠다
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        // 끝나는 시간이 작은거부터 겹치지 않게 count해줌
        int count = 0, end = 0;
        for (int i = 0; i < N; i++) {
            if (end <= arr[i][0]) {
                end = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
