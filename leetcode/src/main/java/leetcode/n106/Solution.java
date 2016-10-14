package leetcode.n106;

public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().convertToTitle(1));
		System.out.println(new Solution().convertToTitle(26));
		System.out.println(new Solution().convertToTitle(27));
		System.out.println(new Solution().convertToTitle(52));
		System.out.println(new Solution().convertToTitle(53));
	}

	public String convertToTitle(int n) {
		if (n < 1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		do {
			int i = n % 26;
			n = n / 26;
			if(i==0){
				n--;
			}
			char c=i==0?'Z':(char)('A'-1+i);
			sb.append(c);
		} while (n != 0);
		return sb.reverse().toString();
	}
}
