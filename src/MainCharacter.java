import java.util.Arrays;

public class MainCharacter {
    private String name;
    private Four[] clothes;
    private Four[] skills;
    private int health;
    private int protection;

    public MainCharacter(String name) {
        this.name = name;
        health = 100;
        protection = 0;

        clothes = new Four[4];
        clothes[0] = new Four("helmet", 0, 10, false);
        clothes[1] = new Four("shoes", 0, 10, false);
        clothes[2] = new Four("pants", 0, 10, false);
        clothes[3] = new Four("chain mail", 0, 20, false);

        skills = new Four[4];
        skills[0] = new Four("hit", 10, 0, true);
        skills[1] = new Four("hard blow", 30, 0, true);
        skills[2] = new Four("protection", 0, 20, true);
        skills[3] = new Four("healing", 0, 0, true);
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public void monsterAttack(int value) {
        health = health - value;
    }

    public void addProtection(int value) {
        protection = protection + value;
    }

    @Override
    public String toString() {
        return "MainCharacter{" +
                "name='" + name + '\'' +
                ", clothes=" + Arrays.toString(clothes) +
                ", skills=" + Arrays.toString(skills) +
                ", health=" + health +
                ", protection=" + protection +
                '}';
    }
}
