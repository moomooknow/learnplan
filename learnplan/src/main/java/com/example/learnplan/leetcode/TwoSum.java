package com.example.learnplan.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode算法题 1
 * @author wangfk
 */
public class TwoSum {
  public static void main(String[] args) {
    int[] nums = {2, 7, 9, 15};
    int target = 9;
    Solution solution = new TwoSum().new Solution();
    int [] res = solution.twoSum(nums,target);
    System.out.println(Arrays.toString(res));
  }

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(16);
        for(int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if(map.containsKey(other)){
                return new int[]{map.get(other),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no ");
    }
}
}
