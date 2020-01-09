package com.storm.simple;

import java.util.Arrays;

import org.junit.Test;

public class ArrayRelated {
	// 有序数组 找到两数相加等于目标数
	public int[] twoSum3(int[] numbers, int target) {
		// 暴力
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					result[0] = Math.min(i + 1, j + 1);
					result[1] = Math.max(i + 1, j + 1);
				}
			}
		}
		return result;
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}

	// public static void main(String[] args) {
	// int[] nums = { 2, 7, 6, 8 };
	// int target = 15;
	// int[] result = twoSum(nums, target);
	// System.out.println(result.toString());
	// Integer a = 12;
	// System.out.println(a.toString());
	// }

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	public int removeElement(int[] nums, int val) {
		int i = 0, j = 0;
		for (; i < nums.length && j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}

	@Test
	public void testsearchInsert() {
		int[] nums = { 1, 2, 4, 6, 8, 9, 10 };
		System.out.println(searchInsert(nums, 10));
		System.out.println(anotherSearchInsert(nums, 10));
	}

	public int searchInsert(int[] nums, int target) {
		if (target > nums[nums.length - 1]) {
			return nums.length;
		}
		if (target <= nums[0]) {
			return 0;
		}
		int i = 0;
		int j = nums.length;
		return searchInsertCore(nums, target, i, j);
	}

	public int searchInsertCore(int[] nums, int target, int i, int j) {
		int mid = (i + j) / 2;
		// left 和 right 都比较大的时候，left + right 很有可能超过 int类型能表示的最大值 可以改写成
		// int mid =left + (right -left) / 2
		if (nums[mid] == target) {
			return mid;
		}
		if (mid == i) {
			if (nums[mid] < target) {
				return mid + 1;
			} else {
				return mid;
			}
		}
		if (nums[mid] < target) {
			return searchInsertCore(nums, target, mid, j);
		} else {
			return searchInsertCore(nums, target, i, mid);
		}
	}

	public int anotherSearchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		if (nums.length == 0) {
			return 0;
		}
		if (target <= nums[0]) {
			return 0;
		}
		if (target > nums[nums.length - 1]) {
			return nums.length;
		}
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] > target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	/**
	 * 最大和连续子数组
	 */
	public int maxSubArray(int[] nums) {
		int ans = nums[0];
		int sum = 0;
		for (int num : nums) {
			if (sum > 0) {
				sum += num;
			} else {
				sum = num;
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}

	@Test
	public void testMaxSubArray() {
		int[] nums = { -2, 3, -1, 1, -3 };
		maxSubArray(nums);
	}

	public String addBinary(String a, String b) {

		return b;

	}

	public boolean isPalindrome1(int x) {
		long start = System.currentTimeMillis();
		boolean result = true;
		if (x < 0) {
			return false;
		}
		String value = String.valueOf(x);
		char[] array = value.toCharArray();
		for (int i = 0, j = array.length - 1; i < array.length && i < j; i++, j--) {
			if (array[i] != array[j]) {
				result = false;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		return result;
	}

	public boolean isPalindrome(int x) {
		long start = System.currentTimeMillis();
		// 对x只翻转一半与另一半进行比较
		// 处理一半数字的条件：被翻转的数字与翻转后的数字比较 后者大于前者 则已经过半
		// 为什么末尾为 0 就可以直接返回 false
		if (x < 0 || (x % 10 == 0 && x != 0))
			return false;
		int revertedNumber = 0;
		while (x > revertedNumber) {
			revertedNumber = revertedNumber * 10 + x % 10;
			x /= 10;
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		return x == revertedNumber || x == revertedNumber / 10;
	}

	public boolean isPalindrome2(int x) {
		// 边界判断
		if (x < 0)
			return false;
		int div = 1;
		// 找到目标数的位数
		while (x / div >= 10)
			div *= 10;
		while (x > 0) {
			int left = x / div;
			int right = x % 10;
			if (left != right)
				return false;
			x = (x % div) / 10;// 去掉首尾
			div /= 100;
		}
		return true;
	}

	@Test
	public void test() {
		int x = 1234321;
		boolean result = isPalindrome2(x);

		System.out.println(result);
	}

	@Test
	public void merge(int[] nums1, int m, int[] nums2, int n) {
	}

	@Test
	public void climbStairs() {
		// int n = 30;
		// int[] memo = new int[n+1];
		// System.out.println(climb_Stairs(0, n,memo));
	}

	// 记忆递归
	public int climb_Stairs(int i, int n, int[] memo) {
		if (i > n) {
			return 0;
		}
		if (i == n) {
			return 1;
		}
		if (memo[i] > 0) {
			return memo[i];
		}
		memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
		return memo[i];
	}

	// 动态规划
	public int climb_Stairs1(int n) {
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int j = 3; j < dp.length; j++) {
			dp[j] = dp[j - 2] + dp[j - 1];
		}
		return dp[n];

	}

	public int _maxProfit(int[] prices) {
		int money = 0;
		for (int i = 0; i < prices.length; i++) {
			int in = prices[i];
			int t_money = 0;
			for (int j = i + 1; j < prices.length; j++) {
				if (in < prices[j] && (prices[j] - in) > t_money) {
					t_money = prices[j] - in;
				}
			}
			if (t_money > money) {
				money = t_money;
			}
		}
		return money;

	}

	public int maxProfit(int[] prices) {
		int minMoney = Integer.MAX_VALUE;
		int money = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minMoney) {
				minMoney = prices[i];
			}
			if (prices[i] - minMoney > money) {
				money = prices[i] - minMoney;
			}
		}
		return money;

	}

	public int maxProfit_pro(int[] prices) {
		int minMoney = Integer.MAX_VALUE;
		int money = 0;
		int before = 0;
		int after = 0;
		for (int i = 0; i < prices.length; i++) {
			before = prices[i];
			after = prices[i + 1];
			if (after > before) {

			}

		}
		return money;
	}

	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public int trailingZeroes(int n) {
		int ret = calK(n);
		int count = 0;
		while (ret >= 10) {
			if (ret % 10 == 0) {
				count++;
			}
			ret /= 10;
		}
		return count;
	}

	public static int calK(int n) {
		if (n <= 1) {
			return n;
		}
		return n * calK(n - 1);
	}

	public static int[] quick_sort(int[] li, int start, int end) {
		// 如果start和end碰头了，说明要我排的这个子数列就剩下一个数了，就不用排序了
		if (!(start < end)) {
			return null;
		}
		int mid = li[start]; // 拿出第一个数当作基准数mid
		int low = start; // low来标记左侧从基准数始找比mid大的数的位置
		int high = end; // high来标记右侧end向左找比mid小的数的位置

		// 我们要进行循环，只要low和high没有碰头就一直进行,当low和high相等说明碰头了
		while (low < high) {
			// 从high开始向左，找到第一个比mid小或者等于mid的数，标记位置,（如果high的数比mid大，我们就左移high）
			// 并且我们要确定找到之前，如果low和high碰头了，也不找了
			while (low < high && li[high] >= mid) {
				high -= 1;
			}
			// 跳出while后，high所在的下标就是找到的右侧比mid小的数
			// 把找到的数放到左侧的空位 low 标记了这个空位
			li[low] = li[high];
			// 从low开始向右，找到第一个比mid大的数，标记位置,（如果low的数小于等于mid，我们就右移low）
			// 并且我们要确定找到之前，如果low和high碰头了，也不找了
			while (low < high && li[low] <= mid) {
				low += 1;
			}
			// 跳出while循环后low所在的下标就是左侧比mid大的数所在位置
			// 我们把找到的数放在右侧空位上，high标记了这个空位
			li[high] = li[low];
			// 以上我们完成了一次 从右侧找到一个小数移到左侧，从左侧找到一个大数移动到右侧
			// 当这个while跳出来之后相当于low和high碰头了，我们把mid所在位置放在这个空位

			li[low] = mid;
			// 这个时候mid左侧看的数都比mid小，mid右侧的数都比mid大

			// 然后我们对mid左侧所有数进行上述的排序
			quick_sort(li, start, low - 1);
			// 我们mid右侧所有数进行上述排序
			quick_sort(li, low + 1, end);
		}
		return li;
	}

	public static int[] devide_sort(int[] li, int start, int end) {
		int[] tmp = new int[li.length];
		sort(li, start, end, tmp);
		return li;
	}

	private static void sort(int[] li, int start, int end, int[] tmp) {
		if (start < end) {
			int mid = (start + end) / 2;
			devide_sort(li, start, mid);
			devide_sort(li, mid + 1, end);
			merger_list(li, start, mid, end, tmp);
		}
	}

	private static void merger_list(int[] li, int start, int mid, int end, int[] tmp) {
		int i = start;
		int j = mid + 1;// 右边数组起始下标
		int t = 0;

		while (i <= mid && j <= end) {
			if (li[i] <= li[j]) {
				tmp[t++] = li[i++];
			} else {
				tmp[t++] = li[j++];
			}
		}
		while (i <= mid) {
			tmp[t++] = li[i++];
		}
		while (j <= end) {
			tmp[t++] = li[j++];
		}
		t = 0;
		while (start <= end) {
			li[start++] = tmp[t++];
		}
	}


	public static void main(String[] args) {
		int[] li = { 2, 5, 3, 7, 8, 1, 11, 43, 6, 77 };
		li = quick_sort(li, 0, li.length - 1);
		for (int i = 0; i < li.length; i++) {
			System.out.print(li[i] + ",");
		}
		int[] another_li = { 2, 5, 3, 7, 8, 1, 11, 43, 6, 77 };
		li = devide_sort(another_li, 0, another_li.length - 1);
		System.out.println();
		for (int i = 0; i < another_li.length; i++) {
			System.out.print(another_li[i] + ",");
		}
	}
}
