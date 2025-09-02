/*
FizzBuzz Problem
----------------
Write a Java program to implement the classic "FizzBuzz" problem for numbers 1 to 30.

The program should:
1. Iterate through numbers from 1 to 30.
2. For each number:
   - If the number is divisible by both 3 and 5, add "FizzBuzz" to the output list.
   - If the number is divisible by 3 only, add "Fizz" to the output list.
   - If the number is divisible by 5 only, add "Buzz" to the output list.
   - Otherwise, add the number itself as a string.
3. Print all elements of the output list.

Example Output:
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
...
*/


import java.util.ArrayList;
import java.util.List;

public class FizzBuzz{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for(int i=1; i<=30 ; i++){
            if(i%15==0){
                list.add("FizzBuzz");
            }else if(i%3==0){
                list.add("Fizz");
            }else if(i%5==0){
                list.add("Buzz");
            } else{
                list.add(Integer.toString(i));
            }
        }
        for (Object elem : list) {
            System.out.println(elem);
        }
    }
}