import java.util.Arrays;

public class Monster {
    private String name;
    private Four[] clothes;
    private Four[] skills;
    private int health;
    private int protection;

    public Monster(String name, Four[] clothes, Four[] skills, int health, int protection) {
        this.health = health;
        this.clothes = clothes;
        this.skills = skills;
        this.name = name;
        this.protection = protection;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Four[] getClothes() {
        return clothes;
    }

    public void setClothes(Four[] clothes) {
        this.clothes = clothes;
    }

    public Four[] getSkills() {
        return skills;
    }

    public void setSkills(Four[] skills) {
        this.skills = skills;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public void characterAttack(int value) {
        health = health - value;
    }

    public void addProtection(int value) {
        protection = protection + value;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", clothes=" + Arrays.toString(clothes) +
                ", skills=" + Arrays.toString(skills) +
                ", health=" + health +
                ", protection=" + protection +
                '}';
    }
}
