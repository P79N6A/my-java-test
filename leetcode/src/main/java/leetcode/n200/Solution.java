package leetcode.n200;

import java.util.Random;

public class Solution {

	public static void main(String[] args) {
		char[][] grid = Utils.generateGrid();
		Utils.printTwoDimensionalArray(grid);
		System.out.println(new Solution().numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		boolean[][] marks = new boolean[grid.length][grid[0].length];
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && !marks[i][j]) {
					marks[i][j] = true;
					count++;
					markNeiborLand(grid, marks, i, j);
				}
			}
		}
		return count;
	}

	public void markNeiborLand(char[][] grid, boolean[][] mark, int x, int y) {
		// 寻找上
		if (x > 0) {
			if (grid[x - 1][y] == '1' && !mark[x - 1][y]) {
				mark[x - 1][y] = true;
				markNeiborLand(grid, mark, x - 1, y);
			}
		}
		// 寻找下
		if (x < grid.length - 1) {
			if (grid[x + 1][y] == '1' && !mark[x + 1][y]) {
				mark[x + 1][y] = true;
				markNeiborLand(grid, mark, x + 1, y);
			}
		}
		// 寻找左
		if (y > 0) {
			if (grid[x][y - 1] == '1' && !mark[x][y - 1]) {
				mark[x][y - 1] = true;
				markNeiborLand(grid, mark, x, y - 1);
			}
		}
		// 寻找右
		if (y < grid[0].length - 1) {
			if (grid[x][y + 1] == '1' && !mark[x][y + 1]) {
				mark[x][y + 1] = true;
				markNeiborLand(grid, mark, x, y + 1);
			}
		}
	}
}

class Utils {

	public static char[][] generateGrid() {
		Random r = new Random();
		int n = r.nextInt(10) + 4;
		int m = r.nextInt(10) + 4;
		char[][] grid = new char[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				grid[i][j] = r.nextDouble() >= 0.5 ? '1' : '0';
			}
		return grid;
	}

	public static void printTwoDimensionalArray(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}
