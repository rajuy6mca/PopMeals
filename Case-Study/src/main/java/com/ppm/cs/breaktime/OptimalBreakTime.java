package com.ppm.cs.breaktime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find optimal break between tasks.
 */
public class OptimalBreakTime {

    public static void main(String[] args) {

        int[] arr1 = {1, 4, 1, 3, 1};
        int[] arr2 = {1, 4, 1, 3};

        System.out.println("Optimal break index for arr1 : "+findOneOptimalBreakTime(arr1));
        System.out.println("Optimal break index for arr2 : "+findOneOptimalBreakTime(arr2));

    }

    public static Integer findOneOptimalBreakTime(int[] inputArr) {
        int leftSum = 0;
        // Find total sum first
        int rightSum = Arrays.stream(inputArr).sum();
        // Find optimal break index
        for (int ind = 0; ind < inputArr.length; ind++) {
            leftSum = leftSum + inputArr[ind];
            rightSum = rightSum - inputArr[ind];
            if (leftSum == rightSum) {
                return ind;
            }
        }
        return null;
    }

    public static List<Integer> findAllOptimalBreakTime(int[] inputArr) {
        List<Integer> breakTimeIndices = new ArrayList<>();
        int leftSum = 0;
        // Find total sum first
        int rightSum = Arrays.stream(inputArr).sum();
        // Find optimal break index
        for (int ind = 0; ind < inputArr.length; ind++) {
            leftSum = leftSum + inputArr[ind];
            rightSum = rightSum - inputArr[ind];
            if (leftSum == rightSum) {
                breakTimeIndices.add(ind);
            }
        }
        return (breakTimeIndices.isEmpty() ? null : breakTimeIndices);
    }
}
