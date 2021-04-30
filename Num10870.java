import java.util.Scanner;

public class Num10870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        System.out.println(Fb(num));
    }

    public static int Fb(int num) {
        if(num==0)
        {
            return 0;
        }

        else if(num==1)
        {
            return 1;
        }

        else
        {
            return Fb(num-1)+Fb(num-2);
        }
    }
}
