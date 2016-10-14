package leetcode.n40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		System.out.println(new Solution().combinationSum2(candidates, 8));
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = getCombinationSum(candidates, candidates.length, target);
		Set<List<Integer>> set = new HashSet<List<Integer>>(result);
		return new ArrayList<List<Integer>>(set);

	}

	public List<List<Integer>> getCombinationSum(int[] candidates, int n, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates[0] <= target) {
			for (int i = n - 1; i >= 0; i--) {
				if (candidates[i] < target) {
					List<List<Integer>> subList = getCombinationSum(candidates, i, target - candidates[i]);
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
