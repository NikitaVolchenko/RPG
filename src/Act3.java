public class Act3 {
    public int startAct(Character character) {
        System.out.println("========== Акт третий ==========");

        Four[] clothes = new Four[4];
        clothes[0] = new Four("helmet", 0, 5, true);
        clothes[1] = new Four("shoes", 0, 5, false);
        clothes[2] = new Four("pants", 0, 5, true);
        clothes[3] = new Four("chain mail", 0, 10, false);

        Four[] skills = new Four[4];
        skills[0] = new Four("hit", 25, 0, true);
        skills[1] = new Four("hard blow", 30, 0, true);
        skills[2] = new Four("protection", 0, 3, true);
        skills[3] = new Four("healing", 0, 0, true);

        Character monster = new Character("Monster3", clothes, skills, 80, 0);

        Battle battle = new Battle();
        battle.startBattle(character, monster);

        Check check = new Check();

        return check.checkWinner(character, 3);
    }
}
