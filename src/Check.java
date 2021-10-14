import java.util.Random;

public class Check {

    public int checkWinner(Character character, int value) {

        if (character.getHealth() > 0 && value < 5) {
            int x = 0;
            boolean flag = true;
            while (flag) {
                int min1 = 0;
                int max1 = 3;
                int diff1 = max1 - min1;
                Random random1 = new Random();
                int number2 = random1.nextInt(diff1 + 1);
                number2 += min1;

                if (!character.getClothes()[number2].isAvailability()) {
                    character.getClothes()[number2].setAvailability(true);
                    x = number2;
                    flag = false;
                }
            }

            character.setHealth(100);
            character.setProtection(0);
            character.getSkills()[0].addDamage(5);
            character.getSkills()[1].addDamage(5);
            character.getSkills()[2].addProtection(2);
            System.out.println("Монстр повержен! Поздравляю!");
            System.out.println("Вы выиграли " + value + "-ый акт. Ваша награда " + character.getClothes()[x].getThing());
            System.out.println("Это +" + character.getClothes()[x].getProtection() + " к вашей защите!");
            return 0;
        } else {
            if (character.getHealth() > 0 && value == 5) {
                character.setHealth(100);
                character.setProtection(0);
                character.getSkills()[0].addDamage(5);
                character.getSkills()[1].addDamage(5);
                character.getSkills()[2].addProtection(2);
                System.out.println("Монстр повержен! Поздравляю!");
                System.out.println("Вы выиграли " + value + "-ый акт.");
                return 0;
            }
        }
        return -1;
    }
}
