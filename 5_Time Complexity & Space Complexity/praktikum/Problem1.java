public class Problem1 {

    public static String primeNumber(int n) {
        if (n == 1)
            return ("Bukan bilangan prima");
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return ("Bukan bilangan prima");
            }
        }
        return ("Bilangan prima");
    }

    public static void main(String[] args) {
        System.out.println(primeNumber(1000000007));
        System.out.println(primeNumber(13));
        System.out.println(primeNumber(17));
        System.out.println(primeNumber(20));
        System.out.println(primeNumber(35));

    }
}