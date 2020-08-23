package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeagueManagement {
    public static String[] position = {"Goalkeeper","Defenders","Midfield","Striker"};
    public static List<Player> listPlayer = new ArrayList<>();
    public static List<Team> listTeam = new ArrayList<>();
    static {
        Player player = new Player("163","Kaka","VietNam",LocalDate.of(1992,12,24),1.65,50.0,"Striker",0);
        Player player1 = new Player("100","Ronaldo","Brazil",LocalDate.of(1995,11,1),1.75,100.0,"Striker",1);
        Player player2 = new Player("115","Carlos","England",LocalDate.of(1990,12,12),1.5,65.0,"Goalkeeper",2);
        Player player3 = new Player("105","Sergio Thiago","England",LocalDate.of(1985,6,10),1.9,95.0,"Midfield",1);
        listPlayer.add(player);
        listPlayer.add(player1);
        listPlayer.add(player2);
        listPlayer.add(player3);
        Team team0 = new Team(0,"Free Transfer","","");
        Team team1 = new Team(1,"Chelsea","HaNoi","SonMC");
        Team team2 = new Team(2,"Barca","NamDinh","Kaka");
        Team team3 = new Team(3,"MU","EngLand","ChauLe");
        listTeam.add(team0);
        listTeam.add(team1);
        listTeam.add(team2);
        listTeam.add(team3);
    }
}
