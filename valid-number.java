class Solution {
    public boolean isNumber(String s) {
        int dot = 0;
        int number = 0;
        int e = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number += 1;
            } else if (c == '.') {
                if (i == 0 && (i + 1) < s.length() && s.charAt(i + 1) == 'e' || e > 0) {
                    return false;
                }
                dot += 1;
            } else if ((c == 'e' || c == 'E') && i == (s.length() - 1)) {
                return false;
            } else if ((c == 'e' || c == 'E') && i == 0) {
                return false;
            } else if ((c == 'e' || c == 'E') && (i - 1) >= 0 && (Character.isDigit(s.charAt(i-1)) || s.charAt(i-1) == '.')
                      && (i + 1) < s.length() && (Character.isDigit(s.charAt(i+1)) || s.charAt(i+1) == '-' ||                           s.charAt(i+1) == '+' )) {
                e += 1;
            }else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                return false;
            } else if (c == '+' || c == '-') {
                if (i != 0) {
                    char z = s.charAt(i - 1);
                    if ((z == 'e' || z == 'E') && (i+1) < s.length() && Character.isDigit(s.charAt(i+1))) {
                        number += 1;
                    } else {
                        return false;
                    }
                }
            }
        }
        
        if (dot <= 1 && number >= 1 && e <= 1) {
            return true;
        } else {
            return false;
        }
    }
}
