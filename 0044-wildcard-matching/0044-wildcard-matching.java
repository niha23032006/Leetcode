class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int star = -1, match = 0;

        while (i < s.length()) {
            // Characters match or '?'
            if (j < p.length() &&
                (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            }
            // Found '*'
            else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                match = i;
                j++;
            }
            // Backtrack to last '*'
            else if (star != -1) {
                j = star + 1;
                match++;
                i = match;
            }
            // No match
            else {
                return false;
            }
        }

        // Skip remaining '*'
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
    

        return j == p.length();
    }
}