import java.util.*;

public class Scenario7 {
    public void findOrangeCap2016(List<MatchData> matches, List<DeliveryData> deliveries) {
        ArrayList<String> matchIds2016=new ArrayList<>();
        for(MatchData match:matches) {
            if(match.getSeason().equals("2016")) {
                matchIds2016.add(match.getId());
            }
        }
        Map<String,Integer> res=new HashMap<>();
        for(DeliveryData delivery:deliveries) {
            if(matchIds2016.contains(delivery.getMatchId())){
                res.put(delivery.getBatsman(),res.getOrDefault(delivery.getBatsman(),0)+Integer.parseInt(delivery.getTotalRuns()));
            }
        }
        Set<Map.Entry<String,Integer>> set=res.entrySet();
        List<Map.Entry<String,Integer>> list=new ArrayList<>(set);
        Collections.sort(list,(val1,val2) -> val2.getValue().compareTo(val1.getValue()));
        System.out.println(list);
    }
}
