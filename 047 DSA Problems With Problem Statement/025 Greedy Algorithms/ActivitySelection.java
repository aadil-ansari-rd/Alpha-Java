/*
Problem: Activity Selection Problem

Description:
You are given two arrays `start[]` and `end[]` of equal size, where `start[i]` and `end[i]` represent the start time and finish time of the ith activity.  
Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on one activity at a time.  
The solution follows the greedy approach of always choosing the activity with the earliest finishing time.

There are three variations:
1. maxActivities1() → end[] is NOT sorted, return only the maximum count of activities.
2. maxActivities2() → end[] is already sorted, return maximum count and print activity sequence.
3. maxActivities3() → end[] is NOT sorted, return maximum count and print the actual activity indices.

Example:
Input:
start = [1, 3, 0, 5, 8, 5]
end   = [2, 4, 6, 7, 9, 9]

Output:
Maximum Job Selected: 4
Job Sequence: A0 A1 A3 A4

Explanation:
- Select activity 0 (start=1, end=2)
- Select activity 1 (start=3, end=4)
- Skip activity 2 (conflicts)
- Select activity 3 (start=5, end=7)
- Select activity 4 (start=8, end=9)
Total = 4 activities
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    // Max Activity 1 : end[] is not sorted , return maxActivites
    public static int maxActivities1(int[] start, int[] end) {
        int n = start.length;
        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = end[i];
        }
        // Sorting
        Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        int lastEnd = activities[0][1];
        // Selection Activities
        for (int i = 1; i < n; i++) {
            if (activities[i][0] >= lastEnd) {
                count++;
                lastEnd = activities[i][1];
            }
        }
        System.out.println("Maximum Job Selected maxActivities1() : " + count);
        return count;
    }

    // Max Activity 1 : end[] is sorted , return maxActivites and print
    // ActivityNumber
    public static int maxActivities2(int[] start, int[] end) {
        ArrayList<Integer> ans = new ArrayList<>();
        // Selection Activity
        int count = 1;
        int lastEnd = end[0];
        ans.add(0);
        for (int i = 1; i < start.length; i++) {
            if (start[i] >= lastEnd) {
                count++;
                ans.add(i);
            }
        }
        System.out.println("Maximum Job Selected in maxActivities2() : " + count);
        System.out.print("Job Sequence Are : ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
        return count;
    }

    // Max Activity 1 : end[] is not sorted , return maxActivites and print
    // ActivityNumber
    public static int maxActivities3(int[] start, int[] end) {
        int n = start.length;
        int[][] activities = new int[n][3];
        for (int i = 0; i < n; i++) {
            activities[i][0] = i; //Store original idx bcz after sorting the indexes will change.
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        // Array Sorting on the basis of end[] in sascending order
        Arrays.sort(activities, Comparator.comparingInt(a -> a[2]));

        // Selection Activity
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 1;
        int lastEnd = activities[0][2];
        ans.add(activities[0][0]);
        for (int i = 1; i < start.length; i++) {
            if (activities[i][1] >= lastEnd) {
                count++;
                ans.add(activities[i][0]);
            }
        }
        System.out.println("Maximum Job Selected in maxActivities3() : " + count);
        System.out.print("Job Sequence Are : ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
        return count;
    }

    public static void main(String[] args) {
        // 👉 Test Case 1: end[] is NOT sorted → maxActivities1()
        int[] start1 = {1, 3, 0, 5, 8, 5};
        int[] end1 = {2, 4, 6, 7, 9, 9};
        maxActivities1(start1, end1);

        // 👉 Test Case 2: end[] is already sorted → maxActivities2()
        int[] start2 = {1, 3, 0, 5, 8, 5};
        int[] end2 = {2, 4, 6, 7, 9, 9};
        // Manually sort both start[] and end[] together by end[]
        Integer[] idx = new Integer[start2.length];
        for (int i = 0; i < idx.length; i++) idx[i] = i;
        Arrays.sort(idx, Comparator.comparingInt(i -> end2[i]));

        int[] sortedStart = new int[start2.length];
        int[] sortedEnd = new int[end2.length];
        for (int i = 0; i < idx.length; i++) {
            sortedStart[i] = start2[idx[i]];
            sortedEnd[i] = end2[idx[i]];
        }

        maxActivities2(sortedStart, sortedEnd);

        // 👉 Test Case 3: end[] is NOT sorted → maxActivities3()
        int[] start3 = {4, 1, 2, 6, 3};
        int[] end3 = {7, 3, 8, 9, 5};
        maxActivities3(start3, end3);
    }

}

// public class MaxActivitySelection {

//     // ✅ Case 1: end[] is NOT sorted, only count is returned
//     public static int maxActivities1(int[] start, int[] end) {
//         int n = start.length;
//         int[][] activities = new int[n][2]; // [start, end]

//         // Step 1: Combine start[] and end[] into activities[][]
//         for (int i = 0; i < n; i++) {
//             activities[i][0] = start[i];
//             activities[i][1] = end[i];
//         }

//         // Step 2: Sort activities based on end time (greedy principle)
//         Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));

//         // Step 3: Select first activity
//         int count = 1;
//         int lastEnd = activities[0][1];

//         // Step 4: Select next compatible activities
//         for (int i = 1; i < n; i++) {
//             if (activities[i][0] >= lastEnd) {
//                 count++;
//                 lastEnd = activities[i][1];
//             }
//         }

//         System.out.println("Maximum Job Selected maxActivities1() : " + count);
//         return count;
//     }

//     // ✅ Case 2: end[] is sorted, print count and sequence of activities
//     public static int maxActivities2(int[] start, int[] end) {
//         ArrayList<Integer> ans = new ArrayList<>();

//         // Step 1: Select first activity always (greedy approach)
//         int count = 1;
//         int lastEnd = end[0];
//         ans.add(0);

//         // Step 2: Loop through activities and select if compatible
//         for (int i = 1; i < start.length; i++) {
//             if (start[i] >= lastEnd) {
//                 count++;
//                 ans.add(i); // store activity index
//                 lastEnd = end[i];
//             }
//         }

//         // Step 3: Print result
//         System.out.println("Maximum Job Selected in maxActivities2() : " + count);
//         System.out.print("Job Sequence Are : ");
//         for (int i = 0; i < ans.size(); i++) {
//             System.out.print("A" + ans.get(i) + " ");
//         }
//         System.out.println();
//         return count;
//     }

//     // ✅ Case 3: end[] is NOT sorted, print count and actual activity numbers
//     public static int maxActivities3(int[] start, int[] end) {
//         int n = start.length;
//         int[][] activities = new int[n][3]; // [index, start, end]

//         // Step 1: Combine index, start, and end into activities[][]
//         for (int i = 0; i < n; i++) {
//             activities[i][0] = i; //Store original idx bcz after sorting the indexes will change.
//             activities[i][1] = start[i];
//             activities[i][2] = end[i];
//         }

//         // Step 2: Sort by end time
//         Arrays.sort(activities, Comparator.comparingInt(a -> a[2]));

//         // Step 3: Select first activity
//         ArrayList<Integer> ans = new ArrayList<>();
//         int count = 1;
//         int lastEnd = activities[0][2];
//         ans.add(activities[0][0]);

//         // Step 4: Select compatible activities based on start time
//         for (int i = 1; i < n; i++) {
//             if (activities[i][1] >= lastEnd) {
//                 count++;
//                 ans.add(activities[i][0]); // store original index
//                 lastEnd = activities[i][2];
//             }
//         }

//         // Step 5: Print result
//         System.out.println("Maximum Job Selected in maxActivities3() : " + count);
//         System.out.print("Job Sequence Are : ");
//         for (int i = 0; i < ans.size(); i++) {
//             System.out.print("A" + ans.get(i) + " ");
//         }
//         System.out.println();
//         return count;
//     }
// }
