import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = null;
        if (scanner.hasNextLine()) {
            name = scanner.nextLine();
        }

        System.out.println("Добро пожаловать в игру, " + name + "!");
        MainCharacter mainCharacter = new MainCharacter(name);
        Acts acts = new Acts();
        acts.startAct1(mainCharacter);
        acts.startAct2(mainCharacter);
    }
}
