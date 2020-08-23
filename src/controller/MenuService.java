package controller;

import service.PlayerService;
import service.TeamService;
import view.Main;
import java.util.Scanner;

public class MenuService {
    private static final Scanner scanner = new Scanner(System.in);
    public static void addMenu(Menu mainMenu){
        Menu byId = new Menu("Search By Id");
        Menu byName = new Menu("Search By Name");
        Menu playerMenu = new Menu("Player Management");
        Menu showPlayerMenu = new Menu("Show All Players");
        showPlayerMenu.add(new Menu("All Players"));
        showPlayerMenu.add(new Menu("All Players In League"));
        showPlayerMenu.add(new Menu("All Players In A Team"));
        playerMenu.add(showPlayerMenu);
        Menu searchPlayer = new Menu("Search Player");
        searchPlayer.add(byId);
        searchPlayer.add(byName);
        searchPlayer.add(new Menu("The Tallest Player"));
        searchPlayer.add(new Menu("The Youngest Player"));
        playerMenu.add(searchPlayer);
        playerMenu.add(new Menu("Add Player"));
        playerMenu.add(new Menu("Edit Player Info"));
        playerMenu.add(new Menu("Remove Player"));

        Menu teamMenu = new Menu("Team Management");
        teamMenu.add(new Menu("Show All Teams"));
        Menu searchTeam = new Menu("Search Team");
        searchTeam.add(byId);
        searchTeam.add(byName);
        teamMenu.add(searchTeam);
        teamMenu.add(new Menu("Add Team"));
        teamMenu.add(new Menu("Edit Team"));
        teamMenu.add(new Menu("Remove Team"));

        Menu leagueMenu = new Menu("LeagueManagement");
        leagueMenu.add(new Menu("Show Fixture"));
        mainMenu.add(playerMenu);
        mainMenu.add(teamMenu);
        mainMenu.add(leagueMenu);
    }
    public static void show(Menu currentMenu){
        if (!currentMenu.show()) return;
        System.out.println();
        System.out.println("Input your selection");
        try {
            int selection = Integer.parseInt(scanner.nextLine());
            if (selection == 0) Main.listMenu.remove(Main.listMenu.size()-1);
            else {
                Main.listMenu.add(currentMenu.getMenu(selection-1));
                if (currentMenu.getName().equals("mainMenu")){
                    switch (selection){
                        case 1-> Main.iService = new PlayerService();
                        case 2-> Main.iService = new TeamService();
                    }
                }
            }
        } catch (Exception e){
            System.out.println("Your selection is not valid. Try again");
        }
    }

}
