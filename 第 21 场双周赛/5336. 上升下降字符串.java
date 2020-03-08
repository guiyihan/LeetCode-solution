class Solution {
    public String sortString(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            nums[chars[i] - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); ) {
            for (int j = 0; j < 26; j++) {
                if (nums[j] > 0) {
                    sb.append((char)('a' + j));
                    nums[j] -= 1;
                    i++;
                }
            }
            for (int j = 25; j >= 0 && i < s.length(); j--) {
                if (nums[j] > 0) {
                    sb.append((char)('a' + j));
                    nums[j] -= 1;
                    i++;
                }
            }

        }
        return sb.toString();
    }
}