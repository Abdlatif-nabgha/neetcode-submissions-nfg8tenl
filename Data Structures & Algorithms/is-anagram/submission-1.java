class Solution {
    public String sortString(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public boolean isAnagram(String s, String t) {
        String newS = this.sortString(s);
        String newT = this.sortString(t);
        return newS.equals(newT);
    }
}


