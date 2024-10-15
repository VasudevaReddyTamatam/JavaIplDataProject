import java.util.HashMap;
import java.util.List;
import java.util.Map;
//2.Number of matches won of all teams over all the years of IPL.
public class Scenario2 {
    public Map<String,Integer> findNumberOfMatchesWonEachTeamsAllYears(List<MatchData> matches){
        HashMap<String,Integer> result=new HashMap<>();
        for(MatchData match: matches){
            if(match.getWinner()==null || match.getWinner().trim().isEmpty()){
                continue;
            }
            if(result.containsKey(match.getWinner())){
                result.put(match.getWinner(),(result.get(match.getWinner())+1));
            }
            else{
                result.put(match.getWinner(),1);
            }
        }
        return result;
    }
}
