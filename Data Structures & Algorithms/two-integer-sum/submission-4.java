class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];

            if (hashmap.containsKey(value)) {
                return new int[] {hashmap.get(value),i};
            }

            hashmap.put(nums[i], i);
        }
        return new int[] {};
    }
}