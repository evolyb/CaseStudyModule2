package model;

import java.time.LocalDate;

public class Match implements Comparable<Match>{
    int Id;
    LocalDate date;
    Team[] teams;
    int[] score;
    String stadium;

    public Match(int id, Team[] teams, int[] score, String stadium,LocalDate date) {
        Id = id;
        this.stadium = stadium;
        this.date = date;
        this.teams = teams;
        this.score = score;
    }

    public String getStadium() {
        return stadium;
    }

    public int getId() {
        return Id;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }
    public Team getWinner(){
        if (score[0] > score[1]) return teams[0];
        else if (score[0] < score[1]) return teams[1];
        else return null;
    }
    public boolean isParticipate(Team team){
        return team.getId() == teams[0].getId() || team.getId() == teams[1].getId();
    }

    @Override
    public String toString() {
        return "Match: "+teams[0].getName()+" "+score[0] +" - "+score[1]+" " +teams[1].getName()+
                "\nId: " + Id +
                "\nDate: " + date +
                "\nStadium: " + stadium;
    }
    public void showOverall(){
        System.out.printf("%-11s %-10s %s - %-5s %-10s\n",date,teams[0].getName(),score[0],score[1], teams[1].getName());
    }

    @Override
    public int compareTo(Match o) {
        return date.compareTo(o.date);
    }
}
