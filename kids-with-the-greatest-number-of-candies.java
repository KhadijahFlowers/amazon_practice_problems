class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        
        List<Boolean> extraCandy = new Arraylist<>();
        for (int j = 0; j < candies.length; j++) {
            int sum = extraCandies + candies[i];
            if (sum > max) {
                extraCandy.add(true);
            } else {
                extraCandy.add(false);
            }
        }
        return extraCandy;
    }
}
