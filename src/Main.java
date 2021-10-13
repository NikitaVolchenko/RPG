import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
        Acts acts = new Acts();

        while (true) {
            int code = acts.startAct1(character);
            if (code == -1) {
                System.out.println("Вы проиграли. Игра окончена");
                break;
            }
            code = acts.startAct2(character);
            if (code == -1) {
                System.out.println("Вы проиграли. Игра окончена");
                break;
            }
            code = acts.startAct3(character);
            if (code == -1) {
                System.out.println("Вы проиграли. Игра окончена");
                break;
            }
            code = acts.startAct4(character);
            if (code == -1) {
                System.out.println("Вы проиграли. Игра окончена");
                break;
            }
            code = acts.startAct5(character);
            if (code == -1) {
                System.out.println("Вы проиграли. Игра окончена");
                break;
            }
            System.out.println("Игра окончена!");
            break;
        }

    }
}
