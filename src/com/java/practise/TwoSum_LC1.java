import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum_LC1 {
    public int[] twoSum(int []nums, int target){
        int result[] = {-1,-1};
        Set<Integer> hSet = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++){
            hSet.add(nums[i]);
        }
        int diff = 0;
        for(int i=0; i < nums.length; i++){
            if(hSet.contains(nums[i]) && hSet.contains(target - nums[i])){
                result[0] = i;
                diff = target -nums[i];
                break;
            }
        }
        for(int i=0; i < nums.length; i++){
            if(nums[i] == diff)
                result[1] = i;
            break;
        }
    return result;
    }
}
