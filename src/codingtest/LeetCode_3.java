package codingtest;

// Longest Substring Without Repeating Characters: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LeetCode_3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            String current = s.charAt(i) + "";
            if (!temp.contains(current)) {
                temp += current;
            } else {
                max = Math.max(max, temp.length());
                int index = temp.indexOf(current);
                temp = temp.substring(index + 1, temp.length()) + current;
            }
        }
        max = Math.max(max, temp.length());
        return max;
    }
}
