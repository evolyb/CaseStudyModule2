package service;

import model.LeagueManagement;
import model.Player;
import model.Team;
import view.PlayerView;
import view.TeamView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerService implements IService {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void doAction(String action) {
        switch (action){
            case "Add Player" -> addPlayer();
            case "All Players" -> showAllPlayer();
            case "All Players In League" ->showAllPlayerInLeague();
            case "All Players In A Team" ->showAllPlayerInATeam();
            case "Search By Id" ->searchPlayerById();
            case "Search By Name"->searchPlayerByName();
            case "Edit Player Info" ->editPlayer();
            case "Remove Player"->removePlayer();
            case "The Tallest Player" ->showTheTallestPlayer();
            case "The Youngest Player" ->showTheYoungestPlayer();
            default -> {
                System.out.println("Dont have this action");
            }
        }
    }
    public void addPlayer(){
        Player player = PlayerView.showAddForm();
        LeagueManagement.listPlayer.add(player);
        System.out.println("Player "+player.getName()+" is added");
    }
    public void showAllPlayerInLeague(){
        List<Player> myList = new ArrayList<>();
        for (Player player: LeagueManagement.listPlayer){
            if (player.getTeamId() != 0) myList.add(player);
        }
        PlayerView.showListPlayers(myList);
    }
    public void showAllPlayerInATeam(){
        int id = TeamView.selectTeamForm(true);
        if (id == -1) return;
        List<Player> myList = PlayerService.getAllPlayerByTeam(id);
        PlayerView.showListPlayers(myList);
    }
    public void showAllPlayer(){
        PlayerView.showListPlayers(LeagueManagement.listPlayer);
    }
    public void searchPlayerById(){
        System.out.println("Input identity you want to search");
        String identity = scanner.nextLine();
        Player player = getPlayerById(identity);
        PlayerView.showPlayer(player);
    }
    public void searchPlayerByName(){
        System.out.println("Input name you want to search");
        String name = scanner.nextLine();
        List<Player> listPlayer = getPlayerByName(name);
        PlayerView.showListPlayersDetail(listPlayer);
    }
    public void editPlayer(){
        Player player = PlayerView.showEditForm();
        if (player == null) return;
        Player oldPlayer = getPlayerById(player.getIdentityCard());
        if (!player.getName().equals("")) oldPlayer.setName(player.getName());
        if (!player.getNation().equals("")) oldPlayer.setNation(player.getNation());
        if (player.getBirthDay()!=null) oldPlayer.setBirthDay(player.getBirthDay());
        if (player.getHeight()!=-1) oldPlayer.setHeight(player.getHeight());
        if (player.getWeight()!=-1) oldPlayer.setWeight(player.getWeight());
        if (!player.getPosition().equals("")) oldPlayer.setPosition(player.getPosition());
        if (player.getTeamId()!= -1) oldPlayer.setTeamId(player.getTeamId());
        System.out.println(oldPlayer.getName()+" is saved");
    }
    public void removePlayer(){
        String identity = PlayerView.showRemovePlayer();
        if (identity == null) return;
        Player player = getPlayerById(identity);
        player.setTeamId(0);
    }
    public void showTheTallestPlayer(){
        Player player = getTheTallestPlayer();
        System.out.println("The Tallest Player is: ");
        System.out.println(player);
    }
    public void showTheYoungestPlayer(){
        Player player = getTheYoungestPlayer();
        System.out.println("The Youngest Player is: ");
        System.out.println(player);
    }
    public static List<Player> getAllPlayerByTeam(int id){
        List<Player> myList = new ArrayList<>();
        for (Player player: LeagueManagement.listPlayer){
            if (player.getTeamId() == id) myList.add(player);
        }
        return myList;
    }
    public static Player getPlayerById(String id){
        for (Player player: LeagueManagement.listPlayer){
            if (player.getIdentityCard().equalsIgnoreCase(id)) return player;
        }
        return null;
    }
    public static Player getTheTallestPlayer(){
        int index = 0;
        double max = 0;
        for (int i = 0; i <LeagueManagement.listPlayer.size() ; i++) {
            if (LeagueManagement.listPlayer.get(i).getHeight()>max){
                max = LeagueManagement.listPlayer.get(i).getHeight();
                index = i;
            }
        }
        return LeagueManagement.listPlayer.get(index);
    }
    public static Player getTheYoungestPlayer(){
        int index = 0;
        LocalDate max = LeagueManagement.listPlayer.get(0).getBirthDay();
        for (int i = 0; i <LeagueManagement.listPlayer.size() ; i++) {
            if (LeagueManagement.listPlayer.get(i).getBirthDay().compareTo(max) >0 ){
                max = LeagueManagement.listPlayer.get(i).getBirthDay();
                index = i;
            }
        }
        return LeagueManagement.listPlayer.get(index);
    }
    public static List<Player> getPlayerByName(String name){
        List<Player> myList = new ArrayList<>();
        for (Player player: LeagueManagement.listPlayer){
            if (player.getName().toUpperCase().contains(name.toUpperCase())) myList.add(player);
        }
        return myList;
    }


}
