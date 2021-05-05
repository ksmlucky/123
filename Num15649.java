//15649번 N과 M(1)
import java.io.*;
import java.util.StringTokenizer;

public class Num15649 {
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];
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

        for (int i = 0; i < N; i++) {	//노드를 방문하지 않은 경우
            if (visit[i]==false) {
                visit[i] = true;	//노드를 방문했다는 뜻
                arr[depth] = i + 1;	//해당 깊이를 index로 하여 i+1 값 저장
                dfs(N, M, depth + 1);	//다음 자식 노드 방문을 위해서 깊이 1 증가시키면서 재귀

                visit[i] = false;	//자식노드 방문이 끝나고 돌아오면 방문 노드를 방문하지 않은 상태로 변경
            }
        }
    }

}
