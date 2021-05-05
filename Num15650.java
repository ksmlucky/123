//15650번 N과 M(2)
import java.io.*;
import java.util.StringTokenizer;

public class Num15650 {
    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);
        System.out.println(sb);

    }

    public static void dfs(int br, int depth) {

        if (depth == M) {
            for (int i = 0; i<M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        //i가 break부터 시작하게 함
        for (int i = br; i <= N; i++) {

            //현재 depth를 인덱스로 하여 해당 위치에 i값을 담는다
            arr[depth] = i;
            dfs(i + 1, depth + 1);

        }
    }
}
