// 17298번 오큰수
// https://bbobye.atlassian.net/jira/software/projects/STUD/boards/1/roadmap?selectedIssue=STUD-114

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num17298 {
    static int N;

    private void NGE(int arr[]) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < arr.length; i++) {
            // 스택에 배열의 인덱스를 넣고, 현재 인덱스의 배열의 값을 비교해 나감
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }

        Num17298 sol = new Num17298();
        sol.NGE(arr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb.toString());
    }

}
