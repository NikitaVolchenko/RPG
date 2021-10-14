import java.util.Random;

import static java.lang.Math.abs;

public class Battle {
    public void startBattle(Character character, Character monster) {
        int min = 0;
        int max = 1;
        int diff = max - min;
        Random random = new Random();
        int number = random.nextInt(diff + 1);
        number += min;

        if (number == 0) {
            System.out.println("Игрок делает ход первым");
        } else {
            System.out.println("Монстр делает ход первым");
        }

        while (character.getHealth() > 0 && monster.getHealth() > 0) {
            System.out.println();
            character.printHealthAndProtection();
            monster.printHealthAndProtection();
            System.out.println();
            switch (number) {
                case 0:                                //ход игрока
                    character.printSkills();
                    Motion motion = new Motion();
                    int number1 = motion.makeMotion();

                    if (character.getSkills()[number1].isAvailability()) {
                        int damage = character.getSkills()[number1].getDamage();
                        int protection = character.getSkills()[number1].getProtection();
                        character.addProtection(protection);

                        protection = 0;
                        for (int i = 0; i < 4; i++) {
                            if (monster.getClothes()[i].isAvailability()) {
                                protection += monster.getClothes()[i].getProtection();
                            }
                        }
                        if (damage != 0) {
                            int attack = monster.getProtection() + protection - damage;
                            if (attack < 0) {
                                monster.characterAttack(abs(attack));
                            }
                        }
                    }

                    if (character.getSkills()[number1].getThing().equals("healing")) {
                        character.addHealth(10);
                    }
                    System.out.println("Герой сделал ход " + character.getSkills()[number1].getThing());
                    break;
                case 1:                                //ход монстра
                    int min1 = 0;
                    int max1 = 3;
                    int diff1 = max1 - min1;
                    Random random1 = new Random();
                    int number2 = random1.nextInt(diff1 + 1);
                    number2 += min1;

                    if (monster.getSkills()[number2].isAvailability()) {
                        int damage = monster.getSkills()[number2].getDamage();
                        int protection = monster.getSkills()[number2].getProtection();
                        monster.addProtection(protection);

                        protection = 0;
                        for (int i = 0; i < 4; i++) {
                            if (character.getClothes()[i].isAvailability()) {
                                protection += character.getClothes()[i].getProtection();
                            }
                        }
                        if (damage != 0) {
                            int attack = character.getProtection() + protection - damage;
                            if (attack < 0) {
                                character.characterAttack(abs(attack));
                            }
                        }
                    }

                    if (monster.getSkills()[number2].getThing().equals("healing")) {
                        monster.addHealth(10);
                    }
                    System.out.println("Монстр сделал ход " + monster.getSkills()[number2].getThing());
                    break;
                default:
                    break;
            }
            if (number == 0) {
                number = 1;
            } else {
                number = 0;
            }
        }
    }
}
