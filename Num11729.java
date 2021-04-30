import java.util.*;

public class Num11729 {
    static int num,cnt=0;
    static StringBuilder sb = new StringBuilder();
    static void Hanoi(int n,int start,int bridge,int end) {
        cnt++;
        if(n==1) {	// 원판이 1개
            sb.append(start+" "+end+"\n");
            return;
        }
        else {
            Hanoi(n-1,start,end,bridge); // n-1을 한 후, 1-3-2로 원판을 전달
            sb.append(start+" "+end+"\n");
            Hanoi(n-1,bridge,start,end); // n-1을 한 후, 2-1-3으로 원판을 전달
        }
    }

    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();

        Hanoi(num,1,2,3);
        System.out.println(cnt);
        System.out.println(sb);
    }

}