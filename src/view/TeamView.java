package view;

import model.Team;
import service.TeamService;

import java.util.List;
import java.util.Scanner;

public class TeamView {
    private static final Scanner scanner = new Scanner(System.in);
    public static Team showAddForm(){
        int id;
        do{
            System.out.print("Team Id: ");
            try{
                id = Integer.parseInt(scanner.nextLine());
                if (TeamService.getTeamById(id) != null) {
                    System.out.println("This id is already existed");
                } else break;
            } catch (Exception e){
                System.out.println("Invalid input");
            }
        } while (true);
        String name;
        do{
            System.out.print("Name: ");
            name = scanner.nextLine();
            if (name.equals("")) System.out.println("Name is not Null");
            else break;
        } while (true);
        String province;
        do{
            System.out.print("Province: ");
            province = scanner.nextLine();
            if (province.equals("")) System.out.println("Province is not Null");
            else break;
        } while (true);
        String coach;
        do{
            System.out.print("Coach: ");
            coach = scanner.nextLine();
            if (coach.equals("")) System.out.println("Coach is not Null");
            else break;
        } while (true);
        String stadium;
        do{
            System.out.print("Stadium: ");
            stadium = scanner.nextLine();
            if (stadium.equals("")) System.out.println("Stadium is not Null");
            else break;
        } while (true);
        return new Team(id,name,province,coach,stadium);
    }
    public static Team showEditForm(){
        int id;
        Team team;
        do{
            try {
                System.out.println("Input Team Id you want to edit");
                id = Integer.parseInt(scanner.nextLine());
                team = TeamService.getTeamById(id);
                if (team==null){
                    System.out.println("Team is not found");
                } else {
                    break;
                }
            }catch (Exception e){
                System.out.println("Invalid input");
            }
        } while (true);
        System.out.println("Input new Info for Team: "+team.getName());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Province: ");
        String province = scanner.nextLine();
        System.out.print("Coach: ");
        String coach = scanner.nextLine();
        System.out.print("Stadium: ");
        String stadium = scanner.nextLine();
        return new Team(id,name,province,coach,stadium);
    }
    public static void showListTeams(List<Team> lists){
        if (lists.size() == 0) {
            System.out.println("Not found");
            return;
        }
        System.out.println("List of Team: ");
        for (Team team: lists){
            System.out.println("TeamId: " +team.getId()+" - "+team.getName());
        }
    }
    public static void showListTeamDetail(List<Team> lists) {
        if (lists.size() == 0) {
            System.out.println("Not found");
            return;
        }
        System.out.println("There are " + lists.size() + " teams found");
        for (Team team : lists) {
            System.out.println(team);
            System.out.println();
        }
    }
    public static void showTeam(Team team){
        if (team == null){
            System.out.println("The team is not found");
        } else {
            System.out.println(team);
        }
    }
    public static int selectTeamForm(boolean include0){
        int id;
        Team team;
        do {
            System.out.println("Input id of team");
            try {
                id = Integer.parseInt(scanner.nextLine());
                team = TeamService.getTeamById(id);
                if ((id+"").equalsIgnoreCase("exit")) return -1;
                if (team == null || (id == 0 && !include0)){
                    System.out.println("Team is not found. Try again");
                    System.out.println("Or input 'exit' if you forget the identity");
                    System.out.println();
                } else break;
            }catch (Exception e){
                System.out.println("Invalid input");
            }
        } while (true);
        return id;
    }
}
