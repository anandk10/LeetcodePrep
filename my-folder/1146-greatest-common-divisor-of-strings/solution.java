class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 == len2) {
            if (str1.equals(str2)) {
                return str1;
            } else {
                return "";
            }
        
        }


        int len = Math.min(len1, len2);

        for (; len > 0; len--) {
            if (isDivisor(len, str1, str2)) {
                return str1.substring(0, len);
            }
        }
        return "";


    }

    private boolean isDivisor(int len, String str1, String str2) {
        if (str1.length() % len != 0 || str2.length() % len != 0) {
            return false;
        }

        String genStr = str1.substring(0,len);
        int divisor = str1.length() / len;
        String newStr1 = Stream.generate(() -> genStr)
              .limit(divisor)
              .collect(Collectors.joining());
        System.out.println("Generated string1 " + newStr1);
        divisor = str2.length() / len;
        String newStr2 = Stream.generate(() -> genStr)
              .limit(divisor)
              .collect(Collectors.joining());
        System.out.println("Generated string2 " + newStr2);

        return newStr1.equals(str1) && newStr2.equals(str2);

    }
}
