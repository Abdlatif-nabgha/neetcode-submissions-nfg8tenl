class Solution {
   public boolean checkInclusion(String s1, String s2) {
    int n = s1.length(), m = s2.length();
    if (n > m) return false;

    int[] s1Count = new int[26];
    int[] windowCount = new int[26];

    // Build frequency array for s1 and the first window of s2
    for (int i = 0; i < n; i++) {
        s1Count[s1.charAt(i) - 'a']++;
        windowCount[s2.charAt(i) - 'a']++;
    }

    int matches = 0;
    for (int i = 0; i < 26; i++) {
        if (s1Count[i] == windowCount[i]) matches++;
    }

    if (matches == 26) return true;

    // Slide the window across the rest of s2
    for (int i = n; i < m; i++) {
        int inChar = s2.charAt(i) - 'a';
        int outChar = s2.charAt(i - n) - 'a';

        // Add incoming character
        windowCount[inChar]++;
        if (windowCount[inChar] == s1Count[inChar]) {
            matches++;
        } else if (windowCount[inChar] == s1Count[inChar] + 1) {
            matches--;
        }

        // Remove outgoing character
        windowCount[outChar]--;
        if (windowCount[outChar] == s1Count[outChar]) {
            matches++;
        } else if (windowCount[outChar] == s1Count[outChar] - 1) {
            matches--;
        }

        if (matches == 26) return true;
    }

    return false;
}
}
