//15651번 N과 M(3)
import java.io.*;
import java.util.StringTokenizer;

public class Num15651 {
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        dfs(N, M, 0);
        System.out.println(sb);
    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {	//깊이가 M과 같으면 출력
            for (int i = 0; i<M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {	//노드를 방문하지 않은 경우
            arr[depth] = i;	//해당 깊이를 index로 하여 i값 저장
            dfs(N, M, depth + 1);	//다음 자식 노드 방문을 위해서 깊이 1 증가시키면서 재귀

        }
    }

}