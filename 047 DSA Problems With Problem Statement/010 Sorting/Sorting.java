/*
Sort Array in Ascending Order using Multiple Algorithms
------------------------------------------------------
Write a Java program to sort an integer array in ascending order using multiple sorting algorithms.

The program should:
1. Implement the following sorting algorithms to sort an array in ascending order:
   a) Bubble Sort
      - Repeatedly swap adjacent elements if they are in wrong order.
   b) Selection Sort
      - Select the minimum element from the unsorted portion and place it at the correct position.
   c) Insertion Sort
      - Build the sorted portion by inserting each element at its correct position.
   d) Counting Sort
      - Count the occurrences of each element.
      - Reconstruct the array in ascending order based on counts.
2. In the main method, define an integer array.
3. Call one of the sorting methods and print the sorted array.

Example:
Input: [3, 6, 2, 1, 8, 7, 4, 5]
Output (ascending): [1, 2, 3, 4, 5, 6, 7, 8]
*/


class Sorting {


    //Bubble Sort
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }


    //Selection Sort
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    //Insertion Sort
    public static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int curr = arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>curr ){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=curr;
        }
    }


    //Counting Sort
    public static void countingSort(int[] arr){
        int max= Integer.MIN_VALUE;

        //Finding Max value/range
        for(int n: arr){
            if(max<n){
                max= n;
            }
        }

        //Creating helping array
        int[] count= new int[max+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }

        //Sorting
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                count[i]--;
                j++;
            }
        }
    }




    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};

        countingSort(arr);
        
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
