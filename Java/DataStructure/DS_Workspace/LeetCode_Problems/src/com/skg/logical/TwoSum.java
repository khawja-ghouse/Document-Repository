package com.skg.logical;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target)
					return new int[] { i, j };
			}
		}

		return nums;

	}

	public static void main(String[] args) {
		int array[] = new int[] { 3, 3 };
		int target = 6;

		int requiredArray[] = twoSum(array, target);

		for (int i = 0; i < requiredArray.length; i++) {
			System.out.println(requiredArray[i]);
		}
	}
}
