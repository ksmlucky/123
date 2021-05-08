import java.io.*;

public class Num9663 {
    public static int N;
    public static int[] arr;
    public static int count = 0;

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        Queen(0);
        System.out.println(count);
    }

    public static void Queen(int depth) {

        //깊이만큼 탐색을 완료한 경우 cnt++
        if(depth==N) {
            count++;
            return;
        }


        for(int i=0;i<N;i++) {
            arr[depth]=i;

            //가능한 경우(true)에만 재귀
            if(Check(depth)) {
                Queen(depth+1);
            }
        }

    }

    public static boolean Check(int row) {
        for(int i=0;i<row;i++) {
            //해당 행의 열과 i행의 열이 일치할 경우(같은 행에 존재할 경우)
            if(arr[row]==arr[i]) {
                return false;
            }

            //퀸이 대각선에 위치할 경우
            else if(Math.abs(row-i)==Math.abs(arr[row]-arr[i])) {
                return false;
            }
        }

        return true;
    }

}