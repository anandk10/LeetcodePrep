import java.io.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // ["eat","tea","tan","ate","nat","bat"]
        // [("aet",0),("aet",1),("ant",2),("aet",3),("ant",4),("abt",5)]
        // [("ant",2),("ant",4)]
        // [("abt",5)]
        // [("aet",0),("aet",1),("aet",3)]

        // <"aet", [0,1,3]>
        // <"abt", [5]>
        // <"ant", [2,4]>

        // Iterate over the strings []
        // for every string
        // convert to array of chars
        // sort that array of chars
        // build a string back
        // put in hashmap of <String, List<String>>
        
        // finally go over the hashmap and retrieve only the values and concat them

        // Solution 1: The above approach
        // Map<String, List<String>> counters = new HashMap<>();
        // for (int i=0; i<strs.length; i++) {
        //     char[] strArr = strs[i].toCharArray();
        //     Arrays.sort(strArr);
        //     String sortedStr = new String(strArr);

        //     List<String> savedList = counters.get(sortedStr);
        //     if (savedList == null || savedList.isEmpty()) {
        //         savedList = new ArrayList<String>();
        //     }
        //     savedList.add(strs[i]);
        //     counters.put(sortedStr, savedList);
        // }


        // Solution 2: Using computeIfAbsent 
        // Map<String, List<String>> counters = new HashMap<>();


        // for (String str : strs) {
        //     char[] strArr = str.toCharArray();
        //     Arrays.sort(strArr);
        //     // String sortedStr = new String(strArr);

        //     // counters.computeIfAbsent(new String(strArr), 
        //     //                     key -> new ArrayList<>())
        //     //                     .add(str);
        //     // String.valueOf() is efficient over new String(strArr) 
        //     // for huge strings and is preferred provided that the character 
        //     // array is valid; which in this case is
        //     counters.computeIfAbsent(String.valueOf(strArr), 
        //                         key -> new ArrayList<>())
        //                         .add(str);
        // }


        // // return counters.values().stream().collect(Collectors.toList());
        // return new ArrayList<>(counters.values());

        // Solution 3: Using stream api with forEach()
        Map<String, List<String>> counters = new HashMap<>();
        Arrays.stream(strs)
            .forEach( str -> {
                        char[] strArr = str.toCharArray();
                        Arrays.sort(strArr);
                        counters.computeIfAbsent(String.valueOf(strArr), 
                                key -> new ArrayList<>())
                                .add(str);
                        }
            );
        PrintStream o = System.out;

        o.println(counters.keySet());
        return new ArrayList<>(counters.values());

        // Solution 4: Slightly slow but more functional style. - Uncomment function returnSortedCharStr
        // Map<String, List<String>> counters = Arrays.stream(strs)
        //                                             .collect(
        //                                                 Collectors.groupingBy(Solution::returnSortedCharStr)
        //                                             );
        // return new ArrayList<>(counters.values());


    }

    public static String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    // Solution 4
    // private static String returnSortedCharStr(final String inputStr) {
    //     char[] inputStrArr = inputStr.toCharArray();
    //     Arrays.sort(inputStrArr);
    //     return String.valueOf(inputStrArr);
    // }
}
