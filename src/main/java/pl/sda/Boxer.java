package pl.sda;

public class Boxer implements IFighter {
    private String name;
    private int hp;

    public Boxer(String name, int hp) {

        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}