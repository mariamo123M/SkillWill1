import java.util.Scanner;

public class FindNumber {
    public static void main(String[] args) {
        int[] numbers = {14, 20, 24, 11, 7, 9, 3, 34, 12, 28};
        int searchNum = 24;

        findNumber(numbers, searchNum);
    }

    static void findNumber(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                System.out.println(number + " is at index " + i);
                return;
            }
        }
        System.out.println("Not found" + number);
    }
}
