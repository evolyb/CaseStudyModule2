package model;

public class Team {
    private int id;
    private String name;
    private String province;
    private String coach;

    public Team(int id, String name, String province, String coach) {
        this.id = id;
        this.name = name;
        this.province = province;
        this.coach = coach;
    }

    public Team(String name, String province, String coach) {
        this.name = name;
        this.province = province;
        this.coach = coach;
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

    @Override
    public String toString() {
        return "Team:  "+name+
                "\nId: " + id +
                "\nProvince: " + province+
                "\nCoach: " + coach;
    }
}
