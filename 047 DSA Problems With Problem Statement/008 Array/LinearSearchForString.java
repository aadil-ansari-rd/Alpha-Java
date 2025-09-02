/*
Linear Search in a String Array
-------------------------------
Write a Java program to perform a linear search on an array of strings.

The program should:
1. Implement a method `linearSearch(String[] fStrings, String key)` that iterates through the string array `fStrings` to find the `key`.
   - Return the index of the key if found.
   - Return -1 if the key is not present in the array.
2. In the main method, define an array of strings (fruits).
3. Specify a string to search in the array.
4. Call the `linearSearch` method and display the index if the string is found, or a message indicating it was not found.

Example:
Array: {"Apple", "Banana", "Orange", "Mango"}
Key: "Orange"
Output: Your fruit is at index : 2
*/

public class LinearSearchForString {
    public static int linearSearch(String[] fStrings, String key){
        for(int i=0; i<fStrings.length;i++){
            if(fStrings[i].equals(key)){
                return  i;
            }
        }
        return  -1;
    }
    public static void main(String[] args) {
        String[] fruits={"Apple", "Banana", "Orange", "Mango", "Pineapple", "Grapes", "Papaya", "Strawberry", "Blueberry", "Watermelon", "Kiwi", "Peach", "Cherry", "Pear", "Guava", "Litchi", "Pomegranate", "Coconut", "Plum", "Apricot"};
        String searchFruit = "Strawberry";
        int index = linearSearch(fruits, searchFruit);
        if(index==-1){
            System.out.println("Fruit not found");
        }else{
            System.out.println("Your fruit is at index : "+ index);
        }
    }
}
