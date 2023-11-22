class Solution {
    public int numUniqueEmails(String[] emails) {
        /**
        
        email . + @ local name domain name
        local name without .
        local name +  first + .. ignored
        
        
        
        */
        Set<String> distinctEmail = new HashSet<>();
        for (String email : emails) {
            
            // try to operate on local name
            // split by '@'
            
            String localName = email.substring(0, email.indexOf('@'));
            // System.out.print(localName);
            int plusIndex = localName.indexOf('+');
            
            if (plusIndex > 0) {
                localName = localName.substring(0, plusIndex);
            }
            
            localName = localName.replaceAll("\\.", "");
            distinctEmail.add(localName + email.substring(email.indexOf('@')));
            
        }
        // System.out.println(distinctEmail);
        return distinctEmail.size();
    }
}
