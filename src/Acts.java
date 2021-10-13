import java.util.Random;

import static java.lang.Math.abs;

public class Acts {
    public int startAct1(Character character) {
        System.out.println("========== Акт первый ===========");

        Four[] clothes = new Four[4];
        clothes[0] = new Four("helmet", 0, 5, false);
        clothes[1] = new Four("shoes", 0, 5, false);
        clothes[2] = new Four("pants", 0, 5, false);
        clothes[3] = new Four("chain mail", 0, 10, false);

        Four[] skills = new Four[4];
        skills[0] = new Four("hit", 5, 0, true);
        skills[1] = new Four("hard blow", 15, 0, true);
        skills[2] = new Four("protection", 0, 2, true);
        skills[3] = new Four("healing", 0, 0, true);

        Character monster = new Character("Monster1", clothes, skills, 60, 0);

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
                            if (clothes[i].isAvailability()) {
                                protection += clothes[i].getProtection();
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
                                protection += clothes[i].getProtection();
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

        if (character.getHealth() > 0) {
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
                    //mainCharacter.addProtection(mainCharacter.getClothes()[number2].getProtection());
                    x = number2;
                    flag = false;
                }
            }

            character.setHealth(100);
            character.setProtection(0);
            character.getSkills()[0].addDamage(5);
            character.getSkills()[1].addDamage(5);
            System.out.println("Монстр повержен! Поздравляю!");
            System.out.println("Вы выиграли первый акт. Ваша награда " + character.getClothes()[x].getThing());
            System.out.println("Это +" + character.getClothes()[x].getProtection() + " к вашей защите!");
            return 0;
        }
        return -1;
    }

    public int startAct2(Character character) {
        System.out.println("========== Акт второй ==========");

        Four[] clothes = new Four[4];
        clothes[0] = new Four("helmet", 0, 5, true);
        clothes[1] = new Four("shoes", 0, 5, false);
        clothes[2] = new Four("pants", 0, 5, false);
        clothes[3] = new Four("chain mail", 0, 10, false);

        Four[] skills = new Four[4];
        skills[0] = new Four("hit", 15, 0, true);
        skills[1] = new Four("hard blow", 25, 0, true);
        skills[2] = new Four("protection", 0, 2, true);
        skills[3] = new Four("healing", 0, 0, true);

        Character monster = new Character("Monster2", clothes, skills, 70, 0);

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
                            if (clothes[i].isAvailability()) {
                                protection += clothes[i].getProtection();
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
                                protection += clothes[i].getProtection();
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

        if (character.getHealth() > 0) {
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
                    //mainCharacter.addProtection(mainCharacter.getClothes()[number2].getProtection());
                    x = number2;
                    flag = false;
                }
            }

            character.setHealth(100);
            character.setProtection(0);
            character.getSkills()[0].addDamage(5);
            character.getSkills()[1].addDamage(5);
            System.out.println("Монстр повержен! Поздравляю!");
            System.out.println("Вы выиграли второй акт. Ваша награда " + character.getClothes()[x].getThing());
            System.out.println("Это +" + character.getClothes()[x].getProtection() + " к вашей защите!");
            return 0;
        }
        return -1;
    }

    public int startAct3(Character character) {
        System.out.println("========== Акт третий ==========");

        Four[] clothes = new Four[4];
        clothes[0] = new Four("helmet", 0, 5, true);
        clothes[1] = new Four("shoes", 0, 5, false);
        clothes[2] = new Four("pants", 0, 5, true);
        clothes[3] = new Four("chain mail", 0, 10, false);

        Four[] skills = new Four[4];
        skills[0] = new Four("hit", 35, 0, true);
        skills[1] = new Four("hard blow", 45, 0, true);
        skills[2] = new Four("protection", 0, 2, true);
        skills[3] = new Four("healing", 0, 0, true);

        Character monster = new Character("Monster3", clothes, skills, 80, 0);

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
                            if (clothes[i].isAvailability()) {
                                protection += clothes[i].getProtection();
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
                                protection += clothes[i].getProtection();
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

        if (character.getHealth() > 0) {
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
                    //mainCharacter.addProtection(mainCharacter.getClothes()[number2].getProtection());
                    x = number2;
                    flag = false;
                }
            }

            character.setHealth(100);
            character.setProtection(0);
            character.getSkills()[0].addDamage(5);
            character.getSkills()[1].addDamage(5);
            System.out.println("Монстр повержен! Поздравляю!");
            System.out.println("Вы выиграли третий акт. Ваша награда " + character.getClothes()[x].getThing());
            System.out.println("Это +" + character.getClothes()[x].getProtection() + " к вашей защите!");
            return 0;
        }
        return -1;
    }

    public int startAct4(Character character) {
        System.out.println("========== Акт четвертый ==========");

        Four[] clothes = new Four[4];
        clothes[0] = new Four("helmet", 0, 5, true);
        clothes[1] = new Four("shoes", 0, 5, true);
        clothes[2] = new Four("pants", 0, 5, true);
        clothes[3] = new Four("chain mail", 0, 10, false);

        Four[] skills = new Four[4];
        skills[0] = new Four("hit", 40, 0, true);
        skills[1] = new Four("hard blow", 50, 0, true);
        skills[2] = new Four("protection", 0, 2, true);
        skills[3] = new Four("healing", 0, 0, true);

        Character monster = new Character("Monster4", clothes, skills, 90, 0);

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
                            if (clothes[i].isAvailability()) {
                                protection += clothes[i].getProtection();
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
                                protection += clothes[i].getProtection();
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

        if (character.getHealth() > 0) {
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
                    //mainCharacter.addProtection(mainCharacter.getClothes()[number2].getProtection());
                    x = number2;
                    flag = false;
                }
            }

            character.setHealth(100);
            character.setProtection(0);
            character.getSkills()[0].addDamage(5);
            character.getSkills()[1].addDamage(5);
            System.out.println("Монстр повержен! Поздравляю!");
            System.out.println("Вы выиграли четвертый акт. Ваша награда " + character.getClothes()[x].getThing());
            System.out.println("Это +" + character.getClothes()[x].getProtection() + " к вашей защите!");
            return 0;
        }
        return -1;
    }

    public int startAct5(Character character) {
        System.out.println("========== Акт пятый ==========");

        Four[] clothes = new Four[4];
        clothes[0] = new Four("helmet", 0, 5, true);
        clothes[1] = new Four("shoes", 0, 5, true);
        clothes[2] = new Four("pants", 0, 5, true);
        clothes[3] = new Four("chain mail", 0, 10, true);

        Four[] skills = new Four[4];
        skills[0] = new Four("hit", 40, 0, true);
        skills[1] = new Four("hard blow", 55, 0, true);
        skills[2] = new Four("protection", 0, 2, true);
        skills[3] = new Four("healing", 0, 0, true);

        Character monster = new Character("Monster4", clothes, skills, 90, 0);

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
                            if (clothes[i].isAvailability()) {
                                protection += clothes[i].getProtection();
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
                                protection += clothes[i].getProtection();
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

        if (character.getHealth() > 0) {
            character.setHealth(100);
            character.setProtection(0);
            character.getSkills()[0].addDamage(5);
            character.getSkills()[1].addDamage(5);
            System.out.println("Монстр повержен! Поздравляю!");
            System.out.println("Вы выиграли пятый акт.");
            return 0;
        }
        return -1;
    }
}
