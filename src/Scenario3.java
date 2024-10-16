import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//3.For the year 2016 get the extra runs conceded per team.
public class Scenario3 {
    public Map<String,Integer> findExtraRunsConcededPerTeam(List<MatchData> matches, List<DeliveryData> deliveries) {
        Map<String,Integer> result=new HashMap<>();
        ArrayList<String> matchIds2016=new ArrayList<>();
        for(MatchData match : matches) {
            if((match.getSeason()).equals("2016")) {
                matchIds2016.add(match.getId());
            }
        }
        for(DeliveryData delivery: deliveries) {
            if(matchIds2016.contains(delivery.getMatchId())) {
                int extraRuns=Integer.parseInt(delivery.getExtraRuns());
                if(result.containsKey(delivery.getBowlingTeam())) {
                    result.replace(delivery.getBowlingTeam(),result.get(delivery.getBowlingTeam())+extraRuns);
                }
                else {
                    result.put(delivery.getBowlingTeam(),extraRuns);
                }
            }
        }
        return result;
    }
}
