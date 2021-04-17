class Solution {
    public String defangIPaddr(String address) {
        
        String new_string = "";
        for (int i = 0; i < address.length(); i++) {
            String check = address.substring(i, i + 1);
            
            if (check.compareTo(".") == 0) {
                new_string += "[.]";
            } else {
                new_string += check;
            }
        }
        
        return new_string;
    }
}
