package model;

public class Team {
    private int id;
    private String name;
    private String province;
    private String coach;
    private String stadium;

    public Team(int id, String name, String province, String coach, String stadium) {
        this.id = id;
        this.name = name;
        this.province = province;
        this.coach = coach;
        this.stadium = stadium;
    }



    public Team(String name, String province, String coach, String stadium) {
        this.name = name;
        this.province = province;
        this.coach = coach;
        this.stadium = stadium;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    @Override
    public String toString() {
        return "Team:  "+name+
                "\nId: " + id +
                "\nProvince: " + province+
                "\nCoach: " + coach+
                "\nStadium: " + stadium;
    }
}
