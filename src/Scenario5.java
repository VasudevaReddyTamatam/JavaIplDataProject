import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scenario5 {
    public Map findTeamsWonTossAndMatch2016(List<MatchData> matches) {
        Map<String,Integer> result=new HashMap<>();
        for(MatchData match:matches) {
            if(match.getTossWinner().equals(match.getWinner()) && match.getSeason().equals("2016")) {
                result.put(match.getWinner(),result.getOrDefault(match.getWinner(),0)+1);
            }
        }
        return result;
    }
}
