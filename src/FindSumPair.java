import java.util.ArrayList;
import java.util.Random;

public class FindSumPair {

    public static void main(String[] args) {
        int[] numbers = generateRandomList(500);
        sort(numbers);
        int targetSum = getTargetSum(numbers);
        System.out.println("target sum is : " + targetSum);
        ArrayList<Integer> indexes = findSumPairIndices(numbers, targetSum);

        if (indexes.isEmpty()) {
            System.out.println("there is not any two number with sum " + targetSum);
        } else {
            System.out.println("find numbers " + numbers[indexes.get(0)] + " and " + numbers[indexes.get(1)] + " with sum " + targetSum);
        }
    }

    private static int[] generateRandomList(int size) {
        Random random = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(1000);
        }
        return numbers;
    }

    private static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static Integer getTargetSum(int[] number) {
        Random rnd = new Random();
        Integer number1 = number[rnd.nextInt(500)];
        Integer number2 = number[rnd.nextInt(500)];
        return number1 + number2;
    }

    private static ArrayList<Integer> findSumPairIndices(int[] numbers, int targetSum) {
        int left = 0;
        int right = numbers.length - 1;
        ArrayList<Integer> index = new ArrayList<>();

        while (left <= right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == targetSum) {
                index.add(left);
                index.add(right);
                return index;
            } else if (currentSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return index;
    }
}
