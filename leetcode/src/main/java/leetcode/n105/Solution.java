package leetcode.n105;

import leetcode.TreeNode;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int[] preorder = { 1,2,4,7,3,5,6,8};
		int[] inorder = {4,7,2,1,5,3,8,6};
		System.out.println(new Solution().buildTree(preorder, inorder));
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		if (preorder.length == 1) {
			return root;
		}
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (preorder[0] == inorder[i]) {
				index = i;
				break;
			}
		}
		int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, index+1);
		int[] rightPreOrder = Arrays.copyOfRange(preorder, index + 1, preorder.length);
		int[] leftInOrder = Arrays.copyOf(inorder, index);
		int[] rightInOrder = Arrays.copyOfRange(inorder, index+1, inorder.length);
		TreeNode left = buildTree(leftPreOrder, leftInOrder);
		TreeNode right = buildTree(rightPreOrder, rightInOrder);
		root.left = left;
		root.right = right;
		return root;
	}

}
