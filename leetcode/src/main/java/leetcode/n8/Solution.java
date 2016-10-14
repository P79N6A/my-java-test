package leetcode.n8;

public class Solution {

	public static void main(String[] args) {
		// System.out.println(new Solution().myAtoi(" +0-00100"));
		System.out.println(new Solution().myAtoi("2147483648"));
		// System.out.println(Integer.MAX_VALUE);
		// System.out.println(Integer.MAX_VALUE + 1);
		// System.out.println(Integer.MIN_VALUE);
		// System.out.println(Integer.MIN_VALUE - 1);
	}

	public int myAtoi(String str) {
		char[] chs = str.trim().toCharArray();
		boolean minus = false;
		boolean symbolFlag = false;
		int result = 0;
		for (char c : chs) {
			if (c == '-' || c == '+') {
				if (symbolFlag) {
					break;
				}
				symbolFlag = true;
				if (c == '-') {
					minus = true;
				}
				continue;
			}
			if (c < '0' || c > '9') {
				break;
			}
			if (Integer.MAX_VALUE / 10 < result
					|| Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < c - '0') {
				return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			result = result * 10 + c - '0';
		}
		return minus ? 0 - result : result;
	}
}
