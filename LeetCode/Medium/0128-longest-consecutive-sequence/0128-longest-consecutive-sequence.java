class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int longest = 0;
        for (int i : nums) {
            int next = i + 1;
            int count = 1;
            if (!set.contains(i - 1)) {
                while (set.contains(next++)) {
                    count++;
                }
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}