package arrays_hashing;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false; // Early exit if lengths differ
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : countS.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            // Check if the character exists in tFreqCount and has the same frequency
            if (!countT.containsKey(key) || countT.get(key) != value) {
                return false;
            }
        }

        // Does same
        // countS.equals(countT)
        return true;
    }

    /**
     * If two strings are ASCI only, we can use an array of size 26 to count the frequency of each character.
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
