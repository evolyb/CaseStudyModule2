package model;

import service.TeamService;

public class TeamOnRank implements Comparable<TeamOnRank>{
    private int teamId;
    private int win =0;
    private int lose =0;
    private int draw =0;

    public TeamOnRank(int teamId) {
        this.teamId = teamId;
    }
    public void increaseWin(){
        win++;
    }
    public void increaseLose(){
        lose++;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getWin() {
        return win;
    }

    public int getLose() {
        return lose;
    }

    public int getDraw() {
        return draw;
    }

    public void increaseDraw(){
        draw++;
    }
    public String getName(){
        return TeamService.getTeamById(teamId).getName();
    }
    public int getMatch(){
        return win+draw+lose;
    }
    public int getPoint(){
        return win*3+draw*1;
    }

    @Override
    public int compareTo(TeamOnRank o) {
        return o.getPoint() - getPoint();
    }
}
