class Solution {

    public String encode(List<String> strs) {
        // string contains all list
        StringBuilder sb = new StringBuilder();
        
        for (String str: strs) {
            sb.append(str.length())
                .append('#')
                .append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> strs = new ArrayList<>();
        
        int i = 0;
        while ( i < str.length() ) {
            int index = str.indexOf('#', i); // 1
            int len = Integer.parseInt(str.substring(i, index)); // 5
            i = index + 1; //  i = 2;
            strs.add(str.substring(i, len + i));
            i += len;  // "5#Hello5#World" i = 7
        }
        return strs;
    }
}