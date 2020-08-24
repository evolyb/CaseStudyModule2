package view;

import model.Match;
import model.TeamOnRank;

import java.util.List;

public class MatchView {
    public static void showFixture(List<Match> matchList){
        for (Match match: matchList){
            match.showOverall();
        }
    }
    public static void viewRank(List<TeamOnRank> list){
        int count = 0;
        System.out.printf("%-7s %-10s %-10s %-10s %-10s %-10s %-10s\n","STT","Name","Match","Win","Draw","Lose","Point");
        for (TeamOnRank teamOnRank: list){
            count++;
            System.out.printf("%-7s %-10s %-10s %-10s %-10s %-10s %-10s\n",count,teamOnRank.getName(),
                    teamOnRank.getMatch(),teamOnRank.getWin(),teamOnRank.getDraw(),teamOnRank.getLose(),teamOnRank.getPoint());
        }
    }
}
