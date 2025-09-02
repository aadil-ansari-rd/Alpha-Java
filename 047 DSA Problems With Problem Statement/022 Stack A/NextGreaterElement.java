/*
Problem Name: Next Greater Element (NGE) in Array
-------------------------------------------------
Problem Statement:
-----------------
Given an array of integers, for each element, find the next greater element 
(NGE) to its right in the array. If no greater element exists for a particular 
element, return -1 for that position.

You need to:
1. Traverse the array from right to left.
2. Use a stack to keep track of potential next greater elements.
3. Pop elements from the stack that are smaller or equal to the current element.
4. If the stack is empty, assign -1; otherwise, assign the top element of the stack as NGE.
5. Push the current element index onto the stack.
6. Return the resulting array of next greater elements.

Example:
--------
Input: [4, 5, 2, 25]
Output: [5, 25, 25, -1]
Explanation: 
- Next greater element for 4 is 5
- Next greater element for 5 is 25
- Next greater element for 2 is 25
- Next greater element for 25 does not exist, so -1
*/


import java.util.Stack;
public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums){
        Stack <Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }else{
                ans[i]=nums[st.peek()];
            }
            st.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 25};
        int[] ans = nextGreaterElement(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
