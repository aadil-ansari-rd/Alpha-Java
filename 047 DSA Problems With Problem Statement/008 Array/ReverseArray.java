/*
Reverse an Array In-Place
-------------------------
Write a Java program to reverse the elements of a given integer array in place.

The program should:
1. Implement a method `reverseArray(int[] nums)` that reverses the array without using extra space:
   - Swap elements from start and end using arithmetic operations or a temporary variable.
2. In the main method, define an integer array.
3. Print the original array.
4. Call the `reverseArray` method.
5. Print the reversed array.

Example:
Input Array: {1, 2, 3, 4, 5}
Output:
Original Array: 1 2 3 4 5
Reversed Array: 5 4 3 2 1
*/


public class ReverseArray {

    public static void reverseArray(int[] nums) {
        int st = 0, end = nums.length - 1;
        while (st < end) {
            nums[st] = nums[st] + nums[end];
            nums[end] = nums[st] - nums[end];
            nums[st] = nums[st] - nums[end];
            st++; end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 7, 8, 10, 11, 12, 13, 16, 18, 19, 22, 25, 26, 28, 30, 34, 35, 36, 38, 39, 41, 43, 44, 45, 47, 48, 53, 55, 56, 60, 62, 63, 67, 73, 75, 78, 80, 81, 84, 85, 86, 88, 90, 91, 92, 97, 98};
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        reverseArray(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }
}
