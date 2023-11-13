class Solution {
    public int numUniqueEmails(String[] emails) {
        
//          "test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com"
        
//         testemail@leetcode.com
//         tokenize on last occurring  '@'

//         rules are if . occurs ignore just the .
//         if + occurs then ignore everything after that in the local name
            
//         for domain name that's not true. 
        Set<String> uniqueEmails = new HashSet<>();
        for (String email: emails) {
            // System.out.println(email);
            String[] tokenizedEmail = email.split("@");
            
            String materializedEmail = applyRules(tokenizedEmail[0])
                .append("@")
                .append(tokenizedEmail[1]).toString();
            if(!uniqueEmails.contains(materializedEmail)) {
                uniqueEmails.add(materializedEmail);
            }
        }
        return uniqueEmails.size();
            
    }
    
    private StringBuilder applyRules(String name) {
        StringBuilder localName = new StringBuilder();
        for(int i=0; i<name.length(); i++) {
            if (name.charAt(i) == '+') break;
            if (name.charAt(i) == '.') continue;
            localName.append(name.charAt(i));
        }
        System.out.println(localName);
        return localName;
    }
}