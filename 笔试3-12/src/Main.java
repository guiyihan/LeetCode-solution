
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();
        char[][] dp=new char[2][n];
        dp[0]=s.nextLine().toCharArray();
        dp[1]=s.nextLine().toCharArray();
        int[][] dp2=new int[2][n];
        if(dp[0][0]=='.'){
            dp2[0][0]=1;
        }

        dp2[1][0] = 0;

        for (int i = 1; i <n ; i++) {
            if(dp[0][i]=='X'&&dp[1][i]=='X'){
                System.out.println(-1);
                return;
            }
            if(dp[0][i]=='.'){
                dp2[0][i]=dp2[0][i-1]+dp2[1][i-1];
            }
            if(dp[1][i]=='.') {
                dp2[1][i] = dp2[0][i - 1] + dp2[1][i - 1];
            }
        }
        System.out.println(dp2[1][n-1]);
    }
}