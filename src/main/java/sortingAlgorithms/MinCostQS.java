package sortingAlgorithms;

import java.util.*;
//https://www.geeksforgeeks.org/minimum-cost-to-sort-an-array-such-that-swapping-x-and-y-costs-xy/

public class MinCostQS {

    // Function returns the minimum cost
    // to sort the given array
    static int minCost(int arr[], int n)
    {

        // Create array of pairs in which
        // 1st element is the array element
        // and 2nd element is index of first
        int[][] sorted = new int[n][2];

        // Initialize the total cost
        int total_cost = 0;

        for(int i = 0; i < n; i++)
        {
            sorted[i][0] = arr[i];
            sorted[i][1] = i;
        }

        // Sort the array with respect to
        // array value
        Arrays.sort(sorted, (a, b) -> a[0] - b[0]);

        // Initialize the overall minimum
        // which is the 1st element
        int overall_minimum = sorted[0][0];

        // To keep track of visited elements
        // create a visited array & initialize
        // all elements as not visited
        boolean[] vis = new boolean[n];

        // Iterate over every element
        // of the array
        for(int i = 0; i < n; i++)
        {

            // If the element is visited or
            // in the sorted position, and
            // check for next element
            if (vis[i] && sorted[i][1] == i)
                continue;

            // Create a vector which stores
            // all elements of a cycle
            ArrayList<Integer> v = new ArrayList<>();
            int j = i;

            // It covers all the elements
            // of a cycle
            while (!vis[j])
            {
                vis[j] = true;
                v.add(sorted[j][0]);
                j = sorted[j][1];
            }

            // If cycle is found then the
            // swapping is required
            if (v.size() > 0)
            {

                // Initialize local minimum with
                // 1st element of the vector as
                // it contains the smallest
                // element in the beginning
                int local_minimum = v.get(0), result1 = 0,
                        result2 = 0;

                // Stores the cost with using only
                // local minimum value.
                for(int k = 1; k < v.size(); k++)
                    result1 += (local_minimum * v.get(k));

                // Stores the cost of using both
                // local minimum and overall minimum
                for(int k = 0; k < v.size(); k++)
                    result2 += (overall_minimum * v.get(k));

                // Update the result2
                result2 += (overall_minimum *
                        local_minimum);

                // Store the minimum of the
                // two result to total cost
                total_cost += Math.min(result1, result2);
            }
        }

        // Return the minimum cost
        return total_cost;
    }

    // Driver code
    public static void main (String[] args)
    {

        // Given array arr[]
        int arr[] = { 1, 8, 9, 7, 6 };
        int n = arr.length;

        // Function call
        System.out.print(minCost(arr, n));
    }
}