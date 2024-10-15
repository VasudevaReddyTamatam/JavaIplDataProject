import java.util.HashMap;
import java.util.List;
import java.util.Map;
//1.Number of matches played per year of all the years in IPL.
public class Scenario1 {
    public Map<String,Integer> findNumberOfMatchesPlayedPerYear(List<MatchData> matches){
        Map<String,Integer> result=new HashMap<>();
        for(MatchData match: matches){
            if(result.containsKey(match.getSeason())){
                result.put(match.getSeason(),result.get(match.getSeason())+1);
            }
            else{
                result.put(match.getSeason(),1);
            }
        }
        return result;
    }
}
