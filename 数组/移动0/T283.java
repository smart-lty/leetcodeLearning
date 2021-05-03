package leetcode;

public class T283 {
	public void moveZeroes(int[] nums) {
		int cnt=0;
		int temp;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) cnt++;
			else {
				temp=nums[i];
				nums[i]=nums[i-cnt];
				nums[i-cnt]=temp;
			}
		}
    }
}
