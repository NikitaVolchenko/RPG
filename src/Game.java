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

        while (true) {
            Act1 act1 = new Act1();
            int code = act1.startAct(character);
            if (code == -1) {
                System.out.println("Вы проиграли. Игра окончена");
                break;
            }
            Act2 act2 = new Act2();
            code = act2.startAct(character);
            if (code == -1) {
                System.out.println("Вы проиграли. Игра окончена");
                break;
            }
            Act3 act3 = new Act3();
            code = act3.startAct(character);
            if (code == -1) {
                System.out.println("Вы проиграли. Игра окончена");
                break;
            }
            Act4 act4 = new Act4();
            code = act4.startAct(character);
            if (code == -1) {
                System.out.println("Вы проиграли. Игра окончена");
                break;
            }
            Act5 act5 = new Act5();
            code = act5.startAct(character);
            if (code == -1) {
                System.out.println("Вы проиграли. Игра окончена");
                break;
            }
            System.out.println("Игра окончена!");
            break;
        }
    }
}
