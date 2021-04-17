import java.util.*;

public class Solution {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        
        List<Boolean> extraCandy = new ArrayList<>();
        for (int j = 0; j < candies.length; j++) {
            int sum = extraCandies + candies[j];
            if (sum >= max) {
                extraCandy.add(true);
            } else {
                extraCandy.add(false);
            }
        }
        return extraCandy;
    }
    
    public static void main(String[] args) {
        int[] candy = new int[] {2, 3, 5, 1, 3};
        List<Boolean> lis = Solution.kidsWithCandies(candy, 3);
        
        for (int y = 0; y < candy.length; y++) {
            System.out.println(lis.get(y));
        }
    }
}
