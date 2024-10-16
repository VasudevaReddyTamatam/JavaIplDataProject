import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class JavaIplProject {
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
    private static final int UMPIRE1 = 15;
    private static final int UMPIRE2 = 16;
    private static final int UMPIRE3 = 17;

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

    private static List<MatchData> getMatchData() {
        List<MatchData> matches = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader("/home/vasudeva/IdeaProjects/" +
                "JavaIplDataProject/matches.csv"))) {
            String firstLine = buffer.readLine();
            ArrayList<String> firstLineArray = new ArrayList<>(Arrays.asList(firstLine.split(",")));
            String line;
            while ((line = buffer.readLine()) != null) {
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
        } catch (IOException e) {
            System.out.println("Error occurred while loading matches file ");
        }
        return matches;
    }

    private static List<DeliveryData> getDeliveryData() {
        List<DeliveryData> deliveries = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader("/home/vasudeva/IdeaProjects/" +
                "JavaIplDataProject/deliveries.csv"))) {
            String firstLine = buffer.readLine();
            ArrayList<String> firstLineArray = new ArrayList<>(Arrays.asList(firstLine.split(",")));
            String line;
            while ((line = buffer.readLine()) != null) {
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
        } catch (IOException e) {
            System.out.println("Error occurred while loading deliveries data");
        }
        return deliveries;
    }

    public static void main(String[] args) {
        List<MatchData> matchData = getMatchData();
        List<DeliveryData> deliveryData = getDeliveryData();

        findNumberOfMatchesPlayedPerYear(matchData);
        findNumberOfMatchesWonEachTeamsAllYears(matchData);
        findExtraRunsConcededPerTeam(matchData, deliveryData);
        findTopEconomicBowlers(matchData, deliveryData);
        findTeamsWonBothTossAndMatch2016(matchData);
        findOrangeCap2016(matchData, deliveryData);
    }

    private static void findNumberOfMatchesPlayedPerYear(List<MatchData> matches) {
        Map<String, Integer> numberOfMatchesPlayedPerYear = new HashMap<>();
        for (MatchData match : matches) {
            if (numberOfMatchesPlayedPerYear.containsKey(match.getSeason())) {
                numberOfMatchesPlayedPerYear.put(match.getSeason(),
                        numberOfMatchesPlayedPerYear.get(match.getSeason()) + 1);
            } else {
                numberOfMatchesPlayedPerYear.put(match.getSeason(), 1);
            }
        }
        for (Map.Entry<String, Integer> mapEntry : numberOfMatchesPlayedPerYear.entrySet()) {
            System.out.println("In Year " + mapEntry.getKey() + ", " + mapEntry.getValue() + " matches happened.");
        }
    }

    private static void findNumberOfMatchesWonEachTeamsAllYears(List<MatchData> matches) {
        Map<String, Integer> numberOfMatchesWonEachTeam = new HashMap<>();
        for (MatchData match : matches) {
            if (match.getWinner() == null || match.getWinner().trim().isEmpty()) {
                continue;
            }
            if (numberOfMatchesWonEachTeam.containsKey(match.getWinner())) {
                numberOfMatchesWonEachTeam.put(match.getWinner(), (numberOfMatchesWonEachTeam.get(match.getWinner())
                        + 1));
            } else {
                numberOfMatchesWonEachTeam.put(match.getWinner(), 1);
            }
        }
        System.out.println("-------------------------------------------------------------");
        for (Map.Entry<String, Integer> mapEntry : numberOfMatchesWonEachTeam.entrySet()) {
            System.out.println("Team " + mapEntry.getKey() + " won " + mapEntry.getValue() + " matches.");
        }
    }

    private static void findExtraRunsConcededPerTeam(List<MatchData> matches, List<DeliveryData> deliveries) {
        Map<String, Integer> extraRunsConcededPerTeam = new HashMap<>();
        ArrayList<String> matchIds2016 = new ArrayList<>();
        for (MatchData match : matches) {
            if ((match.getSeason()).equals("2016")) {
                matchIds2016.add(match.getId());
            }
        }
        for (DeliveryData delivery : deliveries) {
            if (matchIds2016.contains(delivery.getMatchId())) {
                int extraRuns = Integer.parseInt(delivery.getExtraRuns());
                if (extraRunsConcededPerTeam.containsKey(delivery.getBowlingTeam())) {
                    extraRunsConcededPerTeam.replace(delivery.getBowlingTeam(),
                            extraRunsConcededPerTeam.get(delivery.getBowlingTeam()) + extraRuns);
                } else {
                    extraRunsConcededPerTeam.put(delivery.getBowlingTeam(), extraRuns);
                }
            }
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println(extraRunsConcededPerTeam);
    }

    private static void findTopEconomicBowlers(List<MatchData> matches, List<DeliveryData> deliveries) {
        ArrayList<String> matchIds2015 = new ArrayList<>();
        for (MatchData match : matches) {
            if ((match.getSeason()).equals("2015")) {
                matchIds2015.add(match.getId());
            }
        }
        HashMap<String, HashMap<String, Integer>> bowlerBallsRuns = new HashMap<>();
        for (DeliveryData delivery : deliveries) {
            if (matchIds2015.contains(delivery.getMatchId())) {
                bowlerBallsRuns.putIfAbsent(delivery.getBowler(), new HashMap<>());
                HashMap<String, Integer> runsBalls = bowlerBallsRuns.get(delivery.getBowler());
                runsBalls.put("runs", runsBalls.getOrDefault("runs", 0)
                        + Integer.parseInt(delivery.getTotalRuns()));
                runsBalls.put("balls", runsBalls.getOrDefault("balls", 0) + 1);
                bowlerBallsRuns.put(delivery.getBowler(), runsBalls);
            }
        }
        Map<String, Double> economyRate = new HashMap<>();
        for (Map.Entry<String, HashMap<String, Integer>> b : bowlerBallsRuns.entrySet()) {
            String bowlerName = b.getKey();
            double runs = (double) b.getValue().get("runs");
            double balls = (double) b.getValue().get("balls");
            double economy = runs / (balls / 6.0);
            economyRate.put(bowlerName, economy);
        }
        Set<Map.Entry<String, Double>> economyRateSet = economyRate.entrySet();
        List<Map.Entry<String, Double>> topEconomyBowlers = new ArrayList<>(economyRateSet);
        Collections.sort(topEconomyBowlers, (val1, val2) -> val1.getValue().compareTo(val2.getValue()));
        System.out.println("-------------------------------------------------------------");
        System.out.println(topEconomyBowlers);
    }

    private static void findTeamsWonBothTossAndMatch2016(List<MatchData> matches) {
        Map<String, Integer> teamsWonBothTossAndMatch = new HashMap<>();
        for (MatchData match : matches) {
            if (match.getTossWinner().equals(match.getWinner()) && match.getSeason().equals("2016")) {
                teamsWonBothTossAndMatch.put(match.getWinner(),
                        teamsWonBothTossAndMatch.getOrDefault(match.getWinner(), 0) + 1);
            }
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println(teamsWonBothTossAndMatch);
    }

    private static void findOrangeCap2016(List<MatchData> matches, List<DeliveryData> deliveries) {
        List<String> matchIds2016 = new ArrayList<>();
        for (MatchData match : matches) {
            if (match.getSeason().equals("2016")) {
                matchIds2016.add(match.getId());
            }
        }
        Map<String, Integer> batsManRuns = new HashMap<>();
        for (DeliveryData delivery : deliveries) {
            if (matchIds2016.contains(delivery.getMatchId())) {
                batsManRuns.put(delivery.getBatsman(), batsManRuns.getOrDefault(delivery.getBatsman(), 0)
                        + Integer.parseInt(delivery.getTotalRuns()));
            }
        }
        Set<Map.Entry<String, Integer>> batsManRunsSet = batsManRuns.entrySet();
        List<Map.Entry<String, Integer>> orangeCap = new ArrayList<>(batsManRunsSet);
        Collections.sort(orangeCap, (val1, val2) -> val2.getValue().compareTo(val1.getValue()));
        System.out.println("--------------------------------------------------------------");
        System.out.println(orangeCap.get(0));
    }
}
