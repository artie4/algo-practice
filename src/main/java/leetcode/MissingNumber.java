package leetcode;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		int[] stats = new int[nums.length + 1];
		for(int num: nums) {
			stats[num]++;
		}
		for(int i = 0; i < stats.length; i++) {
			if (stats[i] == 0) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		var inst = new MissingNumber();
		assert(inst.missingNumber(new int[] {1,2}) == 0);
		assert(inst.missingNumber(new int[] {1,0,4,3}) == 2);
		assert(inst.missingNumber(new int[] {1,0,3}) == 2);
	}
}
