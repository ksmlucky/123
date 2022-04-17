// 14719번 빗물
// https://www.acmicpc.net/problem/14719

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14719_빗물 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 블록들의 높이를 저장하기 위한 배열
        arr = new int[W];

        // 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0; // 정답(총 빗물)

        for (int i = 1; i < arr.length - 1; i++) {
            int leftTop = getLeftTop(i);
            int rightTop = getRightTop(i);
            
            // 자신의 왼쪽이나 오른쪽에 자신보다 큰 블록이 없으면 빗물은 흘러내리니까 continue
            if (leftTop == arr[i] || rightTop == arr[i]) {
                continue;
            }
            
            // 왼쪽 오른쪽 중 작은애 
            int standard = Math.min(leftTop, rightTop);

            // standard에서 현재 블록의 높이를 빼면 현재 블록 위에 있는 빗물
            answer += standard - arr[i];
        }

        System.out.println(answer);
    }

    // 현재 인덱스 기준 왼쪽에서 제일 큰 값 찾기
    private static int getLeftTop(int index) {
        int leftTop = arr[index];

        // 현재 위치부터 처음 인덱스까지
        for (int i = index - 1; i >= 0; i--) {
            if (arr[i] > leftTop) {
                leftTop = arr[i];
            }
        }

        return leftTop;
    }

    // 현재 인덱스 기준 오른쪽에서 제일 큰 값 찾기
    private static int getRightTop(int index) {
        int rightTop = arr[index];

        // 현재 위치부터 마지막 인덱스까지
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] > rightTop) {
                rightTop = arr[i];
            }
        }

        return rightTop;
    }
}
