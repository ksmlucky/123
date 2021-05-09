import java.io.*;

public class Num1003 {

    static int T,N;
    static int check[] = new int[41]; //이미 한번 계산한 값인지를 체크하는 배열
    static int dp[][]; //fb0과 fb1의 실행 횟수를 저장할 배열


    static int Fb(int N) { // 문제에서 주어진 피보나치 수열 메소드를 일부 수정
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if(check[N] != 0) {  //fb(N)이 이미 계산한 값인 경우
            return check[N]; //이미 저장되어 있는 값을 리턴
        }
        else {	//처음 계산하는 경우 --> 계산해서 check배열의 N번째에 저장
            return check[N] = Fb(N-1) + Fb(N-2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        dp = new int [41][2]; //fb0과 fb1의 실행횟수를 저장 할 배열

        dp[0][0]=1;
        dp[0][1]=0;
        dp[1][0]=0;
        dp[1][1]=1;

        for(int i=0;i<T;i++) { //테스트 케이스 반복
            N = Integer.parseInt(br.readLine());
            Fb(N); //N을 입력받아 피보나치 수행

            for(int j=2;j<=N;j++) { //0번과 1번은 미리 저장해두었으므로 2번부터 시작
                dp[j][0] = dp[j-1][0] +dp[j-2][0]; // 점화식
                dp[j][1] = dp[j-1][1] +dp[j-2][1];
            }

            sb.append(dp[N][0] + " " + dp[N][1]).append('\n');
        }

        System.out.println(sb);
    }

}
