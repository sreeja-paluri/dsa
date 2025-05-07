package problems.linkedLists;

import java.util.*;

public class ArrayProblem {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (map.containsKey(compliment)) {
                return new int[]{map.get(compliment), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public int[] BubbleSort(int[] arr){
        int n = arr.length;
         boolean swapped = false;
         int count = 0;
         for(int i = 0; i < n - 1; i++){
             for ( int j = 0; j < n - i -1; j++){
                 if(arr[j] > arr[j+1]){
                     int temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
                     swapped = true;
                     count++;
                 }
             }
             if(!swapped){
                 break;
             }
         }
return arr;

    }

    public boolean isAnagram (String s, String t){
        if( s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c , map.getOrDefault(c, 0) + 1);
        }
        for(char c : t.toCharArray()){
            if(!map.containsKey(c) || map.get(c) == 0) return false;
            map.put(c, map.getOrDefault(c,0) - 1);
        }
        return true;
    }
    public int findMax(int[] arr){
        if(arr.length == 0) throw new IllegalStateException("empty");
        int max = arr[0];
        for( int n : arr){
            if(n > max ) max = n;
        }
        return max;
    }

    public int maxSubArray(int[] nums){
        int maxSum = nums[0];
        int current = nums[0];
        for(int i = 0; i <  nums.length; i++){
            current = Math.max(nums[i], current + nums[i]);
            maxSum = Math.max(current, maxSum);
        }
        return maxSum;
    }

    public int[] twoSumII(int targrt, int[] nums){
       int right = nums.length -1 ;
       int left =0;
       while ( left < right){
           int sum = nums[left] + nums[right];
           if( sum == targrt) return new int[]{left+1 , right+1};
           if(sum < targrt) left ++;
           else right --;
       }
        return new int[0];
    }

    public void moveZeros(int[] nums){
        int nonZeros = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != 0) nums[nonZeros++] = nums[i];
        }
        while(nonZeros < nums.length) nums[nonZeros++] = 0;
    }

    public int findDuplicates(int[] nums){
        Set<Integer> seen = new HashSet<>();
        for(int num : nums){
            if(!seen.add(num))return num;
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayProblem solver = new ArrayProblem();
        // Test 1
        int[] nums1 = {3,2, 7, 1, 15,6};
        System.out.println(solver.BubbleSort(nums1));
        int target1 = 9;
        System.out.println(Arrays.toString(solver.twoSum(nums1, target1)));
        System.out.println(Arrays.toString(solver.twoSumII(target1, nums1))); // [0, 1]
        // Test 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(solver.twoSum(nums2, target2))); // [1, 2]
        // Test 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println(Arrays.toString(solver.twoSum(nums3, target3)));
        int[] arr = {3, 1, 4, 2};
        System.out.println(solver.findMax(arr));
        System.out.println(solver.isAnagram("anagram", "nagaram")); // true
        System.out.println(solver.isAnagram("rat", "car")); // false
        System.out.println(solver.isAnagram("", ""));
        int[] nums4 = { 0,1,0,2,3,0,4};
        solver.moveZeros(nums4);
        System.out.println(Arrays.toString(nums4));
        System.out.println(solver.findDuplicates(nums4));
    }
}
