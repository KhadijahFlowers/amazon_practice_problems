class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewels.length(); j++) {
                String check = jewels.substring(j, j+1);
                if (stones.substring(i, i+1).compareTo(check) == 0) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
