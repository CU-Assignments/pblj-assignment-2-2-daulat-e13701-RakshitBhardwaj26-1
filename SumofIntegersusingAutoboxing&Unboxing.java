import java.util.*;

class SumCalculator {
    public static int sumList(List<Integer> nums) {
        int sum = 0;
        for (Integer num : nums) sum += num;
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers (comma-separated): ");
        String[] input = sc.nextLine().split(",");
        for (String s : input) nums.add(Integer.parseInt(s.trim()));

        System.out.println("Sum: " + sumList(nums));
        sc.close();
    }
}
