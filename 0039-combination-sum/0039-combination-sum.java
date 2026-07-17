import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int index,
                           List<Integer> current, List<List<Integer>> result) {

        // If target becomes 0, store the combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try all candidates starting from current index
        for (int i = index; i < candidates.length; i++) {

            // Skip if current number is greater than target
            if (candidates[i] > target)
                continue;

            current.add(candidates[i]);

            // Reuse the same element by passing i
            backtrack(candidates, target - candidates[i], i, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}