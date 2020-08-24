package model;

import service.MatchService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LeagueManagement {
    public static String[] position = {"Goalkeeper","Defenders","Midfield","Striker"};
    public static List<Player> listPlayer = new ArrayList<>();
    public static List<Team> listTeam = new ArrayList<>();
    public static List<Match> listMatch = new ArrayList<>();
    static {
        Player player = new Player("163","Kaka","VietNam",LocalDate.of(1992,12,24),1.65,50.0,"Striker",0);
        Player player1 = new Player("100","Ronaldo","Brazil",LocalDate.of(1995,11,1),1.75,100.0,"Striker",1);
        Player player2 = new Player("115","Carlos","England",LocalDate.of(1990,12,12),1.5,65.0,"Goalkeeper",2);
        Player player3 = new Player("105","Sergio Thiago","England",LocalDate.of(1985,6,10),1.8,95.0,"Midfield",1);
        Player player4 = new Player("111","Lionel Messi","Argentina",LocalDate.of(1980,4,15),1.7,70.0,"Midfield",2);
        Player player5 = new Player("101","Paul Pogba","France",LocalDate.of(1982,1,1),1.81,85.0,"Defenders",3);
        listPlayer.add(player);
        listPlayer.add(player1);
        listPlayer.add(player2);
        listPlayer.add(player3);
        listPlayer.add(player4);
        listPlayer.add(player5);

        Team team0 = new Team(0,"Free Transfer","","","");
        Team team1 = new Team(1,"Chelsea","HaNoi","SonMC","Stamford Bridge");
        Team team2 = new Team(2,"Barca","NamDinh","Kaka","Camp Nou");
        Team team3 = new Team(3,"MU","EngLand","ChauLe","Old Trafford");
        Team team4 = new Team(4,"Arsenal","EngLand","Luis","Emirates");
        Team team5 = new Team(5,"Tottenham","EngLand","Luis","Tottenham Hotspur");
        Team team6 = new Team(6,"Thể Công","Việt Nam","Katana","Thể Công");
        Team team7 = new Team(7,"Hà Nội","Hà Nội","Carlos","Hà Nội");
        listTeam.add(team0);
        listTeam.add(team1);
        listTeam.add(team2);
        listTeam.add(team3);
        listTeam.add(team4);
        listTeam.add(team5);
        listTeam.add(team6);
        listTeam.add(team7);
        randomData();

    }
    public static void randomData(){
        List<Team> teamList = new ArrayList<>(listTeam);
        teamList.remove(0);
        int id = 0;
        LocalDate startDate = LocalDate.of(2020,1,1);
        List<LocalDate> listDate = new ArrayList<>();
        listDate.add(startDate);
        int round = 0;
        if (teamList.size()%2 == 0) round = teamList.size()-1;
        else round = teamList.size();
        for (int i = 1; i <round ; i++) {
            startDate = startDate.plusDays(7);
            listDate.add(startDate);
        }

        for (int i = 0; i < teamList.size()-1; i++) {
            int count = 2*i;
            while (count>round-1) count = count -round;
            count--;
            for (int j = i+1; j <teamList.size() ; j++) {
                id++;
                Team[] teams = new Team[2];
                teams[0] = teamList.get(i);
                teams[1] = teamList.get(j);
                LocalDate dateMatch;
                boolean isInValid;
                do{
                    isInValid = false;
                    count ++;
                    if (count > round-1) count = 0;
                    dateMatch = listDate.get(count);
                    List<Match> matchList = MatchService.getAllMatchInADay(dateMatch);
                    for (Match match: matchList){
                        if (match.isParticipate(teams[0]) || match.isParticipate(teams[1])) isInValid=true;
                    }
                } while (isInValid);
                int[] score = new int[2];
                score[0] = (int) (Math.random() * 5);
                score[1] = (int) (Math.random() * 5);
                String stadium = teams[0].getStadium();
                Match match = new Match(id,teams,score,stadium,dateMatch);
                listMatch.add(match);
            }
        }
        Collections.sort(listMatch);
    }
}
