import java.io.*;
public class Num9461 {

    public static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<dp.length;i++) {
            dp[i]=-1;
        }

        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;

        int T = Integer.parseInt(br.readLine());

        while(T!=0) {
            sb.append(padovan(Integer.parseInt(br.readLine()))).append('\n');
            T--;
        }
        System.out.println(sb);
    }

    public static long padovan(int N) {
        if(dp[N]==-1) {
            dp[N]=padovan(N-3)+padovan(N-2);
        }

        return dp[N];
    }
}
