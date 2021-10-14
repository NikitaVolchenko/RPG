import java.util.Scanner;

public class Game {
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = null;
        if (scanner.hasNextLine()) {
            name = scanner.nextLine();
        }

        Four[] clothes = new Four[4];
        clothes[0] = new Four("helmet", 0, 5, false);
        clothes[1] = new Four("shoes", 0, 5, false);
        clothes[2] = new Four("pants", 0, 5, false);
        clothes[3] = new Four("chain mail", 0, 10, false);

        Four[] skills = new Four[4];
        skills[0] = new Four("hit", 10, 0, true);
        skills[1] = new Four("hard blow", 20, 0, true);
        skills[2] = new Four("protection", 0, 0, true);
        skills[3] = new Four("healing", 0, 0, true);

        System.out.println("Добро пожаловать в игру, " + name + "!");
        Character character = new Character(name, clothes, skills, 100, 0);

        Act[] acts = new Act[5];
        acts[0] = new Act1();
        acts[1] = new Act2();
        acts[2] = new Act3();
        acts[3] = new Act4();
        acts[4] = new Act5();

        for (int i = 0; i < 5; i++) {
            int code = acts[i].startAct(character, i + 1);
            if (code == -1) {
                System.out.println("Вы погибли.");
                break;
            }
        }

        System.out.println("Игра окончена!");
    }
}
