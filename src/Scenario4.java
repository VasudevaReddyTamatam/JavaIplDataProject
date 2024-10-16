import java.util.*;

//5.For the year 2015 get the top economical bowlers.
public class Scenario4 {
    public List findTopEconomicBowlers(List<MatchData> matches, List<DeliveryData> deliveries) {
        ArrayList<String> matchIds2015=new ArrayList<>();
        for(MatchData match:matches) {
            if((match.getSeason()).equals("2015")) {
                matchIds2015.add(match.getId());
            }
        }
        HashMap<String,HashMap<String,Integer>>  bowlerBallsRuns=new HashMap<>();
        for(DeliveryData delivery:deliveries) {
            if(matchIds2015.contains(delivery.getMatchId())) {
                bowlerBallsRuns.putIfAbsent(delivery.getBowler(),new HashMap<>());
                HashMap<String,Integer> runsBalls=bowlerBallsRuns.get(delivery.getBowler());
                runsBalls.put("runs",runsBalls.getOrDefault("runs",0)+Integer.parseInt(delivery.getTotalRuns()));
                runsBalls.put("balls",runsBalls.getOrDefault("balls",0)+1);
                bowlerBallsRuns.put(delivery.getBowler(),runsBalls);
            }
        }
        Map<String,Double> result=new HashMap<>();
        for(Map.Entry<String,HashMap<String,Integer>> b:bowlerBallsRuns.entrySet()){
            String bowlerName=b.getKey();
            double runs=(double)b.getValue().get("runs");
            double balls=(double)b.getValue().get("balls");
            double economy=runs/(balls/6.0);
            result.put(bowlerName,economy);
        }
        Set<Map.Entry<String, Double>> entrySet = result.entrySet();
        List<Map.Entry<String, Double>> sortedList = new ArrayList<>(entrySet);
        Collections.sort(sortedList,(val1,val2) -> val1.getValue().compareTo(val2.getValue()));
        return sortedList;
    }
}
