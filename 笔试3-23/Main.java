import java.util.Scanner;

public class Main {
    //由于含有除法，所以取模运算产生错误
    public static void solution1(String... args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int mod = 1000000007;
        int res = 0;
        for (int i = 1; i <= N; i++) {
            long temp = 1;
            for (int j = 0, k = i - 1; j < i; j++) {
                temp = (temp % mod) * ((N - j) % mod);
            }
            for (int j = i - 1; j >= 1; j--) {
                temp = temp / j;
            }

            res = (int) (res % mod + temp % mod) % mod;
        }
        System.out.println(res);
    }

    //数学方法：组合总数公式：C(1,n) + C(2,n) + ... + C(n,n)=2^(n)-1
    // 可以推出C(1,n)*1 + C(2,n)*2 + ... + C(n,n)*n推出n*2^(n)
    public static void solution2(String... args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt() - 1;
        int mod = 1000000007;
        int res = 1;
        for (int i = 1; i <= N; i++) {
            res = (res << 1) % mod;
        }
        res = ((res % mod) * (N % mod)) % mod;
        System.out.println(res);
    }

    //使用快速幂降低复杂度
    public static void solution3(String... args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt() - 1;
        int mod = 1000000007;
        int res = mod_pow(2, N, mod);
        System.out.println(((res % mod) * (N % mod)) % mod);
        return;
    }

    public static int mod_pow(long x, long n, int mod) {
        long ans = 1;
        while (n > 0) {
            if (n % 2 == 1)
                ans = ans * x % mod;
            x = x * x % mod;
            n >>= 1;
        }
        return (int) ans;
    }


}