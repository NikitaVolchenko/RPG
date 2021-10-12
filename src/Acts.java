import java.util.Random;

import static java.lang.Math.abs;

public class Acts {
    public void startAct1(MainCharacter mainCharacter) {
        System.out.println("========== Акт первый ===========");

        Four[] clothes = new Four[4];
        clothes[0] = new Four("helmet", 0, 5, false);
        clothes[1] = new Four("shoes", 0, 5, false);
        clothes[2] = new Four("pants", 0, 5, false);
        clothes[3] = new Four("chain mail", 0, 10, false);

        Four[] skills = new Four[4];
        skills[0] = new Four("hit", 5, 0, true);
        skills[1] = new Four("hard blow", 10, 0, true);
        skills[2] = new Four("protection", 0, 2, true);
        skills[3] = new Four("healing", 0, 0, true);

        Monster monster = new Monster("Monster1", clothes, skills, 60, 0);

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

        while (mainCharacter.getHealth() > 0 && monster.getHealth() > 0) {
            mainCharacter.printHealthAndProtection();
            monster.printHealthAndProtection();
            switch (number) {
                case 0:                                //ход игрока
                    mainCharacter.printSkills();
                    Motion motion = new Motion();
                    int number1 = motion.makeMotion();

                    if (mainCharacter.getSkills()[number1].isAvailability()) {
                        int damage = mainCharacter.getSkills()[number1].getDamage();
                        int protection = mainCharacter.getSkills()[number1].getProtection();
                        mainCharacter.addProtection(protection);

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

                    if (mainCharacter.getSkills()[number1].getThing().equals("healing")) {
                        mainCharacter.addHealth(10);
                    }
                    System.out.println("Герой сделал ход " + mainCharacter.getSkills()[number1].getThing());
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
                            if (mainCharacter.getClothes()[i].isAvailability()) {
                                protection += clothes[i].getProtection();
                            }
                        }
                        if (damage != 0) {
                            int attack = mainCharacter.getProtection() + protection - damage;
                            if (attack < 0) {
                                mainCharacter.monsterAttack(abs(attack));
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

        if (mainCharacter.getHealth() > 0) {
            int x = 0;
            boolean flag = true;
            while (flag) {
                int min1 = 0;
                int max1 = 3;
                int diff1 = max1 - min1;
                Random random1 = new Random();
                int number2 = random1.nextInt(diff1 + 1);
                number2 += min1;

                if (!mainCharacter.getClothes()[number2].isAvailability()) {
                    mainCharacter.getClothes()[number2].setAvailability(true);
                    //mainCharacter.addProtection(mainCharacter.getClothes()[number2].getProtection());
                    x = number2;
                    flag = false;
                }
            }

            mainCharacter.setHealth(100);
            mainCharacter.setProtection(0);
            System.out.println("Монстр повержен! Поздравляю!");
            System.out.println("Вы выиграли первый акт. Ваша награда " + mainCharacter.getClothes()[x].getThing());
            System.out.println("Это +" + mainCharacter.getClothes()[x].getProtection() + " к вашей защите!");
        }
    }

    public void startAct2(MainCharacter mainCharacter) {
        System.out.println("========== Акт второй ==========");

        Four[] clothes = new Four[4];
        clothes[0] = new Four("helmet", 0, 5, false);
        clothes[1] = new Four("shoes", 0, 5, false);
        clothes[2] = new Four("pants", 0, 5, false);
        clothes[3] = new Four("chain mail", 0, 10, false);

        Four[] skills = new Four[4];
        skills[0] = new Four("hit", 7, 0, true);
        skills[1] = new Four("hard blow", 15, 0, true);
        skills[2] = new Four("protection", 0, 5, true);
        skills[3] = new Four("healing", 0, 0, true);

        Monster monster = new Monster("Monster1", clothes, skills, 70, 0);

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

        while (mainCharacter.getHealth() > 0 && monster.getHealth() > 0) {
            mainCharacter.printHealthAndProtection();
            monster.printHealthAndProtection();
            switch (number) {
                case 0:                                //ход игрока
                    mainCharacter.printSkills();
                    Motion motion = new Motion();
                    int number1 = motion.makeMotion();

                    if (mainCharacter.getSkills()[number1].isAvailability()) {
                        int damage = mainCharacter.getSkills()[number1].getDamage();
                        int protection = mainCharacter.getSkills()[number1].getProtection();
                        mainCharacter.addProtection(protection);

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

                    if (mainCharacter.getSkills()[number1].getThing().equals("healing")) {
                        mainCharacter.addHealth(10);
                    }
                    System.out.println("Герой сделал ход " + mainCharacter.getSkills()[number1].getThing());
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
                            if (mainCharacter.getClothes()[i].isAvailability()) {
                                protection += clothes[i].getProtection();
                            }
                        }
                        if (damage != 0) {
                            int attack = mainCharacter.getProtection() + protection - damage;
                            if (attack < 0) {
                                mainCharacter.monsterAttack(abs(attack));
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

        if (mainCharacter.getHealth() > 0) {
            int x = 0;
            boolean flag = true;
            while (flag) {
                int min1 = 0;
                int max1 = 3;
                int diff1 = max1 - min1;
                Random random1 = new Random();
                int number2 = random1.nextInt(diff1 + 1);
                number2 += min1;

                if (!mainCharacter.getClothes()[number2].isAvailability()) {
                    mainCharacter.getClothes()[number2].setAvailability(true);
                    //mainCharacter.addProtection(mainCharacter.getClothes()[number2].getProtection());
                    x = number2;
                    flag = false;
                }
            }

            mainCharacter.setHealth(100);
            mainCharacter.setProtection(0);
            System.out.println("Монстр повержен! Поздравляю!");
            System.out.println("Вы выиграли первый акт. Ваша награда " + mainCharacter.getClothes()[x].getThing());
            System.out.println("Это +" + mainCharacter.getClothes()[x].getProtection() + " к вашей защите!");
        }
    }
}
