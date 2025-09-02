/*
Job Sequencing Problem (Greedy)

Problem Statement:
You are given N jobs where every job has a deadline and associated profit. 
Each job takes a single unit of time to complete, and only one job can be 
scheduled at a time. The objective is to maximize the total profit if only 
one job can be scheduled at a particular time slot before or on its deadline.

Return the maximum profit achievable.

Example 1:
Input:
Jobs = [(id=1, deadline=2, profit=100),
        (id=2, deadline=1, profit=19),
        (id=3, deadline=2, profit=27),
        (id=4, deadline=1, profit=25),
        (id=5, deadline=3, profit=15)]
Output: 142
Explanation: 
Schedule Job1 (profit=100) at time 2, Job3 (profit=27) at time 1, 
and Job5 (profit=15) at time 3. Total Profit = 142.

Example 2:
Input:
Jobs = [(id=1, deadline=1, profit=10),
        (id=2, deadline=1, profit=5),
        (id=3, deadline=1, profit=20)]
Output: 20
Explanation:
Only one job can be scheduled before deadline. Choose job with profit=20.
*/

import java.util.*;

public class JobSequencing {
    static class Job {
        int id, deadline, profit;
        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static int maxProfit(Job[] jobs) {
        // Step 1: Sort jobs by profit descending
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int n = jobs.length;
        boolean[] slot = new boolean[n + 1]; // slots tracking (1-based)
        int totalProfit = 0;

        // Step 2: Greedy allocation
        for (Job job : jobs) {
            // Find latest available slot before deadline
            for (int j = Math.min(n, job.deadline); j > 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 2, 100), new Job(2, 1, 19), new Job(3, 2, 27),
            new Job(4, 1, 25), new Job(5, 3, 15)
        };
        System.out.println("Maximum Profit: " + maxProfit(jobs));
    }
}
