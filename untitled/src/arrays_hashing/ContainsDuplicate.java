package arrays_hashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean hasDuplicate(int[] nums) {
        if(nums.length == 0) {
            return false;
        }
        Set<Integer> seen = new HashSet<>();
        for (int val: nums) {
            if (seen.contains(val)) {
                return true;
            }
            seen.add(val);
        }
        return false;
    }

}
