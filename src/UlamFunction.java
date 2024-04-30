public class UlamFunction {
    public static void main(String[] args) {
        for (int n = 1; n < 1000000; n++) {
            int result = ulam(n);
            System.out.println("Ulam(" + n + ") = " + result);
        }
    }

    public static int ulam(int n) {
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }
        return n;
    }
}
