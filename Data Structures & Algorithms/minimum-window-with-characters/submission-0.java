class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> tcount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tcount.merge(ch, 1, Integer::sum);
        }

        Map<Character, Integer> window = new HashMap<>();
        int need = tcount.size();
        int have = 0;

        int left = 0;
        int bestLen = Integer.MAX_VALUE;
        int bestStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.merge(c, 1, Integer::sum);

            if (tcount.containsKey(c) && window.get(c).intValue() == tcount.get(c).intValue()) {
                have++;
            }

            while (have == need) {
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (tcount.containsKey(leftChar) && window.get(leftChar) < tcount.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}