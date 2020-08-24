package view;

import controller.Menu;
import controller.MenuService;
import service.IService;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static List<Menu> listMenu = new ArrayList<>();
    public static IService iService;
    public static void main(String[] args) {
        Menu mainMenu = new Menu("mainMenu");
        MenuService.addMenu(mainMenu);
        listMenu.add(mainMenu);
        while (listMenu.size()!=0){
            System.out.println();
            MenuService.show(listMenu.get(listMenu.size()-1));
        }
    }
}