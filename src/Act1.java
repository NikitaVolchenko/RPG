public class Act1 extends Act {
    @Override
    public Character makeMonster() {
        Four[] clothes = new Four[4];
        clothes[0] = new Four("helmet", 0, 5, false);
        clothes[1] = new Four("shoes", 0, 5, false);
        clothes[2] = new Four("pants", 0, 5, false);
        clothes[3] = new Four("chain mail", 0, 10, false);

        Four[] skills = new Four[4];
        skills[0] = new Four("hit", 10, 0, true);
        skills[1] = new Four("hard blow", 15, 0, true);
        skills[2] = new Four("protection", 0, 1, true);
        skills[3] = new Four("healing", 0, 0, true);

        return new Character("Monster1", clothes, skills, 60, 0);
    }
}
