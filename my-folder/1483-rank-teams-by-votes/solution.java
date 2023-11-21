class Solution {

    
    public String rankTeams(String[] votes) {
        // votes[0].length = number of votes
        int[][] ranks = new int[26][votes[0].length()];

        // [5][0][0]
        // [0][2][3]
        // [0][3][2]


        for (int i = 0; i < votes.length; i++) {

            for (int j = 0; j < votes[i].length(); j++) {
                char c = votes[i].charAt(j);
                ranks[c - 'A'][j]++;
            }

        }

        Character[] result = new Character[votes[0].length()];

        for (int k = 0; k < votes[0].length(); k++) {
            result[k] = votes[0].charAt(k);
        }

        Arrays.sort(result, 
            (team1, team2) -> {
                // comparing two teams based on their votes at a particular rank 
                // we will need to compare all the ranks
                // ranks are the columns in ranks[][]
                for (int k = 0; k < votes[0].length(); k++) {
                    int team1VotesCount = ranks[team1 - 'A'][k];
                    int team2VotesCount = ranks[team2 - 'A'][k];
                    if (team1VotesCount != team2VotesCount) {
                        // different characters for this position so return the descending order
                        return team2VotesCount - team1VotesCount;
                    }
                }
                // same characters for this position 
                // since after traversing all the position
                // there's no clear choice of team
                // now award the team alphabetically
                return Character.compare(team1, team2);
            }
        );

        // return Arrays.stream(result)
        //     .map(String::valueOf)
        //     .collect(Collectors.joining(""));

        StringBuilder sb = new StringBuilder();
        for (Character c: result) {
            sb.append(c);
        }
        return sb.toString();
        
    }
}
