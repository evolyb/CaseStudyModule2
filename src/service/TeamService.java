package service;

import model.LeagueManagement;
import model.Player;
import model.Team;
import view.TeamView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamService implements IService{
    Scanner scanner = new Scanner(System.in);
    @Override
    public void doAction(String action) {
        switch (action){
            case "Show All Teams" -> showAllTeam();
            case "Search By Id" ->searchTeamById();
            case "Search By Name"-> searchTeamByName();
            case "Add Team" ->addTeam();
            case "Edit Team"->editTeam();
            case "Remove Team"->removeTeam();
            default -> {
                System.out.println("Dont have this action");
            }
        }
    }
    public void showAllTeam(){
        TeamView.showListTeams(LeagueManagement.listTeam);
    }
    public void searchTeamById(){
        System.out.println("Input id you want to search");
        int identity = Integer.parseInt(scanner.nextLine());
        Team team = getTeamById(identity);
        TeamView.showTeam(team);
    }
    public void searchTeamByName(){
        System.out.println("Input name you want to search");
        String name = scanner.nextLine();
        List<Team> listTeam = getPlayerByName(name);
        TeamView.showListTeamDetail(listTeam);
    }
    public void addTeam(){
        Team team = TeamView.showAddForm();
        LeagueManagement.listTeam.add(team);
        System.out.println("Team "+team.getName()+" is saved");
    }
    public void editTeam(){
        Team team = TeamView.showEditForm();
        Team oldTeam = getTeamById(team.getId());
        if (!team.getName().equals("")) oldTeam.setName(team.getName());
        if (!team.getProvince().equals("")) oldTeam.setProvince(team.getProvince());
        if (!team.getCoach().equals("")) oldTeam.setCoach(team.getCoach());
        System.out.println("Team "+oldTeam.getName()+" is saved");
    }
    public void removeTeam(){
        int id = TeamView.selectTeamForm(false);
        if (id == -1) return;
        Team team = TeamService.getTeamById(id);
        List<Player> myList = PlayerService.getAllPlayerByTeam(id);
        for (Player player: myList){
            player.setTeamId(0);
        }
        System.out.println("Team "+team.getName()+ " is removed");
    }
    public static Team getTeamById(int id){
        for (Team team: LeagueManagement.listTeam){
            if (team.getId() == id){
                return team;
            }
        }
        return null;
    }
    public static List<Team> getPlayerByName(String name){
        List<Team> myList = new ArrayList<>();
        for (Team team: LeagueManagement.listTeam){
            if (team.getName().toUpperCase().contains(name.toUpperCase())){
                myList.add(team);
            }
        }
        return myList;
    }
}
