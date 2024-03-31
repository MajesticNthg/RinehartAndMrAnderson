public class Level1 {
    public static String BigMinus(String s1, String s2) {
        StringBuilder string = new StringBuilder();
        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();


        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i) && i == s1.length() - 1) {
                    string.insert(0, 0);
                    return string.toString();
                } else if (s1.charAt(i) > s2.charAt(i)) {
                    max.insert(0, s1);
                    min.insert(0, s2);
                    break;
                } else if (s1.charAt(i) < s2.charAt(i)) {
                    max.insert(0, s2);
                    min.insert(0, s1);
                    break;
                }
            }
        }
                else if (s1.length() > s2.length()) {
                    max.insert(0, s1);
                    min.insert(0, s2);
                } else {
                    max.insert(0, s2);
                    min.insert(0, s1);
                }


        String s3 = max.toString();
        String s4 = min.toString();

        char[] c1 = s3.toCharArray();
        char[] c2 = s4.toCharArray();


        int x1 = Character.getNumericValue(c1[c1.length - 1]);
        int x2 = Character.getNumericValue((c2[c2.length - 1]));
        for (int i = 1; i <= c2.length; i++) {
            if (x1 < x2) {
                x1 += 10;
                c1[c1.length - i - 1] -= 1;
                i--;
            } else if (i == c2.length)
                string.insert(0, (x1 - x2));
            else {
                string.insert(0, (x1 - x2));
                x1 = Character.getNumericValue(c1[c1.length - (i + 1)]);
                x2 = Character.getNumericValue(c2[c2.length - (i + 1)]);
            }
        }


        if (c1.length > c2.length) {
            String s5 = new String(c1, 0, c1.length - c2.length);
            string.insert(0, s5);
        } else {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '0') {
                    string.delete(i, i + 1);
                    i--;
                } else break;
            }
        }

        return string.toString();
    }
}



