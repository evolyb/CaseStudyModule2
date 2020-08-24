package controller;

import view.Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable {
    private String name;
    private List<Menu> lists;
    public Menu(String name){
        this.name = name;
        this.lists = new ArrayList<>();
    }
    public boolean show(){
        if (lists.size()==0){
            Main.iService.doAction(name);
            Main.listMenu.remove(Main.listMenu.size()-1);
            return false;
        }
        int count = 0;
        System.out.println(name+":");
        for (Menu menu: lists){
            count++;
            System.out.println(count+". "+menu.name);
        }
        System.out.println("0. Back or Exit");
        return true;
    }
    public void add(Menu menu){
        lists.add(menu);
    }
    public Menu getMenu(int index){
        return lists.get(index);
    }
    public String getName() {
        return name;
    }
}
