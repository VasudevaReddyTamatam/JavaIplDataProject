import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class DataLoader {
    private static final int ID = 0;
    private static final int SEASON = 1;
    private static final int CITY = 2;
    private static final int DATE = 3;
    private static final int TEAM1 = 4;
    private static final int TEAM2 = 5;
    private static final int TOSS_WINNER = 6;
    private static final int TOSS_DECISION = 7;
    private static final int RESULT = 8;
    private static final int DL_APPLIED = 9;
    private static final int WINNER = 10;
    private static final int WIN_BY_RUNS = 11;
    private static final int WIN_BY_WICKETS = 12;
    private static final int PLAYER_OF_MATCH = 13;
    private static final int VENUE = 14;
    private static final int UMPIRE1=15;
    private static final int UMPIRE2=16;
    private static final int UMPIRE3=17;

    private static final int MATCH_ID = 0;
    private static final int INNING = 1;
    private static final int BATTING_TEAM = 2;
    private static final int BOWLING_TEAM = 3;
    private static final int OVER = 4;
    private static final int BALL = 5;
    private static final int BATSMAN = 6;
    private static final int NON_STRIKER = 7;
    private static final int BOWLER = 8;
    private static final int IS_SUPER_OVER = 9;
    private static final int WIDE_RUNS = 10;
    private static final int BYE_RUNS = 11;
    private static final int LEG_BYE_RUNS = 12;
    private static final int NO_BALL_RUNS = 13;
    private static final int PENALTY_RUNS = 14;
    private static final int BATSMAN_RUNS = 15;
    private static final int EXTRA_RUNS = 16;
    private static final int TOTAL_RUNS = 17;
    private static final int PLAYER_DISMISSED = 18;
    private static final int DISMISSAL_KIND = 19;
    private static final int FIELDER = 20;

    public List<MatchData> getMatchData(){
        List<MatchData> matches=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader("/home/vasudeva/IdeaProjects/JavaIplDataProject/matches.csv"))){
            String firstLine=br.readLine();
            ArrayList<String> firstLineArray=new ArrayList<>(Arrays.asList(firstLine.split(",")));
            String line;
            while((line=br.readLine())!=null) {
                ArrayList<String> lineArray = new ArrayList<>(Arrays.asList(line.split(",")));
                while (firstLineArray.size() != lineArray.size()) {
                    lineArray.add("NA");
                }
                MatchData match = new MatchData();
                match.setId(lineArray.get(ID));
                match.setSeason(lineArray.get(SEASON));
                match.setCity(lineArray.get(CITY));
                match.setDate(lineArray.get(DATE));
                match.setTeam1(lineArray.get(TEAM1));
                match.setTeam2(lineArray.get(TEAM2));
                match.setTossWinner(lineArray.get(TOSS_WINNER));
                match.setTossDecision(lineArray.get(TOSS_DECISION));
                match.setResult(lineArray.get(RESULT));
                match.setDlApplied(lineArray.get(DL_APPLIED));
                match.setWinner(lineArray.get(WINNER));
                match.setWinByRuns(lineArray.get(WIN_BY_RUNS));
                match.setWinByWickets(lineArray.get(WIN_BY_WICKETS));
                match.setPlayerOfMatch(lineArray.get(PLAYER_OF_MATCH));
                match.setVenue(lineArray.get(VENUE));
                match.setUmpire1(lineArray.get(UMPIRE1));
                match.setUmpire2(lineArray.get(UMPIRE2));
                match.setUmpire3(lineArray.get(UMPIRE3));
                matches.add(match);
            }
        }
        catch(IOException e){
            System.out.println("Error occurred while loading matches file ");
        }
        return matches;
    }
    public List<DeliveryData> getDeliveryData(){
        List<DeliveryData> deliveries=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader("/home/vasudeva/IdeaProjects/JavaIplDataProject/deliveries.csv"))){
            String firstLine=br.readLine();
            ArrayList<String> firstLineArray=new ArrayList<>(Arrays.asList(firstLine.split(",")));
            String line;
            while((line=br.readLine())!=null) {
                ArrayList<String> lineArray = new ArrayList<>(Arrays.asList(line.split(",")));
                while (firstLineArray.size() != lineArray.size()) {
                    lineArray.add("NA");
                }
                DeliveryData delivery = new DeliveryData();
                delivery.setMatchId(lineArray.get(MATCH_ID));
                delivery.setInning(lineArray.get(INNING));
                delivery.setBattingTeam(lineArray.get(BATTING_TEAM));
                delivery.setBowlingTeam(lineArray.get(BOWLING_TEAM));
                delivery.setOver(lineArray.get(OVER));
                delivery.setBall(lineArray.get(BALL));
                delivery.setBatsman(lineArray.get(BATSMAN));
                delivery.setNonStriker(lineArray.get(NON_STRIKER));
                delivery.setBowler(lineArray.get(BOWLER));
                delivery.setIsSuperOver(lineArray.get(IS_SUPER_OVER));
                delivery.setWideRuns(lineArray.get(WIDE_RUNS));
                delivery.setByeRuns(lineArray.get(BYE_RUNS));
                delivery.setLegByeRuns(lineArray.get(LEG_BYE_RUNS));
                delivery.setNoBallRuns(lineArray.get(NO_BALL_RUNS));
                delivery.setPenaltyRuns(lineArray.get(PENALTY_RUNS));
                delivery.setBatsmanRuns(lineArray.get(BATSMAN_RUNS));
                delivery.setExtraRuns(lineArray.get(EXTRA_RUNS));
                delivery.setTotalRuns(lineArray.get(TOTAL_RUNS));
                delivery.setPlayerDismissed(lineArray.get(PLAYER_DISMISSED));
                delivery.setDismissalKind(lineArray.get(DISMISSAL_KIND));
                delivery.setFielder(lineArray.get(FIELDER));
                deliveries.add(delivery);
            }
        }
        catch(IOException e){
            System.out.println("Error occurred while loading deliveries data");
        }
        return deliveries;
    }
}
public class JavaIplProject {
    public static void main(String[] args) {
        DataLoader dataLoader=new DataLoader();
        List<MatchData> matchData=dataLoader.getMatchData();
        List<DeliveryData> deliveryData=dataLoader.getDeliveryData();
        Scenario1 s1=new Scenario1();
        Map<String,Integer> result1=s1.findNumberOfMatchesPlayedPerYear(matchData);
        for(Map.Entry<String,Integer> m : result1.entrySet()){
            System.out.println("In Year "+m.getKey()+", "+m.getValue()+" matches happened.");
        }
        System.out.println("-------------------------------------------------------------");
        Scenario2 s2=new Scenario2();
        Map<String,Integer> result2=s2.findNumberOfMatchesWonEachTeamsAllYears(matchData);
        for(Map.Entry<String,Integer> m : result2.entrySet()){
            System.out.println("Team "+m.getKey()+" won "+m.getValue()+" matches.");
        }
        System.out.println("-------------------------------------------------------------");
        Scenario3 s3=new Scenario3();
        Map<String,Integer> result3=s3.findExtraRunsConcededPerTeam(matchData,deliveryData);
        for(Map.Entry<String,Integer> m : result3.entrySet()){
            System.out.println(m.getKey()+"  "+m.getValue());
        }
    }
}
