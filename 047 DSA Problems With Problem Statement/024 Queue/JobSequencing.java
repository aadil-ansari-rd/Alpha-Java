/*
Problem Name: Job Sequencing Problem

Problem Statement:
-----------------
Given a set of jobs where each job has an ID, a deadline, and a profit, schedule the jobs to maximize total profit under the constraint that only one job can be scheduled at a particular time slot and each job takes exactly 1 unit of time. The job must be completed before or on its deadline.

Approach:
---------
1. Sort all jobs in decreasing order of profit.
2. Initialize an array to keep track of free time slots.
3. Iterate through each job:
   - Find the latest available slot before its deadline.
   - If a slot is free, assign the job to that slot and mark it as occupied.
4. Continue until all jobs are considered or no slots remain.
5. Return or print the sequence of scheduled jobs maximizing profit.

Key Points:
-----------
- Greedy approach based on highest profit first.
- Time Complexity: O(n log n) due to sorting + O(n*d) for slot assignment (d = max deadline)
- Space Complexity: O(d) for slots array.
- Ensures no overlapping jobs and maximizes profit.

Example:
--------
Input Jobs: 
  Job ID | Deadline | Profit
    a    |    4     |  20
    b    |    1     |  10
    c    |    1     |  40
    d    |    1     |  30

Output Scheduled Jobs: c a
Explanation: Schedule 'c' at slot 1 and 'a' at slot 4 to maximize profit.
*/


import java.util.*;

class Job {
    String id;
    int deadline;
    int profit;

    public Job(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    // Function to schedule jobs to maximize profit
    public static void jobScheduling(Job[] jobs) {
        // Sort jobs in decreasing order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find maximum deadline to size the slots
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        String[] result = new String[maxDeadline + 1]; // Slots start from 1 index
        Arrays.fill(result, "");

        for (Job job : jobs) {
            // Find a free slot for this job (from its deadline to 1)
            for (int slot = job.deadline; slot >= 1; slot--) {
                if (result[slot].equals("")) {
                    result[slot] = job.id; // Assign job
                    break;
                }
            }
        }

        // Print scheduled jobs
        for (int i = 1; i <= maxDeadline; i++) {
            if (!result[i].equals("")) {
                System.out.print(result[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job("a", 4, 20),
            new Job("b", 1, 10),
            new Job("c", 1, 40),
            new Job("d", 1, 30)
        };

        jobScheduling(jobs);  // Output: c a
    }
}
