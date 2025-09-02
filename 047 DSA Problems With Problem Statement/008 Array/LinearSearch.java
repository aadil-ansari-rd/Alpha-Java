/*
Linear Search in an Array
-------------------------
Write a Java program to perform a linear search on an integer array.

The program should:
1. Implement a method `linearSearch(int[] nums, int key)` that iterates through the array `nums` to find the `key`.
   - Return the index of `key` if found.
   - Return -1 if the key is not present in the array.
2. In the main method, define an integer array.
3. Specify a key to search in the array.
4. Call the `linearSearch` method and display the index if the element is found, or a message indicating it was not found.

Example:
Array: {5, 12, 7, 9, 20}
Key: 9
Output: Your element is at index : 3
*/

class LinearSearch{
    public static int linearSearch(int[] nums, int key){
        for(int i=0; i<nums.length;i++){
            if(nums[i]==key){
                return  i;
            }
        }
        return  -1;
    }
    public static void main(String[] args) {
        int[] numbers= {53, 85, 36, 75, 90, 25, 62, 60, 34, 55, 98, 19, 22, 91, 86, 6, 3, 38, 67, 73, 81, 48, 30, 35, 80, 11, 47, 12, 1, 45, 88, 63, 7, 84, 78, 18, 41, 43, 8, 10, 5, 16, 44, 56, 92, 97, 26, 28, 13, 39};
        int searchItem = 69;
        int index = linearSearch(numbers, searchItem);
        if(index==-1){
            System.out.println("Element not found");
        }else{
            System.out.println("Your element is at index : "+ index);
        }

    }
}