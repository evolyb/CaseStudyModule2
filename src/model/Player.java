package model;

import service.TeamService;

import java.time.LocalDate;

public class Player {
    private String identityCard;
    private String name;
    private String nation;
    private LocalDate birthDay;
    private Double height;
    private Double weight;
    private String position;
    private int teamId;

    public Player(){};

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Player(String identityCard, String name, String nation, LocalDate birthDay, Double height, Double weight, String position, int teamId) {
        this.identityCard = identityCard;
        this.name = name;
        this.nation = nation;
        this.birthDay = birthDay;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.teamId = teamId;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String getTeamName(){
        return TeamService.getTeamById(teamId).getName();
    }

    @Override
    public String toString() {
        return "Player - " + name+
                "\nIdentity Card: "+identityCard +
                "\nNation: "+nation+
                "\nBirthDay: "+birthDay+
                "\nHeight: "+height+
                "\nWeight: "+weight+
                "\nPosition: "+position+
                "\nTeam: "+getTeamName();
    }
}
