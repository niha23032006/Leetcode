import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Count frequency of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check elements appearing more than n/3 times
        int limit = nums.length / 3;

        for (int key : map.keySet()) {
            if (map.get(key) > limit) {
                result.add(key);
            }
        }

        return result;
    }
}
