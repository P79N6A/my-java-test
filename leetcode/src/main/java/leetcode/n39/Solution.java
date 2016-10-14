package leetcode.n39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		int[] candidates = { 1, 2 };
		System.out.println(new Solution().combinationSum(candidates, 3));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		return getCombinationSum(candidates, candidates.length, target);

	}

	public List<List<Integer>> getCombinationSum(int[] candidates, int n, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates[0] <= target) {
			for (int i = n - 1; i >= 0; i--) {
				if (candidates[i] < target) {
					List<List<Integer>> subList = getCombinationSum(candidates, i + 1, target - candidates[i]);
					if (subList != null && !subList.isEmpty()) {
						for (List<Integer> list : subList) {
							list.add(candidates[i]);
						}
					}
					result.addAll(subList);
				} else {
					if (candidates[i] == target) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(target);
						result.add(list);
					}
				}
			}
		}
		return result;
	}

}
