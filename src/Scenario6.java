import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scenario6 {
    public void findPlayerOfMacthSeason(List<MatchData> matches) {
        Map<String, HashMap<String,Integer>> result=new HashMap<>();
        for(MatchData match:matches){
            result.putIfAbsent(match.getSeason(),new HashMap<>());
            HashMap<String,Integer> data=result.get(match.getSeason());
            data.put(match.getPlayerOfMatch(),data.getOrDefault(match.getPlayerOfMatch(),0)+1);
            result.put(match.getSeason(),data);
        }
        for(Map.Entry<String,HashMap<String,Integer>> res:result.entrySet()) {
            System.out.println(res.getKey()+":");
            for(Map.Entry<String,Integer> b:res.getValue().entrySet()){
                System.out.println(b.getKey()+"="+b.getValue());
            }
        }
    }
}
