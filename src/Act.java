public abstract class Act {
    public int startAct(Character character, int value) {
        System.out.println("===== Начало нового акта ======");
        System.out.println("Акт № " + value);
        System.out.println();

        Character monster = makeMonster();

        Battle battle = new Battle();
        battle.startBattle(character, monster);

        Check check = new Check();

        return check.checkWinner(character, value);
    }

    public abstract Character makeMonster();
}
