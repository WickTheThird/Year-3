package kotlinImp.between30and40;
import java.text.DecimalFormat;

public class NumCombinations {

    public static void main(String[] args) {
        System.out.println(formatResult(findNumCombinations(50)));
    }

    public static double findNumCombinations(int n) {
        double[] nums = new double[n + 1];
        nums[0] = nums[1] = 1;
        nums[2] = 2;
        nums[3] = 4;

        for (int i = 4; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3] + nums[i - 4];
        }

        return nums[n];
    }

    public static String formatResult(double result) {
        DecimalFormat df = new DecimalFormat("0");
        return df.format(result);
    }
}
