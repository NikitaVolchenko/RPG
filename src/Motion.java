import java.util.Scanner;

public class Motion {
    public int makeMotion() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число от 0 до 3:  ");
        int num = -1;

        boolean flag = true;
        while (flag) {
            num = in.nextInt();
            if (num > 3 || num < 0) {
                System.out.println("Неккоректное число! Повторите ввод");
                System.out.print("Введите число от 0 до 3:  ");
            } else {
                flag = false;
            }
        }

        in.close();
        return num;
    }
}
