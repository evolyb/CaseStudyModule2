package view;

import model.LeagueManagement;
import model.Player;
import service.PlayerService;
import service.TeamService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PlayerView {
    private static final Scanner scanner = new Scanner(System.in);
    public static Player showAddForm(){
        String identity;
        do{
            System.out.print("Player Identity: ");
            identity = scanner.nextLine();
            if (PlayerService.getPlayerById(identity) != null) {
                System.out.println("This identity is already existed");
            } else if (identity.equals("")) {
                System.out.println("Identity is not null");
            } else break;
        } while (true);
        String name;
        do{
            System.out.print("Name: ");
            name = scanner.nextLine();
            if (name.equals("")) System.out.println("Name is not Null");
            else break;
        } while (true);
        String nation;
        do{
            System.out.print("Nation: ");
            nation = scanner.nextLine();
            if (nation.equals("")) System.out.println("Nation is not Null");
            else break;
        } while (true);
        LocalDate birthday;
        do{
            System.out.print("Birthday (dd/mm/yyyy): ");
            String birthdayString = scanner.nextLine();
            try {
                String[] birthdayArrString = birthdayString.split("/");
                int[] birthdayArr = new int[3];
                for (int i = 0; i <birthdayArrString.length; i++) {
                    birthdayArr[i] = Integer.parseInt(birthdayArrString[i]);
                }
                birthday = LocalDate.of(birthdayArr[2], birthdayArr[1], birthdayArr[0]);
                break;
            } catch (Exception e){
                System.out.println("Invalid input for date");
            }
        } while (true);
        double height;
        do{
            System.out.print("Height (m): ");
            try{
                height = Double.parseDouble(scanner.nextLine());
                if (height>0 && height<=3) break;
            } catch (Exception ignored){}
            System.out.println("Invalid input for height.");
        } while (true);
        double weight;
        do{
            System.out.print("Weight (kg): ");
            try{
                weight = Double.parseDouble(scanner.nextLine());
                if (weight>0 && weight<=200) break;
            } catch (Exception ignored){}
            System.out.println("Invalid input for weight");
        } while (true);
        String position;
        do{
            System.out.println("Position Lists: ");
            int count =0;
            for(String str : LeagueManagement.position){
                count++;
                System.out.println(count+"."+str);
            }
            System.out.print("Position: ");
            int choice;
            try{
                choice = Integer.parseInt(scanner.nextLine());
                position = LeagueManagement.position[choice-1];
                break;
            } catch (Exception e){
                System.out.println("Invalid input");
            }
        } while (true);
        int teamId;
        do{
            System.out.println("List of Teams");
            TeamView.showListTeams(LeagueManagement.listTeam);
            System.out.println("Player for (Id): ");
            try{
                teamId = Integer.parseInt(scanner.nextLine());
                if (TeamService.getTeamById(teamId) == null){
                    System.out.println("This id is not exist");
                } else break;
            }catch (Exception e){
                System.out.println("Invalid Input");
            }
        } while (true);
        return new Player(identity,name,nation,birthday,height,weight,position,teamId);
    }
    public static Player showEditForm(){
        String identity;
        Player player;
        do {
            System.out.println("Input identity of player you want to edit");
            identity = scanner.nextLine();
            player = PlayerService.getPlayerById(identity);
            if (identity.equalsIgnoreCase("exit")) return null;
            if (player == null){
                System.out.println("Player is not found. Try again");
                System.out.println("Or input 'exit' if you forget the identity");
                System.out.println();
            } else break;
        } while (true);
        System.out.println("New Info of Player: "+player.getName());
        System.out.println("Blank for old info");
        String newIdentity;
        do {
            System.out.print("Identity card: ");
            newIdentity = scanner.nextLine();
            if (newIdentity.equals("")) break;
            if (PlayerService.getPlayerById(newIdentity) != null){
                System.out.println("This identity is already exist");
            } else break;
        } while (true);
        if (!newIdentity.equals("")) player.setIdentityCard(newIdentity);
        else newIdentity = identity;
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Nation: ");
        String nation = scanner.nextLine();
        LocalDate birthday = null;
        do{
            System.out.print("Birthday (dd/mm/yyyy): ");
            String birthdayString = scanner.nextLine();
            if (birthdayString.equals("")) break;
            try {
                String[] birthdayArrString = birthdayString.split("/");
                int[] birthdayArr = new int[3];
                for (int i = 0; i <birthdayArrString.length; i++) {
                    birthdayArr[i] = Integer.parseInt(birthdayArrString[i]);
                }
                birthday = LocalDate.of(birthdayArr[2], birthdayArr[1], birthdayArr[0]);
                break;
            } catch (Exception e){
                System.out.println("Invalid input for date");
            }
        } while (true);
        double height = -1;
        do{
            System.out.print("Height (m): ");
            String input = scanner.nextLine();
            if (input.equals("")) break;
            try{
                height = Double.parseDouble(input);
                if (height >0 && height<=3) break;
            } catch (Exception ignored){}
            System.out.println("Invalid input for height");
        } while (true);
        double weight =-1;
        do{
            System.out.print("Weight (kg): ");
            String input = scanner.nextLine();
            if (input.equals("")) break;
            try{
                weight = Double.parseDouble(input);
                if (weight>0 && weight<=300) break;
            } catch (Exception ignored){}
            System.out.println("Invalid input for weight");
        } while (true);
        String position = "";
        do{
            int count =0;
            for(String str : LeagueManagement.position){
                count++;
                System.out.println(count+"."+str);
            }
            System.out.print("Position: ");
            String input = scanner.nextLine();
            if (input.equals("")) break;
            int choice;
            try{
                choice = Integer.parseInt(input);
                position = LeagueManagement.position[choice-1];
                break;
            } catch (Exception e){
                System.out.println("Invalid input");
            }
        } while (true);
        int teamId = -1;
        do{
            TeamView.showListTeams(LeagueManagement.listTeam);
            System.out.print("Play for team (TeamId): ");
            String input = scanner.nextLine();
            if (input.equals("")) break;
            try{
                teamId = Integer.parseInt(input);
                if (TeamService.getTeamById(teamId) == null){
                    System.out.println("This id is not exist");
                    System.out.println();
                } else break;
            }catch (Exception e){
                System.out.println("Invalid Input");
            }
        } while (true);
        return new Player(newIdentity,name,nation,birthday,height,weight,position,teamId);
    }
    public static void showListPlayers(List<Player> lists){
        if (lists.size() == 0) {
            System.out.println("Not found");
            return;
        }
        System.out.println("List of Player: ");
        for (Player player: lists){
            System.out.println("Id: "+player.getIdentityCard()+" - "+player.getName()+" - Team: "+player.getTeamName() );
        }
    }
    public static void showListPlayersDetail(List<Player> lists) {
        if (lists.size() == 0) {
            System.out.println("Not found");
            return;
        }
        System.out.println("There are " + lists.size() + " players found");
        for (Player player : lists) {
            System.out.println(player);
            System.out.println();
        }
    }
    public static void showPlayer(Player player){
        if (player == null){
            System.out.println("The player is not found");
        } else {
            System.out.println(player);
        }
    }
    public static String showRemovePlayer(){
        String identity;
        Player player;
        do {
            System.out.println("Input identity of player you want to remove");
            identity = scanner.nextLine();
            player = PlayerService.getPlayerById(identity);
            if (identity.equalsIgnoreCase("exit")) return null;
            if (player == null){
                System.out.println("Player is not found. Try again");
                System.out.println("Or input 'exit' if you forget the identity");
                System.out.println();
            } else break;
        } while (true);
        return identity;
    }
}
