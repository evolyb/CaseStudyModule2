package service;

import model.LeagueManagement;
import model.Match;
import model.Team;
import model.TeamOnRank;
import view.MatchView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchService implements IService{
    @Override
    public void doAction(String action) {
        switch (action){
            case "Show Fixture" -> showFixture();
            case "Show Rank" -> showRank();
            default -> {
                System.out.println("Dont have this action");
            }
        }
    }
    public void showFixture(){
        MatchView.showFixture(LeagueManagement.listMatch);
    }
    public void showRank(){
        List<TeamOnRank> list = getRank();
        MatchView.viewRank(list);
    }
    public static List<Match> getAllMatchInADay(LocalDate localDate){
        List<Match> myList = new ArrayList<>();
        for (Match match: LeagueManagement.listMatch){
            if (match.getDate().equals(localDate)) myList.add(match);
        }
        return myList;
    }
    public static List<TeamOnRank> getRank(){
        List<TeamOnRank> list = new ArrayList<>();
        for (int i = 1; i <LeagueManagement.listTeam.size() ; i++) {
            Team team = LeagueManagement.listTeam.get(i);
            TeamOnRank teamOnRank = new TeamOnRank(team.getId());
            list.add(teamOnRank);
            for (Match match: LeagueManagement.listMatch){
                if (match.isParticipate(team)){
                    Team winner = match.getWinner();
                    if (winner==null) teamOnRank.increaseDraw();
                    else if (winner.getId()==team.getId()) teamOnRank.increaseWin();
                    else teamOnRank.increaseLose();
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}
