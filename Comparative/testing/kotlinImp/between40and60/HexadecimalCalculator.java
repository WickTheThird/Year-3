public class HexadecimalCalculator {
    public static void main(String[] args) {
        String result = calculateHexadecimalNumbers();
        System.out.println(result);
    }

    public static String calculateHexadecimalNumbers() {
        long total_count = 0;
        for (int n = 1; n <= 16; n++) {
            total_count += 15 * power(16, n - 1) + 41 * power(14, n - 1) - (43 * power(15, n - 1) + power(13, n));
        }
        return Long.toHexString(total_count).toUpperCase();
    }

    public static long power(int base, int exponent) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}
